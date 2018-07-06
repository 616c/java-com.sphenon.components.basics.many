package com.sphenon.basics.many;

/****************************************************************************
  Copyright 2001-2018 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;

public class ExpiringMap<K, V> implements Map<K, V> {

    private final Map<K, V> value_map;
    private final Map<K, ExpiringKey<K>> key_map;

    private final DelayQueue<ExpiringKey> delayQueue = new DelayQueue<ExpiringKey>();

    private final long max_life_time_millis;

    public ExpiringMap() {
        value_map = new ConcurrentHashMap<K, V>();
        key_map = new WeakHashMap<K, ExpiringKey<K>>();
        this.max_life_time_millis = Long.MAX_VALUE;
    }

    public ExpiringMap(long default_max_life_time_millis) {
        value_map = new ConcurrentHashMap<K, V>();
        key_map = new WeakHashMap<K, ExpiringKey<K>>();
        this.max_life_time_millis = default_max_life_time_millis;
    }

    public ExpiringMap(long default_max_life_time_millis, int initial_capacity) {
        value_map = new ConcurrentHashMap<K, V>(initial_capacity);
        key_map = new WeakHashMap<K, ExpiringKey<K>>(initial_capacity);
        this.max_life_time_millis = default_max_life_time_millis;
    }

    public ExpiringMap(long default_max_life_time_millis, int initial_capacity, float load_factor) {
        value_map = new ConcurrentHashMap<K, V>(initial_capacity, load_factor);
        key_map = new WeakHashMap<K, ExpiringKey<K>>(initial_capacity, load_factor);
        this.max_life_time_millis = default_max_life_time_millis;
    }

    public int size() {
        cleanup();
        return value_map.size();
    }

    public boolean isEmpty() {
        cleanup();
        return value_map.isEmpty();
    }

    public boolean containsKey(Object key) {
        cleanup();
        return value_map.containsKey((K) key);
    }

    public boolean containsValue(Object value) {
        cleanup();
        return value_map.containsValue((V) value);
    }

    public V get(Object key) {
        cleanup();
        renewKey((K) key);
        return value_map.get((K) key);
    }

    public V put(K key, V value) {
        return this.put(key, value, max_life_time_millis);
    }

    public K putAndReturnKey(K key, V value) {
        this.put(key, value);
        return key;
    }

    public V putAndReturnValue(K key, V value) {
        this.put(key, value);
        return value;
    }

    public V put(K key, V value, long life_time_millis) {
        cleanup();
        ExpiringKey delayed_key = new ExpiringKey(key, life_time_millis);
        ExpiringKey old_key = key_map.put((K) key, delayed_key);
        if(old_key != null) {
            expireKey(old_key);
            key_map.put((K) key, delayed_key);
        }
        delayQueue.offer(delayed_key);
        return value_map.put(key, value);
    }

    public K putAndReturnKey(K key, V value, long life_time_millis) {
        this.put(key, value, life_time_millis);
        return key;
    }

    public V putAndReturnValue(K key, V value, long life_time_millis) {
        this.put(key, value, life_time_millis);
        return value;
    }

    public V remove(Object key) {
        V removed_value = value_map.remove((K) key);
        expireKey(key_map.remove((K) key));
        return removed_value;
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    public boolean renewKey(K key) {
        ExpiringKey<K> delayed_key = key_map.get((K) key);
        if (delayed_key != null) {
            delayed_key.renew();
            return true;
        }
        return false;
    }

    private void expireKey(ExpiringKey<K> delayed_key) {
        if (delayed_key != null) {
            delayed_key.expire();
            cleanup();
        }
    }

    public void clear() {
        delayQueue.clear();
        key_map.clear();
        value_map.clear();
    }

    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    private void cleanup() {
        ExpiringKey<K> delayed_key = delayQueue.poll();
        while (delayed_key != null) {
            value_map.remove(delayed_key.getKey());
            key_map.remove(delayed_key.getKey());
            delayed_key = delayQueue.poll();
        }
    }

    private class ExpiringKey<K> implements Delayed {

        private long startTime = System.currentTimeMillis();
        private final long max_life_time_millis;
        private final K key;

        public ExpiringKey(K key, long max_life_time_millis) {
            this.max_life_time_millis = max_life_time_millis;
            this.key = key;
        }

        public K getKey() {
            return key;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ExpiringKey<K> other = (ExpiringKey<K>) obj;
            if (this.key != other.key && (this.key == null || !this.key.equals(other.key))) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + (this.key != null ? this.key.hashCode() : 0);
            return hash;
        }

        public long getDelay(TimeUnit unit) {
            return unit.convert(getDelayMillis(), TimeUnit.MILLISECONDS);
        }

        private long getDelayMillis() {
            return (startTime + max_life_time_millis) - System.currentTimeMillis();
        }

        public void renew() {
            startTime = System.currentTimeMillis();
        }

        public void expire() {
            startTime =  System.currentTimeMillis() - max_life_time_millis - 1;
        }

        public int compareTo(Delayed that) {
            return Long.compare(this.getDelayMillis(), ((ExpiringKey) that).getDelayMillis());
        }
    }
}
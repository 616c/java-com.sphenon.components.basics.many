package com.sphenon.basics.many;

/****************************************************************************
  Copyright 2001-2024 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;

public class DoubleWeakHashMap<K,V> {

    protected HashMap<HashableWeakReference<K>,WeakReference<V>> map;

    public DoubleWeakHashMap(HashMap<HashableWeakReference<K>,WeakReference<V>> map) {
        this.map = map;
    }

    public DoubleWeakHashMap() {
        this.map = new HashMap<HashableWeakReference<K>,WeakReference<V>>();
    }

    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        return new DoubleWeakHashMap<K,V>((HashMap<HashableWeakReference<K>,WeakReference<V>>) this.map.clone());
    }

    public boolean containsKey(Object key) {
        return this.map.containsKey(new HashableWeakReference<K>((K)key));
    }

    public V get(Object key) {
        WeakReference<V> wrv = this.map.get(new HashableWeakReference<K>((K)key));
        return wrv == null ? null : wrv.get();
    }
    
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<HashableWeakReference<K>> keySet() {
        return this.map.keySet();
    }
    
    public V put(K key, V value) {
        WeakReference<V> wrv = this.map.put(new HashableWeakReference<K>(key), new WeakReference<V>(value));
        return wrv == null ? null : wrv.get();
    }

    public V remove(Object key){
        WeakReference<V> wrv = this.map.remove(new HashableWeakReference<K>((K)key));
        return wrv == null ? null : wrv.get();
    }

    public int size() {
        return this.map.size();
    }
}

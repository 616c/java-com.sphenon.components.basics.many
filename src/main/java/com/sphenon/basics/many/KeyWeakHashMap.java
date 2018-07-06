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

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;

public class KeyWeakHashMap<K,V> {

    protected HashMap<HashableWeakReference<K>,V> map;

    public KeyWeakHashMap(HashMap<HashableWeakReference<K>,V> map) {
        this.map = map;
    }

    public KeyWeakHashMap() {
        this.map = new HashMap<HashableWeakReference<K>,V>();
    }

    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        return new KeyWeakHashMap<K,V>((HashMap<HashableWeakReference<K>,V>) this.map.clone());
    }

    public boolean containsKey(Object key) {
        return this.map.containsKey(new HashableWeakReference<K>((K)key));
    }

    public V get(Object key) {
        V v = this.map.get(new HashableWeakReference<K>((K)key));
        return v;
    }
    
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<HashableWeakReference<K>> keySet() {
        return this.map.keySet();
    }
    
    public V put(K key, V value) {
        V v = this.map.put(new HashableWeakReference<K>(key), value);
        return v;
    }

    public V remove(Object key){
        V v = this.map.remove(new HashableWeakReference<K>((K)key));
        return v;
    }

    public int size() {
        return this.map.size();
    }
}

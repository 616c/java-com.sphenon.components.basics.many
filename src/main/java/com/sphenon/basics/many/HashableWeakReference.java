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

public class HashableWeakReference<T> extends WeakReference<T> {
    public HashableWeakReference(T referent) {
        super(referent);
    }

    protected int last_hash_code = 0;

    public int hashCode() {
        T t = this.get();
        return t == null ? last_hash_code : (last_hash_code = t.hashCode());
    }

    public boolean equals(Object obj) {
        T t = this.get();
        return (    obj != null
                 && (    (t != null && obj.equals(t))
                      || (    obj instanceof WeakReference
                           && (    this == obj
                                || (t != null && t.equals( ((WeakReference<T>)obj).get() ))
                              )
                         )
                    )
               );
    }
}

// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/MapImpl.javatpl

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
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Hashtable;

public class MapImpl_long_long_
  implements Map_long_long_
{
    private java.util.Hashtable map;

    public MapImpl_long_long_ (CallContext context) {
        map = new java.util.Hashtable ();
    }

    public MapImpl_long_long_ (CallContext context, java.util.Hashtable map ) {
        this.map = map;
    }

    public long get     (CallContext context, long index) throws DoesNotExist {
        Object item = map.get(new Long(index));
        if (item == null) DoesNotExist.createAndThrow(context, "Map entry '%(index)'", "index", com.sphenon.basics.message.t.s(index));
        return ((Long) item).longValue();
    }

    public long tryGet  (CallContext context, long index) {
        Long typeditem = (Long) map.get(new Long(index));
        return (typeditem).longValue();
    }

    public boolean  canGet  (CallContext context, long index) {
        return map.containsKey(new Long(index));
    }

    public MapReferenceToMember_long_long_ getReference (CallContext context, long index) throws DoesNotExist {
        if ( ! canGet(context, index)) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return new MapReferenceToMember_long_long_(context, this, index);
    }

    public MapReferenceToMember_long_long_ tryGetReference (CallContext context, long index) {
        if ( ! canGet(context, index)) { return null; }
        return new MapReferenceToMember_long_long_(context, this, index);
    }

    public void     set     (CallContext context, long index, long item) {
        map.put(new Long(index), new Long(item));
    }

    public void     add     (CallContext context, long index, long item) throws AlreadyExists {
        if (map.containsKey(new Long(index))) AlreadyExists.createAndThrow (context);
        map.put(new Long(index), new Long(item));
    }

    public void     replace (CallContext context, long index, long item) throws DoesNotExist {
        if (!map.containsKey(new Long(index))) DoesNotExist.createAndThrow (context);
        map.put(new Long(index), new Long(item));
    }

    public void     unset   (CallContext context, long index) {
        map.remove(new Long(index));
    }

    public void     remove  (CallContext context, long index) throws DoesNotExist {
        if (!map.containsKey(new Long(index))) DoesNotExist.createAndThrow (context);
        map.remove(new Long(index));
    }

    public IteratorItemIndex_long_long_ getNavigator (CallContext context) {
        return new MapIteratorImpl_long_long_ (context, map, this);
    }

    public long     getSize (CallContext context) {
        return map.size();
    }

    // to be used with care
    public java.util.Hashtable getImplementationMap (CallContext context) {
        return this.map;
    }
}


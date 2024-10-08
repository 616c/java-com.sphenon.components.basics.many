// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/MapImpl.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Hashtable;

public class MapImpl_String_long_
  implements Map_String_long_
{
    private java.util.Hashtable map;

    public MapImpl_String_long_ (CallContext context) {
        map = new java.util.Hashtable ();
    }

    public MapImpl_String_long_ (CallContext context, java.util.Hashtable map ) {
        this.map = map;
    }

    public String get     (CallContext context, long index) throws DoesNotExist {
        Object item = map.get(new Long(index));
        if (item == null) DoesNotExist.createAndThrow(context, "Map entry '%(index)'", "index", com.sphenon.basics.message.t.s(index));
        return (String) item;
    }

    public String tryGet  (CallContext context, long index) {
        String typeditem = (String) map.get(new Long(index));
        return typeditem;
    }

    public boolean  canGet  (CallContext context, long index) {
        return map.containsKey(new Long(index));
    }

    public MapReferenceToMember_String_long_ getReference (CallContext context, long index) throws DoesNotExist {
        if ( ! canGet(context, index)) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return new MapReferenceToMember_String_long_(context, this, index);
    }

    public MapReferenceToMember_String_long_ tryGetReference (CallContext context, long index) {
        if ( ! canGet(context, index)) { return null; }
        return new MapReferenceToMember_String_long_(context, this, index);
    }

    public void     set     (CallContext context, long index, String item) {
        map.put(new Long(index), item);
    }

    public void     add     (CallContext context, long index, String item) throws AlreadyExists {
        if (map.containsKey(new Long(index))) AlreadyExists.createAndThrow (context);
        map.put(new Long(index), item);
    }

    public void     replace (CallContext context, long index, String item) throws DoesNotExist {
        if (!map.containsKey(new Long(index))) DoesNotExist.createAndThrow (context);
        map.put(new Long(index), item);
    }

    public void     unset   (CallContext context, long index) {
        map.remove(new Long(index));
    }

    public void     remove  (CallContext context, long index) throws DoesNotExist {
        if (!map.containsKey(new Long(index))) DoesNotExist.createAndThrow (context);
        map.remove(new Long(index));
    }

    public IteratorItemIndex_String_long_ getNavigator (CallContext context) {
        return new MapIteratorImpl_String_long_ (context, map, this);
    }

    public long     getSize (CallContext context) {
        return map.size();
    }

    // to be used with care
    public java.util.Hashtable getImplementationMap (CallContext context) {
        return this.map;
    }
}


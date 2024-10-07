// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/MapImpl.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Hashtable;

public class MapImpl_String_String_
  implements Map_String_String_
{
    private java.util.Hashtable map;

    public MapImpl_String_String_ (CallContext context) {
        map = new java.util.Hashtable ();
    }

    public MapImpl_String_String_ (CallContext context, java.util.Hashtable map ) {
        this.map = map;
    }

    public String get     (CallContext context, String index) throws DoesNotExist {
        Object item = map.get(index);
        if (item == null) DoesNotExist.createAndThrow(context, "Map entry '%(index)'", "index", com.sphenon.basics.message.t.s(index));
        return (String) item;
    }

    public String tryGet  (CallContext context, String index) {
        String typeditem = (String) map.get(index);
        return typeditem;
    }

    public boolean  canGet  (CallContext context, String index) {
        return map.containsKey(index);
    }

    public MapReferenceToMember_String_String_ getReference (CallContext context, String index) throws DoesNotExist {
        if ( ! canGet(context, index)) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return new MapReferenceToMember_String_String_(context, this, index);
    }

    public MapReferenceToMember_String_String_ tryGetReference (CallContext context, String index) {
        if ( ! canGet(context, index)) { return null; }
        return new MapReferenceToMember_String_String_(context, this, index);
    }

    public void     set     (CallContext context, String index, String item) {
        map.put(index, item);
    }

    public void     add     (CallContext context, String index, String item) throws AlreadyExists {
        if (map.containsKey(index)) AlreadyExists.createAndThrow (context);
        map.put(index, item);
    }

    public void     replace (CallContext context, String index, String item) throws DoesNotExist {
        if (!map.containsKey(index)) DoesNotExist.createAndThrow (context);
        map.put(index, item);
    }

    public void     unset   (CallContext context, String index) {
        map.remove(index);
    }

    public void     remove  (CallContext context, String index) throws DoesNotExist {
        if (!map.containsKey(index)) DoesNotExist.createAndThrow (context);
        map.remove(index);
    }

    public IteratorItemIndex_String_String_ getNavigator (CallContext context) {
        return new MapIteratorImpl_String_String_ (context, map, this);
    }

    public long     getSize (CallContext context) {
        return map.size();
    }

    // to be used with care
    public java.util.Hashtable getImplementationMap (CallContext context) {
        return this.map;
    }
}


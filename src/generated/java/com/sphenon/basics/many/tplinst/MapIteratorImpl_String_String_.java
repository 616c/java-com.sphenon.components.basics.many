// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/MapIteratorImpl.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Hashtable;

public class MapIteratorImpl_String_String_
    implements IteratorItemIndex_String_String_
{
    private Map_String_String_ map_t;
    private java.util.Hashtable map;
    private java.util.Set entry_set;
    private java.util.Iterator iterator;
    private java.util.Map.Entry me;

    public MapIteratorImpl_String_String_ (CallContext context, java.util.Hashtable map, Map_String_String_ map_t) {
        this.map_t = map_t;
        this.map = map;
        this.entry_set = map.entrySet();
        this.iterator = entry_set.iterator();
        if (this.iterator.hasNext()) {
            me = (java.util.Map.Entry) this.iterator.next();
        } else {
            me = null;
        }
    }

    public void     next          (CallContext context) {
        if (this.iterator.hasNext()) {
            me = (java.util.Map.Entry) this.iterator.next();
        } else {
            me = null;
        }
    }

    public String getCurrentIndex (CallContext context) throws DoesNotExist {
        if ( ! canGetCurrent(context)) { DoesNotExist.createAndThrow(context); }
        return (String) me.getKey();
    }

    public String tryGetCurrentIndex (CallContext context) {
        if ( ! canGetCurrent(context)) { return null; }
        return (String) me.getKey();
    }

    public String getCurrent (CallContext context) throws DoesNotExist {
        if ( ! canGetCurrent(context)) { DoesNotExist.createAndThrow(context); }
        return (String) me.getValue();
    }

    public String tryGetCurrent (CallContext context) {
        if ( ! canGetCurrent(context)) { return null; }
        return (String) me.getValue();
    }

    public boolean  canGetCurrent (CallContext context) {
        return (this.me != null) ? true : false;
    }

    public Reference_String_ getReferenceToCurrent (CallContext context) throws DoesNotExist {
        return map_t.getReference(context, this.getCurrentIndex(context));
    }

    public Reference_String_ tryGetReferenceToCurrent (CallContext context) {
        if ( ! canGetCurrent(context)) { return null; }
        return map_t.tryGetReference(context, this.tryGetCurrentIndex(context));
    }

    public MapIteratorImpl_String_String_ clone(CallContext context) {
        CustomaryContext.create((Context)context).throwLimitation(context, "cannot clone, map entry set iterator is not cloneable");
        throw (ExceptionLimitation) null; // compiler insists
    }
}

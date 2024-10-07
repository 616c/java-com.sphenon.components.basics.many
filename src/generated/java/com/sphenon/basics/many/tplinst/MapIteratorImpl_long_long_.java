// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/MapIteratorImpl.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Hashtable;

public class MapIteratorImpl_long_long_
    implements IteratorItemIndex_long_long_
{
    private Map_long_long_ map_t;
    private java.util.Hashtable map;
    private java.util.Set entry_set;
    private java.util.Iterator iterator;
    private java.util.Map.Entry me;

    public MapIteratorImpl_long_long_ (CallContext context, java.util.Hashtable map, Map_long_long_ map_t) {
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

    public long getCurrentIndex (CallContext context) throws DoesNotExist {
        if ( ! canGetCurrent(context)) { DoesNotExist.createAndThrow(context); }
        return ((Long) me.getKey()).longValue();
    }

    public long tryGetCurrentIndex (CallContext context) {
        if ( ! canGetCurrent(context)) { return 0L; }
        return ((Long) me.getKey()).longValue();
    }

    public long getCurrent (CallContext context) throws DoesNotExist {
        if ( ! canGetCurrent(context)) { DoesNotExist.createAndThrow(context); }
        return ((Long) me.getValue()).longValue();
    }

    public long tryGetCurrent (CallContext context) {
        if ( ! canGetCurrent(context)) { return 0L; }
        return ((Long) me.getValue()).longValue();
    }

    public boolean  canGetCurrent (CallContext context) {
        return (this.me != null) ? true : false;
    }

    public Reference_long_ getReferenceToCurrent (CallContext context) throws DoesNotExist {
        return map_t.getReference(context, this.getCurrentIndex(context));
    }

    public Reference_long_ tryGetReferenceToCurrent (CallContext context) {
        if ( ! canGetCurrent(context)) { return null; }
        return map_t.tryGetReference(context, this.tryGetCurrentIndex(context));
    }

    public MapIteratorImpl_long_long_ clone(CallContext context) {
        CustomaryContext.create((Context)context).throwLimitation(context, "cannot clone, map entry set iterator is not cloneable");
        throw (ExceptionLimitation) null; // compiler insists
    }
}

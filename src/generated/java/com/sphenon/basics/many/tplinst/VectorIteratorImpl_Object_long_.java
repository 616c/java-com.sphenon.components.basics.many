// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorIteratorImpl.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Hashtable;

public class VectorIteratorImpl_Object_long_
    implements IteratorItemIndex_Object_long_,
               Cloneable
{
    private ReadOnlyVector_Object_long_ vector;
    private long current_index;

    public VectorIteratorImpl_Object_long_ (CallContext context, ReadOnlyVector_Object_long_ vector) {
        this.vector = vector;
        this.current_index = 0;
    }

    public void     next          (CallContext context) {
        // if (this.current_index < this.vector.getSize(context))
           this.current_index++;
    }

    public long getCurrentIndex (CallContext context) throws DoesNotExist {
        return this.current_index;
    }

    public long tryGetCurrentIndex (CallContext context) {
        return this.current_index;
    }

    public Object getCurrent    (CallContext context) throws DoesNotExist {
        return vector.get(context, this.current_index);
    }

    public Object tryGetCurrent (CallContext context) {
        return vector.tryGet(context, this.current_index);
    }

    public boolean  canGetCurrent (CallContext context) {
        return vector.canGet(context, this.current_index);
    }

    public Reference_Object_ getReferenceToCurrent (CallContext context) throws DoesNotExist {
        return vector.getReference(context, this.current_index);
    }

    public Reference_Object_ tryGetReferenceToCurrent (CallContext context) {
        return vector.tryGetReference(context, this.current_index);
    }

    public VectorIteratorImpl_Object_long_ clone(CallContext context) {
        try {
            return (VectorIteratorImpl_Object_long_) super.clone();
        } catch (CloneNotSupportedException cnse) { return null; }
    }
}

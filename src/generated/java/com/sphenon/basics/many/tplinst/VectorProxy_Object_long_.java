// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorProxy.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class VectorProxy_Object_long_
  implements Vector_Object_long_, VectorReorderable<Object>, ManagedResource
{
    protected Vector_Object_long_ vector;

    public VectorProxy_Object_long_ (CallContext context, Vector_Object_long_ vector) {
        this.vector = vector;
    }

    public void setVector (CallContext context, Vector_Object_long_ vector) {
        this.vector = vector;
    }

    public Vector_Object_long_ getVector (CallContext context) {
        return vector;
    }

    public Object                                    get             (CallContext context, long index) throws DoesNotExist {
        return this.getVector(context).get(context, index);
    }

    public Object                                    tryGet          (CallContext context, long index) {
        return this.getVector(context).tryGet(context, index);
    }

    public boolean                                     canGet          (CallContext context, long index) {
        return this.getVector(context).canGet(context, index);
    }

    public ReferenceToMember_Object_long_ReadOnlyVector_Object_long__ getReference    (CallContext context, long index) throws DoesNotExist {
        return this.getVector(context).getReference(context, index);
    }

    public ReferenceToMember_Object_long_ReadOnlyVector_Object_long__ tryGetReference (CallContext context, long index) {
        return this.getVector(context).tryGetReference(context, index);
    }

    public Object                                    set             (CallContext context, long index, Object item) {
        return this.getVector(context).set(context, index, item);
    }

    public void                                        add             (CallContext context, long index, Object item) throws AlreadyExists {
        this.getVector(context).add(context, index, item);
    }

    public void                                        prepend         (CallContext context, Object item) {
        this.getVector(context).prepend(context, item);
    }

    public void                                        append          (CallContext context, Object item) {
        this.getVector(context).append(context, item);
    }

    public void                                        insertBefore    (CallContext context, long index, Object item) throws DoesNotExist {
        this.getVector(context).insertBefore(context, index, item);
    }

    public void                                        insertBehind    (CallContext context, long index, Object item) throws DoesNotExist {
        this.getVector(context).insertBehind(context, index, item);
    }

    public Object                                    replace         (CallContext context, long index, Object item) throws DoesNotExist {
        return this.getVector(context).replace(context, index, item);
    }

    public Object                                    unset           (CallContext context, long index) {
        return this.getVector(context).unset(context, index);
    }

    public Object                                    remove          (CallContext context, long index) throws DoesNotExist {
        return this.getVector(context).remove(context, index);
    }

    public IteratorItemIndex_Object_long_       getNavigator    (CallContext context) {
        return this.getVector(context).getNavigator(context);
    }

    public long                                        getSize         (CallContext context) {
        return this.getVector(context).getSize(context);
    }

    public java.util.Iterator<Object> getIterator_Object_ (CallContext context) {
        return this.getVector(context).getIterator_Object_(context);
    }

    public java.util.Iterator getIterator (CallContext context) {
        return getIterator_Object_(context);
    }

    public VectorIterable_Object_long_ getIterable_Object_ (CallContext context) {
        return new VectorIterable_Object_long_(context, this);
    }

    public Iterable<Object> getIterable (CallContext context) {
        return getIterable_Object_ (context);
    }
    
    public void release(CallContext context) {
        if (this.vector != null && this.vector instanceof ManagedResource) {
            ((ManagedResource)(this.vector)).release(context);
        }
    }

    public boolean isReorderable(CallContext context) {
        return (this.getVector(context) instanceof VectorReorderable && ((VectorReorderable)(this.getVector(context))).isReorderable(context));
    }

    public void move (CallContext context, long from_index, long to_index) throws DoesNotExist {
        ((VectorReorderable)(this.getVector(context))).move(context, from_index, to_index);
    }
}


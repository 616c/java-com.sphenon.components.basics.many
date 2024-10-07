// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorImpl.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import com.sphenon.basics.interaction.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
// import com.sphenon.basics.monitoring.*;
// @review:wm
// zusätzliche includes müssen beim instantiieren angegeben werden,
// sie dürfen nicht direkt ins template eingetragen werden
// anderfalls würde eine dependency von *jeder* instant zu diesem
// package entstehen
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.debug.*;
import com.sphenon.basics.many.*;

import com.sphenon.basics.many.returncodes.*;

public class VectorImpl_Object_long_
  implements Vector_Object_long_,
             VectorOptimized<Object>,
             Dumpable,
             ManagedResource
             , Anchorable
 {
    private java.util.Vector vector;

    protected VectorImpl_Object_long_ (CallContext context) {
        vector = new java.util.Vector(4);
    }

    static public VectorImpl_Object_long_ create (CallContext context) {
        return new VectorImpl_Object_long_(context);
    }

    protected VectorImpl_Object_long_ (CallContext context, java.util.Vector vector) {
        this.vector = vector;
    }

    static public VectorImpl_Object_long_ create (CallContext context, java.util.Vector vector) {
        return new VectorImpl_Object_long_(context, vector);
    }

    

    // -----------------------------------------------------------------------
    // -- Anchorable ---------------------------------------------------------
    public Anchor_Vector_Object_long_ createAnchor(CallContext context, Workspace workspace, Transaction transaction) {
        return new Anchor_Vector_Object_long_(context, this, workspace, transaction);
    }
    // -----------------------------------------------------------------------

    public Object get          (CallContext context, long index) throws DoesNotExist {
        try {
            return (Object) vector.elementAt((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
    }

    public Object tryGet       (CallContext context, long index) {
        try {
            return (Object) vector.elementAt((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public boolean  canGet       (CallContext context, long index) {
        return (index >= 0 && index < vector.size()) ? true : false;
    }

    public VectorReferenceToMember_Object_long_ getReference    (CallContext context, long index) throws DoesNotExist {
        if ( ! canGet(context, index)) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return new VectorReferenceToMember_Object_long_(context, this, index);
    }

    public VectorReferenceToMember_Object_long_ tryGetReference (CallContext context, long index) {
        if ( ! canGet(context, index)) { return null; }
        return new VectorReferenceToMember_Object_long_(context, this, index);
    }

    public Object set          (CallContext context, long index, Object item) {
        if (index >= vector.size()) { vector.setSize((int) (index+1)); }
        return (Object) vector.set((int) index, item);
    }

    public void     add          (CallContext context, long index, Object item) throws AlreadyExists {
        if (index < vector.size()) { AlreadyExists.createAndThrow (context); }
        vector.setSize((int) (index+1));
        vector.setElementAt(item, (int) index);
    }

    public void     prepend      (CallContext call_context, Object item) {
        if (vector.size() == 0) {
            vector.add(item);
        } else {
            try {
                vector.insertElementAt(item, 0);
            } catch (ArrayIndexOutOfBoundsException e) {
                Context context = Context.create(call_context);
                CustomaryContext cc = CustomaryContext.create(context);
                cc.throwImpossibleState(context, ManyStringPool.get(context, "0.0.1" /* cannot insert element at position 0, java-lib says 'out of bounds' ??? */));
            }
        }
    }

    public void     append       (CallContext context, Object item) {
        vector.add(item);
    }

    public void     insertBefore (CallContext context, long index, Object item) throws DoesNotExist {
        try {
            vector.insertElementAt(item, (int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(context);
        }
    }

    public void     insertBehind (CallContext context, long index, Object item) throws DoesNotExist {
        if (index == vector.size() - 1) {
            vector.add(item);
        } else {
            try {
                vector.insertElementAt(item, (int) (index+1));
            } catch (ArrayIndexOutOfBoundsException e) {
                DoesNotExist.createAndThrow (context);
            }
        }
    }

    public Object replace      (CallContext call_context, long index, Object item) throws DoesNotExist {
        try {
            return (Object) vector.set((int) index, item);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(call_context);
            throw (DoesNotExist) null;
        } catch (IllegalArgumentException e) {
            Context context = Context.create(call_context);
            CustomaryContext cc = CustomaryContext.create(context);
            cc.throwImpossibleState (context, ManyStringPool.get(context, "0.0.2" /* An exception occured, with respect to which the java-lib documentation is unfortunately incorrect */));
            throw (ExceptionImpossibleState) null;
        }
    }

    public Object unset        (CallContext context, long index) {
        try {
            return (Object) vector.remove((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            // we kindly ignore this exception
            return null;
        }
    }

    public Object remove       (CallContext context, long index) throws DoesNotExist {
        try {
            return (Object) vector.remove((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null;
        }
    }

    public IteratorItemIndex_Object_long_ getNavigator (CallContext context) {
        return new VectorIteratorImpl_Object_long_ (context, this);
    }

    public long     getSize      (CallContext context) {
        return vector.size();
    }

    public java.util.Iterator<Object> getIterator_Object_ (CallContext context) {
        return vector.iterator();
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

    public java.util.Vector getImplementationVector(CallContext context){
      return this.vector;
    }

    public void setImplementationVector(CallContext context, java.util.Vector vector){
      this.vector = vector;
    }

    public boolean contains(CallContext context, Object item) {
        return this.vector.contains(item);
    }

    public boolean removeFirst(CallContext context, Object item) {
        return this.vector.remove(item);
    }

    public void removeAll(CallContext context, Object item, VectorOptimized.Notifier<Object> notifier) {
        java.util.Iterator i = this.vector.iterator();
        while (i.hasNext()) {
            if (i.next() == item) {
                i.remove();
                if (notifier != null) { notifier.onRemove(context, item); }
            }
        }
    }


    public void release(CallContext context) {
        if (this.vector != null && this.vector instanceof ManagedResource) {
            ((ManagedResource)(this.vector)).release(context);
        }
    }

    public void dump(CallContext context, DumpNode dump_node) {
        int i=1;
        for (Object o : vector) {
            dump_node.dump(context, (new Integer(i++)).toString(), o);
        }
    }
}

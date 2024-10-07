// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorImpl.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


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

public class VectorImpl_String_long_
  implements Vector_String_long_,
             VectorOptimized<String>,
             Dumpable,
             ManagedResource
 {
    private java.util.Vector vector;

    protected VectorImpl_String_long_ (CallContext context) {
        vector = new java.util.Vector(4);
    }

    static public VectorImpl_String_long_ create (CallContext context) {
        return new VectorImpl_String_long_(context);
    }

    protected VectorImpl_String_long_ (CallContext context, java.util.Vector vector) {
        this.vector = vector;
    }

    static public VectorImpl_String_long_ create (CallContext context, java.util.Vector vector) {
        return new VectorImpl_String_long_(context, vector);
    }

    

    public String get          (CallContext context, long index) throws DoesNotExist {
        try {
            return (String) vector.elementAt((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
    }

    public String tryGet       (CallContext context, long index) {
        try {
            return (String) vector.elementAt((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public boolean  canGet       (CallContext context, long index) {
        return (index >= 0 && index < vector.size()) ? true : false;
    }

    public VectorReferenceToMember_String_long_ getReference    (CallContext context, long index) throws DoesNotExist {
        if ( ! canGet(context, index)) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return new VectorReferenceToMember_String_long_(context, this, index);
    }

    public VectorReferenceToMember_String_long_ tryGetReference (CallContext context, long index) {
        if ( ! canGet(context, index)) { return null; }
        return new VectorReferenceToMember_String_long_(context, this, index);
    }

    public String set          (CallContext context, long index, String item) {
        if (index >= vector.size()) { vector.setSize((int) (index+1)); }
        return (String) vector.set((int) index, item);
    }

    public void     add          (CallContext context, long index, String item) throws AlreadyExists {
        if (index < vector.size()) { AlreadyExists.createAndThrow (context); }
        vector.setSize((int) (index+1));
        vector.setElementAt(item, (int) index);
    }

    public void     prepend      (CallContext call_context, String item) {
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

    public void     append       (CallContext context, String item) {
        vector.add(item);
    }

    public void     insertBefore (CallContext context, long index, String item) throws DoesNotExist {
        try {
            vector.insertElementAt(item, (int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(context);
        }
    }

    public void     insertBehind (CallContext context, long index, String item) throws DoesNotExist {
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

    public String replace      (CallContext call_context, long index, String item) throws DoesNotExist {
        try {
            return (String) vector.set((int) index, item);
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

    public String unset        (CallContext context, long index) {
        try {
            return (String) vector.remove((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            // we kindly ignore this exception
            return null;
        }
    }

    public String remove       (CallContext context, long index) throws DoesNotExist {
        try {
            return (String) vector.remove((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null;
        }
    }

    public IteratorItemIndex_String_long_ getNavigator (CallContext context) {
        return new VectorIteratorImpl_String_long_ (context, this);
    }

    public long     getSize      (CallContext context) {
        return vector.size();
    }

    public java.util.Iterator<String> getIterator_String_ (CallContext context) {
        return vector.iterator();
    }

    public java.util.Iterator getIterator (CallContext context) {
        return getIterator_String_(context);
    }

    public VectorIterable_String_long_ getIterable_String_ (CallContext context) {
        return new VectorIterable_String_long_(context, this);
    }

    public Iterable<String> getIterable (CallContext context) {
        return getIterable_String_ (context);
    }

    public java.util.Vector getImplementationVector(CallContext context){
      return this.vector;
    }

    public void setImplementationVector(CallContext context, java.util.Vector vector){
      this.vector = vector;
    }

    public boolean contains(CallContext context, String item) {
        return this.vector.contains(item);
    }

    public boolean removeFirst(CallContext context, String item) {
        return this.vector.remove(item);
    }

    public void removeAll(CallContext context, String item, VectorOptimized.Notifier<String> notifier) {
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

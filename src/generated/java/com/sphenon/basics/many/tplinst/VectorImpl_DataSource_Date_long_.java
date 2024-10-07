// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorImpl_DataSource.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import java.util.Date;

import java.util.Vector;
import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.many.*;
import com.sphenon.basics.many.tplinst.*;

import com.sphenon.basics.many.returncodes.*;

public class VectorImpl_DataSource_Date_long_
  implements Vector_Date_long_, ManagedResource {
    private com.sphenon.basics.data.DataSource<Vector> vector_source;

    public VectorImpl_DataSource_Date_long_ (CallContext context, com.sphenon.basics.data.DataSource<Vector> vector_source) {
        this.vector_source = vector_source;
    }

    static public VectorImpl_DataSource_Date_long_ create (CallContext context, com.sphenon.basics.data.DataSource<Vector> vector_source) {
        return new VectorImpl_DataSource_Date_long_(context, vector_source);
    }

    public Date get          (CallContext context, long index) throws DoesNotExist {
        try {
            return (Date) vector_source.get(context).elementAt((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
    }

    public Date tryGet       (CallContext context, long index) {
        try {
            return (Date) vector_source.get(context).elementAt((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public boolean  canGet       (CallContext context, long index) {
        return (index >= 0 && index < vector_source.get(context).size()) ? true : false;
    }

    public VectorReferenceToMember_Date_long_ getReference    (CallContext context, long index) throws DoesNotExist {
        if ( ! canGet(context, index)) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return new VectorReferenceToMember_Date_long_(context, this, index);
    }

    public VectorReferenceToMember_Date_long_ tryGetReference (CallContext context, long index) {
        if ( ! canGet(context, index)) { return null; }
        return new VectorReferenceToMember_Date_long_(context, this, index);
    }

    public Date set          (CallContext context, long index, Date item) {
        if (index >= vector_source.get(context).size()) { vector_source.get(context).setSize((int) (index+1)); }
        return (Date) vector_source.get(context).set((int) index, item);
    }

    public void     add          (CallContext context, long index, Date item) throws AlreadyExists {
        if (index < vector_source.get(context).size()) { AlreadyExists.createAndThrow (context); }
        vector_source.get(context).setSize((int) (index+1));
        vector_source.get(context).setElementAt(item, (int) index);
    }

    public void     prepend      (CallContext context, Date item) {
        if (vector_source.get(context).size() == 0) {
            vector_source.get(context).add(item);
        } else {
            try {
                vector_source.get(context).insertElementAt(item, 0);
            } catch (ArrayIndexOutOfBoundsException e) {
                CustomaryContext cc = CustomaryContext.create((Context)context);
                cc.throwImpossibleState(context, ManyStringPool.get(context, "0.0.1" /* cannot insert element at position 0, java-lib says 'out of bounds' ??? */));
            }
        }
    }

    public void     append       (CallContext context, Date item) {
        vector_source.get(context).add(item);
    }

    public void     insertBefore (CallContext context, long index, Date item) throws DoesNotExist {
        try {
            vector_source.get(context).insertElementAt(item, (int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(context);
        }
    }

    public void     insertBehind (CallContext context, long index, Date item) throws DoesNotExist {
        if (index == vector_source.get(context).size() - 1) {
            vector_source.get(context).add(item);
        } else {
            try {
                vector_source.get(context).insertElementAt(item, (int) (index+1));
            } catch (ArrayIndexOutOfBoundsException e) {
                DoesNotExist.createAndThrow (context);
            }
        }
    }

    public Date replace      (CallContext context, long index, Date item) throws DoesNotExist {
        try {
            return (Date) vector_source.get(context).set((int) index, item);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(context);
            throw (DoesNotExist) null;
        } catch (IllegalArgumentException e) {
            CustomaryContext cc = CustomaryContext.create((Context)context);
            cc.throwImpossibleState (context, ManyStringPool.get(context, "0.0.2" /* An exception occured, with respect to which the java-lib documentation is unfortunately incorrect */));
            throw (ExceptionImpossibleState) null;
        }
    }

    public Date unset        (CallContext context, long index) {
        try {
            return (Date) vector_source.get(context).remove((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            // we kindly ignore this exception
            return null;
        }
    }

    public Date remove       (CallContext context, long index) throws DoesNotExist {
        try {
            return (Date) vector_source.get(context).remove((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null;
        }
    }

    public IteratorItemIndex_Date_long_ getNavigator (CallContext context) {
        return new VectorIteratorImpl_Date_long_ (context, this);
    }

    public long     getSize      (CallContext context) {
        return vector_source.get(context).size();
    }

    public java.util.Iterator<Date> getIterator_Date_ (CallContext context) {
        return vector_source.get(context).iterator();
    }

    public java.util.Iterator getIterator (CallContext context) {
        return getIterator_Date_(context);
    }

    public VectorIterable_Date_long_ getIterable_Date_ (CallContext context) {
        return new VectorIterable_Date_long_(context, this);
    }

    public Iterable<Date> getIterable (CallContext context) {
        return getIterable_Date_ (context);
    }

    public void release(CallContext context) {
        if (this.vector_source != null && this.vector_source instanceof ManagedResource) {
            ((ManagedResource)(this.vector_source)).release(context);
        }
    }
}

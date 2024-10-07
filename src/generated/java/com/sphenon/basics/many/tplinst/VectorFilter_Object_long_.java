// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorFilter.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.many.*;

import com.sphenon.basics.many.returncodes.*;

public class VectorFilter_Object_long_
  implements Vector_Object_long_, ManagedResource {
    private Vector_Object_long_ vector;
    protected boolean caching;
    protected java.util.Vector<Long> index_map;
    protected long orig_index;

    public VectorFilter_Object_long_ (CallContext context, Vector_Object_long_ vector) {
        this.vector = vector;
    }

    public VectorFilter_Object_long_ (CallContext context, Vector_Object_long_ vector, boolean caching) {
        this.vector = vector;
        this.caching = caching;
    }

    public void setVector (CallContext context, Vector_Object_long_ vector) {
        this.vector = vector;
    }

    protected boolean isMatching(CallContext context, Object item, long orig_index) {
        return this.isMatching(context, item);
    }

    protected boolean isMatching(CallContext context, Object item) {
        return true;
    }

    protected long _getIndex(CallContext context, long filter_index) {
        long index = 0;
        if (caching) {
            if (index_map == null) {
                index_map = new java.util.Vector<Long>();
                orig_index = 0;
            }
            index = index_map.size();
            if (filter_index < index) {
                return index_map.get((int) filter_index);
            }
        } else {
            orig_index = 0;
        }
        long size = this.vector.getSize(context);
        if (size <= filter_index) {
            return -1;
        }
        for (; orig_index < size; orig_index++) {
            Object item = this.vector.tryGet(context, orig_index);
            if (isMatching(context, item, orig_index)) {
                if (caching) {
                    index_map.add(orig_index);
                }
                if (index == filter_index) { return orig_index++; }
                index++;
            }
        }
        return -1;
    }

    public Object get          (CallContext context, long index) throws DoesNotExist {
        Object result = this.tryGet(context, index);
        if (result == null) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return result;
    }

    public Object tryGet       (CallContext context, long index) {
        index = _getIndex(context, index);
        return index == -1 ? null : this.vector.tryGet(context, index);
    }

    public boolean  canGet       (CallContext context, long index) {
        index = _getIndex(context, index);
        return index != -1 ? true : false;
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

    public Object set          (CallContext context, long filter_index, Object item) {
        long index = _getIndex(context, filter_index);
        if (index == -1) {
            index = this.vector.getSize(context) + filter_index - this.getSize(context);
        }
        return this.vector.set(context, index, item);
    }

    public void     add          (CallContext context, long index, Object item) throws AlreadyExists {
        if (index < this.getSize(context)) { AlreadyExists.createAndThrow (context); }
        this.set(context, index, item);
    }

    public void     prepend      (CallContext context, Object item) {
        this.vector.prepend(context, item);
    }

    public void     append       (CallContext context, Object item) {
        this.vector.append(context, item);
    }

    public void     insertBefore (CallContext context, long index, Object item) throws DoesNotExist {
        index = _getIndex(context, index);
        this.vector.insertBefore(context, index, item);
    }

    public void     insertBehind (CallContext context, long index, Object item) throws DoesNotExist {
        index = _getIndex(context, index);
        this.vector.insertBehind(context, index, item);
    }

    public Object replace      (CallContext context, long index, Object item) throws DoesNotExist {
        index = _getIndex(context, index);
        return this.vector.replace(context, index, item);
    }

    public Object unset        (CallContext context, long index) {
        index = _getIndex(context, index);
        return this.vector.unset(context, index);
    }

    public Object remove       (CallContext context, long index) throws DoesNotExist {
        index = _getIndex(context, index);
        return this.vector.remove(context, index);
    }

    public IteratorItemIndex_Object_long_ getNavigator (CallContext context) {
        return new VectorIteratorImpl_Object_long_ (context, this);
    }

    public long     getSize      (CallContext context) {
        long index = 0;
        if (caching) {
            if (index_map == null) {
                index_map = new java.util.Vector<Long>();
                orig_index = 0;
            }
            index = index_map.size();
        } else {
            orig_index = 0;
        }
        long size = this.vector.getSize(context);
        for (; orig_index < size; orig_index++) {
            Object item = this.vector.tryGet(context, orig_index);
            if (isMatching(context, item, orig_index)) {
                if (caching) {
                    index_map.add(orig_index);
                }
                index++;
            }
        }
        return index;
    }

    protected class IteratorAdapter implements java.util.Iterator<Object> {
        protected IteratorItemIndex_Object_long_ iterator;
        protected CallContext context;
        public IteratorAdapter(CallContext context, IteratorItemIndex_Object_long_ iterator) {
            this.iterator = iterator;
            this.context = context;
        }
        public boolean hasNext() { return iterator.canGetCurrent(this.context); }
        public void remove() { throw new UnsupportedOperationException(); }
        public Object next() {
            if (iterator.canGetCurrent(this.context) == false) {
                throw new java.util.NoSuchElementException();
            }
            Object current = iterator.tryGetCurrent(this.context);
            iterator.next(this.context);
            return current;
        }
    }

    public java.util.Iterator<Object> getIterator_Object_ (CallContext context) {
        return new IteratorAdapter(context, this.getNavigator(context));
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
}

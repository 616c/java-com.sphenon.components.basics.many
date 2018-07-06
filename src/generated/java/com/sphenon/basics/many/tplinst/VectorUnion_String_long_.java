// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorUnion.javatpl

/****************************************************************************
  Copyright 2001-2018 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.many.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.many.returncodes.*;
// import com.sphenon.basics.event.*;
// import com.sphenon.basics.event.tplinst.*;

import com.sphenon.engines.aggregator.annotations.*;

public class VectorUnion_String_long_
  implements Vector_String_long_, ManagedResource
{
    protected Vector_Vector_String_long__long_ vectors;

    public VectorUnion_String_long_ (CallContext context) {
        this.vectors = null;
    }

    public VectorUnion_String_long_ (CallContext context, Vector_Vector_String_long__long_ vectors) {
        this.vectors = vectors;
    }

    public VectorUnion_String_long_ (CallContext context, Vector_String_long_... vectors) {
        this.vectors = Factory_Vector_Vector_String_long__long_.construct(context);
        for (Vector_String_long_ vector : vectors) {
            this.vectors.append(context, vector);
        }
    }

    public void setVectors (CallContext context, Vector_Vector_String_long__long_ vectors) {
        this.vectors = vectors;
    }

    @OCPIgnore
    public void setVectors (CallContext context, Vector_String_long_... vectors) {
        this.vectors = Factory_Vector_Vector_String_long__long_.construct(context);
        for (Vector_String_long_ vector : vectors) {
            this.vectors.append(context, vector);
        }
    }

    public void addVector(CallContext context, Vector_String_long_ vector) {
        if (this.vectors == null) {
            this.vectors = Factory_Vector_Vector_String_long__long_.construct(context);
        }
        this.vectors.append(context, vector);
    }

    public Vector_Vector_String_long__long_ getImplementationVector(CallContext context) {
        return this.vectors;
    }

    protected class SeekResult {
        public Vector_String_long_ vector;
        public long index;
    }

    protected SeekResult getVector (CallContext context, long index) {
        long offset = 0;
        SeekResult sr = new SeekResult();

        for (Vector_String_long_ vector : this.vectors.getIterable_Vector_String_long__(context)) {
            sr.vector = vector;
            if (sr.vector == null) { continue; }
            sr.index = index - offset;                

            long size = sr.vector.getSize(context);
            if (sr.index < size) {
                return sr;
            }
            offset += size;
        }
        return sr;
    }

    public String                                    get             (CallContext context, long index) throws DoesNotExist {
        SeekResult sr = this.getVector(context, index);
        if (sr.vector == null) { DoesNotExist.createAndThrow(context, "entry '%(index)'", "index", t.s(index)); }
        return sr.vector.get(context, sr.index);
    }

    public String                                    tryGet          (CallContext context, long index) {
        SeekResult sr = this.getVector(context, index);
        if (sr.vector == null) { return null; }
        return sr.vector.tryGet(context, sr.index);
    }

    public boolean                                     canGet          (CallContext context, long index) {
        SeekResult sr = this.getVector(context, index);
        if (sr.vector == null) { return false; }
        return sr.vector.canGet(context, sr.index);
    }

    public ReferenceToMember_String_long_ReadOnlyVector_String_long__ getReference    (CallContext context, long index) throws DoesNotExist {
        SeekResult sr = this.getVector(context, index);
        if (sr.vector == null) { DoesNotExist.createAndThrow(context, "entry '%(index)'", "index", t.s(index)); }
        return sr.vector.getReference(context, sr.index);
    }

    public ReferenceToMember_String_long_ReadOnlyVector_String_long__ tryGetReference (CallContext context, long index) {
        SeekResult sr = this.getVector(context, index);
        if (sr.vector == null) { return null; }
        return sr.vector.tryGetReference(context, sr.index);
    }

    public String                                    set             (CallContext context, long index, String item) {
        SeekResult sr = this.getVector(context, index);
        return sr.vector.set(context, sr.index, item);
    }

    public void                                        add             (CallContext context, long index, String item) throws AlreadyExists {
        SeekResult sr = this.getVector(context, index);
        sr.vector.add(context, sr.index, item);
    }

    public void                                        prepend         (CallContext context, String item) {
        this.vectors.tryGet(context, 0).prepend(context, item);
    }

    public void                                        append          (CallContext context, String item) {
        this.vectors.tryGet(context, this.vectors.getSize(context)-1).append(context, item);
    }

    public void                                        insertBefore    (CallContext context, long index, String item) throws DoesNotExist {
        SeekResult sr = this.getVector(context, index);
        sr.vector.insertBefore(context, sr.index, item);
    }

    public void                                        insertBehind    (CallContext context, long index, String item) throws DoesNotExist {
        SeekResult sr = this.getVector(context, index);
        sr.vector.insertBehind(context, sr.index, item);
    }

    public String                                    replace         (CallContext context, long index, String item) throws DoesNotExist {
        SeekResult sr = this.getVector(context, index);
        return sr.vector.replace(context, sr.index, item);
    }

    public String                                    unset           (CallContext context, long index) {
        SeekResult sr = this.getVector(context, index);
        return sr.vector.unset(context, sr.index);
    }

    public String                                    remove          (CallContext context, long index) throws DoesNotExist {
        SeekResult sr = this.getVector(context, index);
        return sr.vector.remove(context, sr.index);
    }

    public IteratorItemIndex_String_long_       getNavigator    (CallContext context) {
        return new VectorIteratorImpl_String_long_ (context, this);
    }

    public long                                        getSize         (CallContext context) {
        long size = 0;
        if (this.vectors != null) {
            for (long v=0; v<this.vectors.getSize(context); v++) {
                Vector_String_long_ vector = this.vectors.tryGet(context, v);
                if (vector != null) { size += vector.getSize(context); }
            }
        }
        return size;
    }

    protected class IteratorAdapter implements java.util.Iterator<String> {
        protected IteratorItemIndex_String_long_ iterator;
        protected CallContext context;
        public IteratorAdapter(CallContext context, IteratorItemIndex_String_long_ iterator) {
            this.iterator = iterator;
            this.context = context;
        }
        public boolean hasNext() { return iterator.canGetCurrent(this.context); }
        public void remove() { throw new UnsupportedOperationException(); }
        public String next() {
            if (iterator.canGetCurrent(this.context) == false) {
                throw new java.util.NoSuchElementException();
            }
            String current = iterator.tryGetCurrent(this.context);
            iterator.next(this.context);
            return current;
        }
    }

    public java.util.Iterator<String> getIterator_String_ (CallContext context) {
        return new IteratorAdapter(context, this.getNavigator(context));
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

    public void release(CallContext context) {
        if (this.vectors != null && this.vectors instanceof ManagedResource) {
            ((ManagedResource)(this.vectors)).release(context);
        }
    }
}


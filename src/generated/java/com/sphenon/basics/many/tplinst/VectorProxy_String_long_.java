// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorProxy.javatpl

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

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class VectorProxy_String_long_
  implements Vector_String_long_, VectorReorderable<String>, ManagedResource
{
    protected Vector_String_long_ vector;

    public VectorProxy_String_long_ (CallContext context, Vector_String_long_ vector) {
        this.vector = vector;
    }

    public void setVector (CallContext context, Vector_String_long_ vector) {
        this.vector = vector;
    }

    public Vector_String_long_ getVector (CallContext context) {
        return vector;
    }

    public String                                    get             (CallContext context, long index) throws DoesNotExist {
        return this.getVector(context).get(context, index);
    }

    public String                                    tryGet          (CallContext context, long index) {
        return this.getVector(context).tryGet(context, index);
    }

    public boolean                                     canGet          (CallContext context, long index) {
        return this.getVector(context).canGet(context, index);
    }

    public ReferenceToMember_String_long_ReadOnlyVector_String_long__ getReference    (CallContext context, long index) throws DoesNotExist {
        return this.getVector(context).getReference(context, index);
    }

    public ReferenceToMember_String_long_ReadOnlyVector_String_long__ tryGetReference (CallContext context, long index) {
        return this.getVector(context).tryGetReference(context, index);
    }

    public String                                    set             (CallContext context, long index, String item) {
        return this.getVector(context).set(context, index, item);
    }

    public void                                        add             (CallContext context, long index, String item) throws AlreadyExists {
        this.getVector(context).add(context, index, item);
    }

    public void                                        prepend         (CallContext context, String item) {
        this.getVector(context).prepend(context, item);
    }

    public void                                        append          (CallContext context, String item) {
        this.getVector(context).append(context, item);
    }

    public void                                        insertBefore    (CallContext context, long index, String item) throws DoesNotExist {
        this.getVector(context).insertBefore(context, index, item);
    }

    public void                                        insertBehind    (CallContext context, long index, String item) throws DoesNotExist {
        this.getVector(context).insertBehind(context, index, item);
    }

    public String                                    replace         (CallContext context, long index, String item) throws DoesNotExist {
        return this.getVector(context).replace(context, index, item);
    }

    public String                                    unset           (CallContext context, long index) {
        return this.getVector(context).unset(context, index);
    }

    public String                                    remove          (CallContext context, long index) throws DoesNotExist {
        return this.getVector(context).remove(context, index);
    }

    public IteratorItemIndex_String_long_       getNavigator    (CallContext context) {
        return this.getVector(context).getNavigator(context);
    }

    public long                                        getSize         (CallContext context) {
        return this.getVector(context).getSize(context);
    }

    public java.util.Iterator<String> getIterator_String_ (CallContext context) {
        return this.getVector(context).getIterator_String_(context);
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


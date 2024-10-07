package com.sphenon.basics.many;

/****************************************************************************
  Copyright 2001-2024 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import com.sphenon.basics.context.*;
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.reference.*;
import com.sphenon.basics.interaction.*;

import com.sphenon.basics.many.returncodes.*;

import java.util.Hashtable;

public class VectorIteratorImpl<T>
    implements IteratorItemIndex<T>,
               Cloneable,
               Anchorable
{
    private ReadOnlyVector<T> vector;
    private long current_index;

    public VectorIteratorImpl(CallContext context, ReadOnlyVector<T> vector) {
        this.vector = vector;
        // this.current_index = 0;
    }

    // -----------------------------------------------------------------------
    // -- Anchorable ---------------------------------------------------------
    public com.sphenon.basics.interaction.Anchor createAnchor(CallContext context, Workspace workspace, Transaction transaction) {
        return (com.sphenon.basics.interaction.Anchor) com.sphenon.basics.interaction.AnchorInterceptor.wrap(context, this, workspace, transaction);
    }
    // -----------------------------------------------------------------------

    public void next            (CallContext context) {
        // if (this.current_index < this.vector.getSize(context))
        this.current_index++;
    }

    public long getCurrentIndex (CallContext context) throws DoesNotExist {
        return this.current_index;
    }

    public long tryGetCurrentIndex (CallContext context) {
        return this.current_index;
    }

    public T getCurrent    (CallContext context) throws DoesNotExist {
        return vector.get(context, this.current_index);
    }

    public T tryGetCurrent (CallContext context) {
        return vector.tryGet(context, this.current_index);
    }

    public boolean  canGetCurrent (CallContext context) {
        return vector.canGet(context, this.current_index);
    }

    public Reference<T> getReferenceToCurrent (CallContext context) throws DoesNotExist {
        return vector.getReference(context, this.current_index);
    }

    public Reference<T> tryGetReferenceToCurrent (CallContext context) {
        return vector.tryGetReference(context, this.current_index);
    }

    public VectorIteratorImpl<T> clone(CallContext context) {
        try {
            return (VectorIteratorImpl<T>) super.clone();
        } catch (CloneNotSupportedException cnse) { return null; }
    }
}

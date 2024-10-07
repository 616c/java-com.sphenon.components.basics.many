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

import com.sphenon.basics.context.*;
import com.sphenon.basics.reference.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.monitoring.*;
import com.sphenon.basics.interaction.*;

import com.sphenon.basics.many.returncodes.*;

public class VectorReferenceToMember<T>
    implements ReferenceToMember<T,ReadOnlyVector<T>>,
    Anchorable
{
    private ReadOnlyVector<T> vector;
    private long              index;

    public VectorReferenceToMember(CallContext context, ReadOnlyVector<T> vector, long index) {
        this.vector = vector;
        this.index  = index;
        assert vector.canGet(context, this.index) : SystemStateMessage.create(context, MessageText.create(context, "VectorIndex created with invalid index '%(index)'", "index", index), ProblemState.ERROR);
    }

    public ReadOnlyVector<T> getContainer (CallContext context) {
        return this.vector;
    }

    // -----------------------------------------------------------------------
    // -- Anchorable ---------------------------------------------------------
    public com.sphenon.basics.interaction.Anchor createAnchor(CallContext context, Workspace workspace, Transaction transaction) {
        return (com.sphenon.basics.interaction.Anchor) com.sphenon.basics.interaction.AnchorInterceptor.wrap(context, this, workspace, transaction);
    }
    // -----------------------------------------------------------------------

    public long getIndex (CallContext context) {
        return this.index;
    }

    public T get (CallContext context) {
            try {
            return vector.get(context, this.index);
        } catch (DoesNotExist dne) {
            CustomaryContext.create(Context.create(context)).throwPreConditionViolation(context, dne, "VectorIndex contains invalid index '%(index)'", "index", index);
            throw (ExceptionPreConditionViolation) null; // compiler insists
        }
    }

    public boolean equals (Object object) {
        if (object == null) return false;
        if (! (object instanceof VectorReferenceToMember)) return false;
        if (((VectorReferenceToMember) object).vector != this.vector) return false;
        if (((VectorReferenceToMember) object).index  != this.index ) return false;
        return true;
    }

    public int hashCode () {
        return (this.vector.hashCode() ^ (int) this.index);
    }
}

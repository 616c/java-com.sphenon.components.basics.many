// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Anchor_VectorIterable.javatpl

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

import com.sphenon.basics.interaction.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.context.classes.RootContext;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.interaction.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class Anchor_VectorIterable_Object_long_
    implements Anchor,
               Iterable<Object>
{
    protected VectorIterable_Object_long_ delegate;

    public Anchor_VectorIterable_Object_long_ (CallContext context, VectorIterable_Object_long_ delegate, Workspace workspace, Transaction transaction) {
        this.delegate = delegate;
        this.workspace = workspace;
        this.transaction = transaction;
    }

    public VectorIterable_Object_long_ _getDelegate(CallContext context) {
        return this.delegate;
    }

    protected Workspace workspace;

    public Workspace _getWorkspace(CallContext context) {
        return this.workspace;
    }

    public void _setWorkspace(CallContext context, Workspace workspace) {
        this.workspace = workspace;
    }

    protected Transaction transaction;

    public Transaction _getTransaction(CallContext context) {
        return this.transaction;
    }

    public void _setTransaction(CallContext context, Transaction transaction) {
        this.transaction = transaction;
    }

    public java.util.Iterator<Object> iterator () {
        java.util.Iterator<Object> iterator = this._getDelegate(RootContext.getFallbackCallContext()).iterator();
        return new Anchor_Iterator<Object>(RootContext.getFallbackCallContext(), iterator);
    }
}

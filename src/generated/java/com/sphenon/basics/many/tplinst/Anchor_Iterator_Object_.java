// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Anchor_Iterator.javatpl

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
import com.sphenon.basics.exception.*;
import com.sphenon.basics.interaction.*;

import com.sphenon.basics.many.returncodes.*;

import com.sphenon.ui.annotations.*;

@UIDelegate("js:instance._getDelegate(context)")
public class Anchor_Iterator_Object_
    implements Anchor,
               Iterator_Object_
{
    protected Iterator_Object_ delegate;

    public Anchor_Iterator_Object_ (CallContext context, Iterator_Object_ delegate, Workspace workspace, Transaction transaction) {
        this.delegate = delegate;
        this.workspace = workspace;
        this.transaction = transaction;
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

    public Iterator_Object_ _getDelegate(CallContext context) {
        return this.delegate;
    }

    public void next (CallContext context) {
        this._getDelegate(context).next(context);
    }

    public Object getCurrent (CallContext context) throws DoesNotExist {
        Object item = this._getDelegate(context).getCurrent(context);
        return (item instanceof Anchorable ? ((Object) (((Anchorable) item).createAnchor(context, this.workspace, this.transaction))) : item);
    }

    public Object tryGetCurrent (CallContext context) {
        Object item = this._getDelegate(context).tryGetCurrent(context);
        return (item instanceof Anchorable ? ((Object) (((Anchorable) item).createAnchor(context, this.workspace, this.transaction))) : item);
    }

    public boolean canGetCurrent (CallContext context) {
        return this._getDelegate(context).canGetCurrent(context);
    }

    public Iterator_Object_ clone(CallContext context) {
        return new Anchor_Iterator_Object_(context, this._getDelegate(context).clone(context), this.workspace, this.transaction);
    }
}

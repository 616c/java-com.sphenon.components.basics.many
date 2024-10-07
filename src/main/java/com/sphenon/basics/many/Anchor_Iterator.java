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
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.interaction.*;

import java.util.Iterator;
import java.lang.Iterable;

public class Anchor_Iterator<ItemType>
    implements Anchor,
               Iterator
{
    protected Iterator<ItemType> delegate;

    public Anchor_Iterator (CallContext context, Iterator<ItemType> delegate) {
        this.delegate = delegate;
    }

    public Iterator<ItemType> _getDelegate(CallContext context) {
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

    public boolean hasNext() {
        return this._getDelegate(RootContext.getFallbackCallContext()).hasNext();
    }

    public ItemType next() {
        ItemType item = this._getDelegate(RootContext.getFallbackCallContext()).next();
        return (item instanceof Anchorable ? ((ItemType) (((Anchorable) item).createAnchor(RootContext.getFallbackCallContext(), this.workspace, this.transaction))) : item);
    }

    public void remove() {
        this._getDelegate(RootContext.getFallbackCallContext()).remove();
    }
}

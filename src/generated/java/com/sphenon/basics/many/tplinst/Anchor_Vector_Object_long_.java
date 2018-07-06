// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Anchor_Vector.javatpl

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

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;
import com.sphenon.basics.interaction.*;

import com.sphenon.ui.annotations.*;

@UIDelegate("js:instance._getDelegate(context)")
public class Anchor_Vector_Object_long_
    implements Anchor,
               Vector_Object_long_,
               ManagedResource
 {
    protected Vector_Object_long_ delegate;

    public Anchor_Vector_Object_long_ (CallContext context, Vector_Object_long_ delegate, Workspace workspace, Transaction transaction) {
        this.delegate = delegate;
        this.workspace = workspace;
        this.transaction = transaction;
    }

    public Vector_Object_long_ _getDelegate(CallContext context) {
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

    public Object get (CallContext context, long index) throws DoesNotExist {
        Object item = this._getDelegate(context).get(context, index);
        return (item instanceof Anchorable ? ((Object) (((Anchorable) item).createAnchor(context, this.workspace, this.transaction))) : item);
    }

    public Object tryGet (CallContext context, long index) {
        Object item = this._getDelegate(context).tryGet(context, index);
        return (item instanceof Anchorable ? ((Object) (((Anchorable) item).createAnchor(context, this.workspace, this.transaction))) : item);
    }

    public boolean canGet (CallContext context, long index) {
        return this._getDelegate(context).canGet(context, index);
    }

    public ReferenceToMember_Object_long_ReadOnlyVector_Object_long__ getReference (CallContext context, long index) throws DoesNotExist {
        ReferenceToMember_Object_long_ReadOnlyVector_Object_long__ reference = this._getDelegate(context).getReference(context, index);
        return (reference instanceof Anchorable ? ((ReferenceToMember_Object_long_ReadOnlyVector_Object_long__) (((Anchorable) reference).createAnchor(context, this.workspace, this.transaction))) : reference);
    }

    public ReferenceToMember_Object_long_ReadOnlyVector_Object_long__ tryGetReference (CallContext context, long index) {
        ReferenceToMember_Object_long_ReadOnlyVector_Object_long__ reference = this._getDelegate(context).tryGetReference(context, index);
        return (reference instanceof Anchorable ? ((ReferenceToMember_Object_long_ReadOnlyVector_Object_long__) (((Anchorable) reference).createAnchor(context, this.workspace, this.transaction))) : reference);
    }

    public Object set (CallContext context, long index, Object item) {
        Object olditem = this._getDelegate(context).set(context, index, item);
        return (olditem instanceof Anchorable ? ((Object) (((Anchorable) olditem).createAnchor(context, this.workspace, this.transaction))) : olditem);
    }

    public void add (CallContext context, long index, Object item) throws AlreadyExists {
        this._getDelegate(context).add(context, index, item);
    }

    public void prepend (CallContext context, Object item) {
        this._getDelegate(context).prepend(context, item);
    }

    public void append (CallContext context, Object item) {
        this._getDelegate(context).append(context, item);
    }

    public void insertBefore (CallContext context, long index, Object item) throws DoesNotExist {
        this._getDelegate(context).insertBefore(context, index, item);
    }

    public void insertBehind (CallContext context, long index, Object item) throws DoesNotExist {
        this._getDelegate(context).insertBehind(context, index, item);
    }

    public Object replace (CallContext context, long index, Object item) throws DoesNotExist {
        Object olditem = this._getDelegate(context).replace(context, index, item);
        return (olditem instanceof Anchorable ? ((Object) (((Anchorable) olditem).createAnchor(context, this.workspace, this.transaction))) : olditem);
    }

    public Object unset (CallContext context, long index) {
        Object olditem = this._getDelegate(context).unset(context, index);
        return (olditem instanceof Anchorable ? ((Object) (((Anchorable) olditem).createAnchor(context, this.workspace, this.transaction))) : olditem);
    }

    public Object remove (CallContext context, long index) throws DoesNotExist {
        Object olditem = this._getDelegate(context).remove(context, index);
        return (olditem instanceof Anchorable ? ((Object) (((Anchorable) olditem).createAnchor(context, this.workspace, this.transaction))) : olditem);
    }

    public IteratorItemIndex_Object_long_ getNavigator (CallContext context) {
        IteratorItemIndex_Object_long_ iterator = this._getDelegate(context).getNavigator(context);
        return (iterator instanceof Anchorable ? ((IteratorItemIndex_Object_long_) (((Anchorable) iterator).createAnchor(context, this.workspace, this.transaction))) : iterator);
    }

    public long getSize (CallContext context) {
        return this._getDelegate(context).getSize(context);
    }

    public java.util.Iterator<Object> getIterator_Object_ (CallContext context) {
        java.util.Iterator<Object> iterator = this._getDelegate(context).getIterator_Object_(context);
        return new Anchor_Iterator<Object>(context, iterator);

    }

    public java.util.Iterator getIterator (CallContext context) {
        return getIterator_Object_(context);
    }

    public VectorIterable_Object_long_ getIterable_Object_ (CallContext context) {
        VectorIterable_Object_long_ iterable = this._getDelegate(context).getIterable_Object_(context);
        return (iterable instanceof Anchorable ? ((VectorIterable_Object_long_) (((Anchorable) iterable).createAnchor(context, this.workspace, this.transaction))) : iterable);
    }

    public void release(CallContext context) {
        if (this._getDelegate(context) != null && this._getDelegate(context) instanceof ManagedResource) {
            ((ManagedResource)(this._getDelegate(context))).release(context);
        }
    }

    public Iterable<Object> getIterable (CallContext context) {
        return getIterable_Object_ (context);
    }
}

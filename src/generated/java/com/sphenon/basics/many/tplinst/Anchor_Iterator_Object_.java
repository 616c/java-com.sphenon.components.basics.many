// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Anchor_Iterator.javatpl
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

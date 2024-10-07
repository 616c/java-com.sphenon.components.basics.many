// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Anchor_Reference.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import com.sphenon.basics.interaction.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.reference.*;
import com.sphenon.basics.interaction.*;

public class Anchor_Reference_Object_
    implements Anchor,
               Reference_Object_
{
    protected Reference_Object_ delegate;

    public Anchor_Reference_Object_ (CallContext context, Reference_Object_ delegate, Workspace workspace, Transaction transaction) {
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

    public Reference_Object_ _getDelegate(CallContext context) {
        return this.delegate;
    }

    public Object get (CallContext context) {
        Object target = this._getDelegate(context).get(context);
        return (target instanceof Anchorable ? ((Object) (((Anchorable) target).createAnchor(context, this.workspace, this.transaction))) : target);
    }
}

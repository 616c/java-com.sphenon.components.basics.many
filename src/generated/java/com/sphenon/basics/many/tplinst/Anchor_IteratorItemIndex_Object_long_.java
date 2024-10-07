// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Anchor_IteratorItemIndex.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import com.sphenon.basics.interaction.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.interaction.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

import com.sphenon.ui.annotations.*;

@UIDelegate("js:instance._getDelegate(context)")
public class Anchor_IteratorItemIndex_Object_long_
    extends    Anchor_Iterator_Object_
    implements Anchor,
               IteratorItemIndex_Object_long_
{
    public Anchor_IteratorItemIndex_Object_long_ (CallContext context, IteratorItemIndex_Object_long_ delegate, Workspace workspace, Transaction transaction) {
        super(context, delegate, workspace, transaction);
    }

    public IteratorItemIndex_Object_long_ _getDelegate(CallContext context) {
        return (IteratorItemIndex_Object_long_) this.delegate;
    }

    public long getCurrentIndex (CallContext context) throws DoesNotExist {
        return this._getDelegate(context).getCurrentIndex(context);
    }

    public long tryGetCurrentIndex (CallContext context) {
        return this._getDelegate(context).tryGetCurrentIndex(context);
    }
}

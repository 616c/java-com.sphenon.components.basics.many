// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Anchor_IteratorItemIndex.javatpl

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

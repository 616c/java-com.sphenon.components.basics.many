// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Vector.javatpl

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


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

import com.sphenon.ui.annotations.*;

@UIId("")
@UIName("")
@UIClassifier("Vector_Object_")
@UIParts("js:instance.getIterable(context)")
public interface Vector_Object_long_
  extends ReadOnlyVector_Object_long_,
          WriteVector_Object_long_
          , GenericVector<Object>
          , GenericIterable<Object>
{
    public Object                                    get             (CallContext context, long index) throws DoesNotExist;
    public Object                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_Object_long_ReadOnlyVector_Object_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_Object_long_ReadOnlyVector_Object_long__  tryGetReference (CallContext context, long index);

    public Object                                    set             (CallContext context, long index, Object item);
    public void                                        add             (CallContext context, long index, Object item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, Object item);
    public void                                        append          (CallContext context, Object item);
    public void                                        insertBefore    (CallContext context, long index, Object item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, Object item) throws DoesNotExist;
    public Object                                    replace         (CallContext context, long index, Object item) throws DoesNotExist;
    public Object                                    unset           (CallContext context, long index);
    public Object                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_Object_long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<Object>              getIterator_Object_ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_Object_long_          getIterable_Object_ (CallContext context);
    public Iterable<Object> getIterable (CallContext context);
}

package com.sphenon.basics.many;

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

import com.sphenon.basics.context.*;
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface ReadOnlyVector<T>
  extends OfKnownSize {
    public T        get     (CallContext context, long index) throws DoesNotExist;
    public T        tryGet  (CallContext context, long index);
    public boolean  canGet  (CallContext context, long index);

    public ReferenceToMember<T,ReadOnlyVector<T>> getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember<T,ReadOnlyVector<T>> tryGetReference (CallContext context, long index);
}
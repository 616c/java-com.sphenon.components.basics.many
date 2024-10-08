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
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface Iterator<T>
{
    /**
       advances iterator; if there is no next item iterator becomes invalid
    */
    public void next       (CallContext context);

    /**
       returns current item; item must exist
    */
    public T getCurrent    (CallContext context) throws DoesNotExist;

    /**
       like "getCurrent", but returns null instead of throwing exception
    */
    public T tryGetCurrent (CallContext context);

    /**
       returns true if there is a current item available
    */
    public boolean canGetCurrent (CallContext context);

    /**
       creates a clone of this iterator, pointing to exactly
       the same position as yonder
    */
    public Iterator<T> clone(CallContext context);
}

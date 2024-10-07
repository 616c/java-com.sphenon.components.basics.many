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
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.validation.returncodes.*;

public interface VectorModifiability<ItemType> {
    /* deep: false - UI oriented perliminary check, fast response
             true  - execution oriented final check, safe but possibly expensive */
    public ValidationFailure    canSet          (CallContext context, long index, ItemType item, boolean deep);
    public ValidationFailure    canAdd          (CallContext context, long index, ItemType item, boolean deep);
    public ValidationFailure    canPrepend      (CallContext context, ItemType item, boolean deep);
    public ValidationFailure    canAppend       (CallContext context, ItemType item, boolean deep);
    public ValidationFailure    canInsertBefore (CallContext context, long index, ItemType item, boolean deep);
    public ValidationFailure    canInsertBehind (CallContext context, long index, ItemType item, boolean deep);
    public ValidationFailure    canReplace      (CallContext context, long index, ItemType item, boolean deep);
    public ValidationFailure    canUnset        (CallContext context, long index, boolean deep);
    public ValidationFailure    canRemove       (CallContext context, long index, boolean deep);
}

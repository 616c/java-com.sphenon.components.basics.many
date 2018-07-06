// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReadVector.javatpl

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

import com.sphenon.basics.many.returncodes.*;

public interface ReadVector_Vector_String_long__long_
{
    public Vector_String_long_                                    get             (CallContext context, long index) throws DoesNotExist;
    public Vector_String_long_                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_Vector_String_long__long_ReadOnlyVector_Vector_String_long__long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_Vector_String_long__long_ReadOnlyVector_Vector_String_long__long__  tryGetReference (CallContext context, long index);
}


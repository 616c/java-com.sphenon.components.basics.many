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
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.many.*;
import com.sphenon.basics.many.tplinst.*;

import java.util.Vector;

public class Factory_Vector_Object_long_ByVector {

    public Factory_Vector_Object_long_ByVector (CallContext context) {
    }

    public Vector_Object_long_ create (CallContext context) {
        return VectorImpl_Object_long_.create(context, this.vector);
    }

    protected Vector vector;

    public Vector getVector (CallContext context) {
        return this.vector;
    }

    public void setVector (CallContext context, Vector vector) {
        this.vector = vector;
    }
}

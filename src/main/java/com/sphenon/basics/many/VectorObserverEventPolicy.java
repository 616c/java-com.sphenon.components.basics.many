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
import com.sphenon.basics.many.returncodes.*;

/**
   Specifies if and when onAdd and onRemove methods are
   invoked. First, they are always invoked if a true element
   modification method of the VectorObserver is called, e.g. "set",
   "replace" etc.

   All other policies concern the behaviour when the complete vector
   implementation is modified. There are two cases: initialisation of
   the class, and direct change of the implementation vector via the
   setObserved method.

   The policies mean:

   NEVER: only true element modification methods call onAdd/onRemove

   IMMEDIATELY: all modifications of the complete vector lead to an
   immediate iteration over all elements and the onAdd/onRemove are
   applied respectively.

   ON_DEMAND: like immediately, but the iteration is deferred until
   the first time the vector is accessed

   ON_DEMAND_AND_LOAD: like ON_DEMAND, but loading of the vector
   from db also triggers OnAdd with a respective parameter set

   IMMEDIATELY_ONLY_EXPLICIT: like IMMEDIATE, but only invocations of
   the setObserved method trigger the iteration, the iniiliazation of
   the class does not trigger

   ON_DEMAND_ONLY_EXPLICIT: like ON_DEMAND, but only invocations of
   the setObserved method trigger the iteration, the iniiliazation of
   the class does not trigger

 */

public enum VectorObserverEventPolicy {
    NEVER,
    ON_DEMAND,
    ON_DEMAND_AND_LOAD,
    IMMEDIATELY,
    ON_DEMAND_ONLY_EXPLICIT,
    IMMEDIATELY_ONLY_EXPLICIT
}

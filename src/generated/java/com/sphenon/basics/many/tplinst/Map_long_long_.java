// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Map.javatpl

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

public interface Map_long_long_
  extends ReadMap_long_long_,
          WriteMap_long_long_,
          Navigatable_IteratorItemIndex_long_long__,
          OfKnownSize
{
    public long                                 get             (CallContext context, long index) throws DoesNotExist;
    public long                                 tryGet          (CallContext context, long index);
    public boolean                                  canGet          (CallContext context, long index);

    public MapReferenceToMember_long_long_ getReference    (CallContext context, long index) throws DoesNotExist;
    public MapReferenceToMember_long_long_ tryGetReference (CallContext context, long index);

    public void                                     set             (CallContext context, long index, long item);
    public void                                     add             (CallContext context, long index, long item) throws AlreadyExists;
    public void                                     replace         (CallContext context, long index, long item) throws DoesNotExist;
    public void                                     unset           (CallContext context, long index);
    public void                                     remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_long_long_    getNavigator    (CallContext context);

    public long                                     getSize         (CallContext context);
}


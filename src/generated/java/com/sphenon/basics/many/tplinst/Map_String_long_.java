// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Map.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public interface Map_String_long_
  extends ReadMap_String_long_,
          WriteMap_String_long_,
          Navigatable_IteratorItemIndex_String_long__,
          OfKnownSize
{
    public String                                 get             (CallContext context, long index) throws DoesNotExist;
    public String                                 tryGet          (CallContext context, long index);
    public boolean                                  canGet          (CallContext context, long index);

    public MapReferenceToMember_String_long_ getReference    (CallContext context, long index) throws DoesNotExist;
    public MapReferenceToMember_String_long_ tryGetReference (CallContext context, long index);

    public void                                     set             (CallContext context, long index, String item);
    public void                                     add             (CallContext context, long index, String item) throws AlreadyExists;
    public void                                     replace         (CallContext context, long index, String item) throws DoesNotExist;
    public void                                     unset           (CallContext context, long index);
    public void                                     remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_String_long_    getNavigator    (CallContext context);

    public long                                     getSize         (CallContext context);
}


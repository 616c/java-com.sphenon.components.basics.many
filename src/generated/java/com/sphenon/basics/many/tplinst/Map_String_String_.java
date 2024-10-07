// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Map.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public interface Map_String_String_
  extends ReadMap_String_String_,
          WriteMap_String_String_,
          Navigatable_IteratorItemIndex_String_String__,
          OfKnownSize
{
    public String                                 get             (CallContext context, String index) throws DoesNotExist;
    public String                                 tryGet          (CallContext context, String index);
    public boolean                                  canGet          (CallContext context, String index);

    public MapReferenceToMember_String_String_ getReference    (CallContext context, String index) throws DoesNotExist;
    public MapReferenceToMember_String_String_ tryGetReference (CallContext context, String index);

    public void                                     set             (CallContext context, String index, String item);
    public void                                     add             (CallContext context, String index, String item) throws AlreadyExists;
    public void                                     replace         (CallContext context, String index, String item) throws DoesNotExist;
    public void                                     unset           (CallContext context, String index);
    public void                                     remove          (CallContext context, String index) throws DoesNotExist;

    public IteratorItemIndex_String_String_    getNavigator    (CallContext context);

    public long                                     getSize         (CallContext context);
}


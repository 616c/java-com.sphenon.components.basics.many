// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Map.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import java.io.File;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public interface Map_File_String_
  extends ReadMap_File_String_,
          WriteMap_File_String_,
          Navigatable_IteratorItemIndex_File_String__,
          OfKnownSize
{
    public File                                 get             (CallContext context, String index) throws DoesNotExist;
    public File                                 tryGet          (CallContext context, String index);
    public boolean                                  canGet          (CallContext context, String index);

    public MapReferenceToMember_File_String_ getReference    (CallContext context, String index) throws DoesNotExist;
    public MapReferenceToMember_File_String_ tryGetReference (CallContext context, String index);

    public void                                     set             (CallContext context, String index, File item);
    public void                                     add             (CallContext context, String index, File item) throws AlreadyExists;
    public void                                     replace         (CallContext context, String index, File item) throws DoesNotExist;
    public void                                     unset           (CallContext context, String index);
    public void                                     remove          (CallContext context, String index) throws DoesNotExist;

    public IteratorItemIndex_File_String_    getNavigator    (CallContext context);

    public long                                     getSize         (CallContext context);
}


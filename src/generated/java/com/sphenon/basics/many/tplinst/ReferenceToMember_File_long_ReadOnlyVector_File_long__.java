// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReferenceToMember.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import java.io.File;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.reference.*;
import com.sphenon.basics.many.*;

public interface ReferenceToMember_File_long_ReadOnlyVector_File_long__
  extends Reference_File_
    , ReferenceToMember<File,ReadOnlyVector<File>>
{
    public ReadOnlyVector_File_long_ getContainer(CallContext context);
    public long     getIndex    (CallContext context);
}

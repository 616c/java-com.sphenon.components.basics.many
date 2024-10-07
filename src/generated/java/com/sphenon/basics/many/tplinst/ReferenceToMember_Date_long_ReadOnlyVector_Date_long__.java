// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReferenceToMember.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import java.util.Date;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.reference.*;
import com.sphenon.basics.many.*;

public interface ReferenceToMember_Date_long_ReadOnlyVector_Date_long__
  extends Reference_Date_
    , ReferenceToMember<Date,ReadOnlyVector<Date>>
{
    public ReadOnlyVector_Date_long_ getContainer(CallContext context);
    public long     getIndex    (CallContext context);
}

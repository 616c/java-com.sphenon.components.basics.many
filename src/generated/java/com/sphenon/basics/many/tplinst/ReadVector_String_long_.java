// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReadVector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface ReadVector_String_long_
{
    public String                                    get             (CallContext context, long index) throws DoesNotExist;
    public String                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_String_long_ReadOnlyVector_String_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_String_long_ReadOnlyVector_String_long__  tryGetReference (CallContext context, long index);
}


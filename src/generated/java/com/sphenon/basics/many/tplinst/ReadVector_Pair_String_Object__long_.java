// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReadVector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface ReadVector_Pair_String_Object__long_
{
    public Pair_String_Object_                                    get             (CallContext context, long index) throws DoesNotExist;
    public Pair_String_Object_                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_Pair_String_Object__long_ReadOnlyVector_Pair_String_Object__long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_Pair_String_Object__long_ReadOnlyVector_Pair_String_Object__long__  tryGetReference (CallContext context, long index);
}


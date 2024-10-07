// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/WriteVector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteVector_Pair_String_Object__long_
{
    public Pair_String_Object_ set          (CallContext context, long index, Pair_String_Object_ item);
    public void     add          (CallContext context, long index, Pair_String_Object_ item) throws AlreadyExists;
    public void     prepend      (CallContext context, Pair_String_Object_ item);
    public void     append       (CallContext context, Pair_String_Object_ item);
    public void     insertBefore (CallContext context, long index, Pair_String_Object_ item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, Pair_String_Object_ item) throws DoesNotExist;
    public Pair_String_Object_ replace      (CallContext context, long index, Pair_String_Object_ item) throws DoesNotExist;
    public Pair_String_Object_ unset        (CallContext context, long index);
    public Pair_String_Object_ remove       (CallContext context, long index) throws DoesNotExist;
}


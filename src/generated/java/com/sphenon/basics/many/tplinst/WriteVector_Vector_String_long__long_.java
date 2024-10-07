// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/WriteVector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteVector_Vector_String_long__long_
{
    public Vector_String_long_ set          (CallContext context, long index, Vector_String_long_ item);
    public void     add          (CallContext context, long index, Vector_String_long_ item) throws AlreadyExists;
    public void     prepend      (CallContext context, Vector_String_long_ item);
    public void     append       (CallContext context, Vector_String_long_ item);
    public void     insertBefore (CallContext context, long index, Vector_String_long_ item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, Vector_String_long_ item) throws DoesNotExist;
    public Vector_String_long_ replace      (CallContext context, long index, Vector_String_long_ item) throws DoesNotExist;
    public Vector_String_long_ unset        (CallContext context, long index);
    public Vector_String_long_ remove       (CallContext context, long index) throws DoesNotExist;
}


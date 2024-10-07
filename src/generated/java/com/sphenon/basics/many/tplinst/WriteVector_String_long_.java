// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/WriteVector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteVector_String_long_
{
    public String set          (CallContext context, long index, String item);
    public void     add          (CallContext context, long index, String item) throws AlreadyExists;
    public void     prepend      (CallContext context, String item);
    public void     append       (CallContext context, String item);
    public void     insertBefore (CallContext context, long index, String item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, String item) throws DoesNotExist;
    public String replace      (CallContext context, long index, String item) throws DoesNotExist;
    public String unset        (CallContext context, long index);
    public String remove       (CallContext context, long index) throws DoesNotExist;
}


// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/WriteVector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteVector_Throwable_long_
{
    public Throwable set          (CallContext context, long index, Throwable item);
    public void     add          (CallContext context, long index, Throwable item) throws AlreadyExists;
    public void     prepend      (CallContext context, Throwable item);
    public void     append       (CallContext context, Throwable item);
    public void     insertBefore (CallContext context, long index, Throwable item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, Throwable item) throws DoesNotExist;
    public Throwable replace      (CallContext context, long index, Throwable item) throws DoesNotExist;
    public Throwable unset        (CallContext context, long index);
    public Throwable remove       (CallContext context, long index) throws DoesNotExist;
}


// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/WriteVector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteVector_Object_long_
{
    public Object set          (CallContext context, long index, Object item);
    public void     add          (CallContext context, long index, Object item) throws AlreadyExists;
    public void     prepend      (CallContext context, Object item);
    public void     append       (CallContext context, Object item);
    public void     insertBefore (CallContext context, long index, Object item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, Object item) throws DoesNotExist;
    public Object replace      (CallContext context, long index, Object item) throws DoesNotExist;
    public Object unset        (CallContext context, long index);
    public Object remove       (CallContext context, long index) throws DoesNotExist;
}


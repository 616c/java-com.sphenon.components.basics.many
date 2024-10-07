// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/WriteVector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import java.util.Date;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteVector_Date_long_
{
    public Date set          (CallContext context, long index, Date item);
    public void     add          (CallContext context, long index, Date item) throws AlreadyExists;
    public void     prepend      (CallContext context, Date item);
    public void     append       (CallContext context, Date item);
    public void     insertBefore (CallContext context, long index, Date item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, Date item) throws DoesNotExist;
    public Date replace      (CallContext context, long index, Date item) throws DoesNotExist;
    public Date unset        (CallContext context, long index);
    public Date remove       (CallContext context, long index) throws DoesNotExist;
}


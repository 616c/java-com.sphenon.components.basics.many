// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/WriteVector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import java.io.File;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteVector_File_long_
{
    public File set          (CallContext context, long index, File item);
    public void     add          (CallContext context, long index, File item) throws AlreadyExists;
    public void     prepend      (CallContext context, File item);
    public void     append       (CallContext context, File item);
    public void     insertBefore (CallContext context, long index, File item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, File item) throws DoesNotExist;
    public File replace      (CallContext context, long index, File item) throws DoesNotExist;
    public File unset        (CallContext context, long index);
    public File remove       (CallContext context, long index) throws DoesNotExist;
}


// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReadQueue.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface ReadQueue_String_
{
    public String getFront     (CallContext context) throws DoesNotExist;
    public String tryGetFront  (CallContext context) throws DoesNotExist;
    public boolean  isEmpty      (CallContext context);
}

// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/WriteQueue.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteQueue_String_
{
    public void     pushBack     (CallContext context, String item);
    public String popFront     (CallContext context) throws DoesNotExist;
    public String tryPopFront  (CallContext context) throws DoesNotExist;
}

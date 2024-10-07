// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Queue.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface Queue_String_
  extends ReadQueue_String_,
          WriteQueue_String_
{
    public String getFront     (CallContext context) throws DoesNotExist;
    public String tryGetFront  (CallContext context);
    public boolean  isEmpty      (CallContext context);
    public void     pushBack     (CallContext context, String item);
    public String popFront     (CallContext context) throws DoesNotExist;
    public String tryPopFront  (CallContext context);
}

// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/IteratorItemIndex.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public interface IteratorItemIndex_String_String_
  extends Iterator_String_
{
    // returns current index
    public String getCurrentIndex (CallContext context) throws DoesNotExist;

    // like "getCurrentIndex", but returns null instead of throwing exception
    public String tryGetCurrentIndex (CallContext context);
}

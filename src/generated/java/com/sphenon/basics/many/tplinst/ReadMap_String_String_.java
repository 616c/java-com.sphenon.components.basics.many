// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReadMap.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface ReadMap_String_String_
{
    // retrieves item at index; item must exist
    public String get     (CallContext context, String index) throws DoesNotExist;

    // retrieves item at index; returns null if item does not exist
    public String tryGet  (CallContext context, String index);

    // returns true if item at index exists, otherwise false
    public boolean  canGet  (CallContext context, String index);
}


// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReadMap.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface ReadMap_long_long_
{
    // retrieves item at index; item must exist
    public long get     (CallContext context, long index) throws DoesNotExist;

    // retrieves item at index; returns null if item does not exist
    public long tryGet  (CallContext context, long index);

    // returns true if item at index exists, otherwise false
    public boolean  canGet  (CallContext context, long index);
}


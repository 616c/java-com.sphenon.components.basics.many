// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorIterable.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class VectorIterable_String_long_ implements Iterable<String>
{
    protected java.util.Iterator<String> iterator;

    public VectorIterable_String_long_ (CallContext context, Vector_String_long_ vector) {
        this.iterator = (vector == null ? (new java.util.Vector<String>()).iterator() : vector.getIterator_String_(context));
    }

    public java.util.Iterator<String> iterator () {
        return this.iterator;
    }
}


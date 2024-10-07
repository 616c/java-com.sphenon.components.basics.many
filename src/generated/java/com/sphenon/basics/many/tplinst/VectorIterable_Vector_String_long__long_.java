// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorIterable.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class VectorIterable_Vector_String_long__long_ implements Iterable<Vector_String_long_>
{
    protected java.util.Iterator<Vector_String_long_> iterator;

    public VectorIterable_Vector_String_long__long_ (CallContext context, Vector_Vector_String_long__long_ vector) {
        this.iterator = (vector == null ? (new java.util.Vector<Vector_String_long_>()).iterator() : vector.getIterator_Vector_String_long__(context));
    }

    public java.util.Iterator<Vector_String_long_> iterator () {
        return this.iterator;
    }
}


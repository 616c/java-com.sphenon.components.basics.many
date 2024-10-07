// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorIterable.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class VectorIterable_Pair_String_Object__long_ implements Iterable<Pair_String_Object_>
{
    protected java.util.Iterator<Pair_String_Object_> iterator;

    public VectorIterable_Pair_String_Object__long_ (CallContext context, Vector_Pair_String_Object__long_ vector) {
        this.iterator = (vector == null ? (new java.util.Vector<Pair_String_Object_>()).iterator() : vector.getIterator_Pair_String_Object__(context));
    }

    public java.util.Iterator<Pair_String_Object_> iterator () {
        return this.iterator;
    }
}


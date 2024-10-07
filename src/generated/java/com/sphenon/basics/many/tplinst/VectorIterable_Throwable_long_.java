// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorIterable.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class VectorIterable_Throwable_long_ implements Iterable<Throwable>
{
    protected java.util.Iterator<Throwable> iterator;

    public VectorIterable_Throwable_long_ (CallContext context, Vector_Throwable_long_ vector) {
        this.iterator = (vector == null ? (new java.util.Vector<Throwable>()).iterator() : vector.getIterator_Throwable_(context));
    }

    public java.util.Iterator<Throwable> iterator () {
        return this.iterator;
    }
}


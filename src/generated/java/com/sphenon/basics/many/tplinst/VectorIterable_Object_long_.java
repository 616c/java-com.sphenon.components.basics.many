// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorIterable.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class VectorIterable_Object_long_ implements Iterable<Object>
{
    protected java.util.Iterator<Object> iterator;

    public VectorIterable_Object_long_ (CallContext context, Vector_Object_long_ vector) {
        this.iterator = (vector == null ? (new java.util.Vector<Object>()).iterator() : vector.getIterator_Object_(context));
    }

    public java.util.Iterator<Object> iterator () {
        return this.iterator;
    }
}


// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorIterable.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import java.util.Date;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class VectorIterable_Date_long_ implements Iterable<Date>
{
    protected java.util.Iterator<Date> iterator;

    public VectorIterable_Date_long_ (CallContext context, Vector_Date_long_ vector) {
        this.iterator = (vector == null ? (new java.util.Vector<Date>()).iterator() : vector.getIterator_Date_(context));
    }

    public java.util.Iterator<Date> iterator () {
        return this.iterator;
    }
}


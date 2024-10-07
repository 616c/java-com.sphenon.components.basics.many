// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/VectorIterable.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import java.io.File;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public class VectorIterable_File_long_ implements Iterable<File>
{
    protected java.util.Iterator<File> iterator;

    public VectorIterable_File_long_ (CallContext context, Vector_File_long_ vector) {
        this.iterator = (vector == null ? (new java.util.Vector<File>()).iterator() : vector.getIterator_File_(context));
    }

    public java.util.Iterator<File> iterator () {
        return this.iterator;
    }
}


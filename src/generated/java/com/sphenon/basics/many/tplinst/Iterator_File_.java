// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Iterator.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import java.io.File;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface Iterator_File_
    extends com.sphenon.basics.many.Iterator<File>
{
    // advances iterator; if there is no next item iterator becomes invalid
    public void     next          (CallContext context);

    // returns current item; item must exist
    public File getCurrent    (CallContext context) throws DoesNotExist;

    // like "getCurrent", but returns null instead of throwing exception
    public File tryGetCurrent (CallContext context);

    // returns true if there is a current item available
    public boolean  canGetCurrent (CallContext context);

    // creates a clone of this iterator, pointing to exactly
    // the same position as yonder
    public Iterator_File_ clone(CallContext context);
}

// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Vector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import java.io.File;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

import com.sphenon.ui.annotations.*;

@UIId("")
@UIName("")
@UIClassifier("Vector_File_")
@UIParts("js:instance.getIterable(context)")
public interface Vector_File_long_
  extends ReadOnlyVector_File_long_,
          WriteVector_File_long_
          , GenericVector<File>
          , GenericIterable<File>
{
    public File                                    get             (CallContext context, long index) throws DoesNotExist;
    public File                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_File_long_ReadOnlyVector_File_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_File_long_ReadOnlyVector_File_long__  tryGetReference (CallContext context, long index);

    public File                                    set             (CallContext context, long index, File item);
    public void                                        add             (CallContext context, long index, File item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, File item);
    public void                                        append          (CallContext context, File item);
    public void                                        insertBefore    (CallContext context, long index, File item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, File item) throws DoesNotExist;
    public File                                    replace         (CallContext context, long index, File item) throws DoesNotExist;
    public File                                    unset           (CallContext context, long index);
    public File                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_File_long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<File>              getIterator_File_ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_File_long_          getIterable_File_ (CallContext context);
    public Iterable<File> getIterable (CallContext context);
}

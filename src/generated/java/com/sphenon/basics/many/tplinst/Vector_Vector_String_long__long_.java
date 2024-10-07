// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Vector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

import com.sphenon.ui.annotations.*;

@UIId("")
@UIName("")
@UIClassifier("Vector_Vector_String_long__")
@UIParts("js:instance.getIterable(context)")
public interface Vector_Vector_String_long__long_
  extends ReadOnlyVector_Vector_String_long__long_,
          WriteVector_Vector_String_long__long_
          , GenericVector<Vector_String_long_>
          , GenericIterable<Vector_String_long_>
{
    public Vector_String_long_                                    get             (CallContext context, long index) throws DoesNotExist;
    public Vector_String_long_                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_Vector_String_long__long_ReadOnlyVector_Vector_String_long__long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_Vector_String_long__long_ReadOnlyVector_Vector_String_long__long__  tryGetReference (CallContext context, long index);

    public Vector_String_long_                                    set             (CallContext context, long index, Vector_String_long_ item);
    public void                                        add             (CallContext context, long index, Vector_String_long_ item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, Vector_String_long_ item);
    public void                                        append          (CallContext context, Vector_String_long_ item);
    public void                                        insertBefore    (CallContext context, long index, Vector_String_long_ item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, Vector_String_long_ item) throws DoesNotExist;
    public Vector_String_long_                                    replace         (CallContext context, long index, Vector_String_long_ item) throws DoesNotExist;
    public Vector_String_long_                                    unset           (CallContext context, long index);
    public Vector_String_long_                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_Vector_String_long__long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<Vector_String_long_>              getIterator_Vector_String_long__ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_Vector_String_long__long_          getIterable_Vector_String_long__ (CallContext context);
    public Iterable<Vector_String_long_> getIterable (CallContext context);
}

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
@UIClassifier("Vector_Throwable_")
@UIParts("js:instance.getIterable(context)")
public interface Vector_Throwable_long_
  extends ReadOnlyVector_Throwable_long_,
          WriteVector_Throwable_long_
          , GenericVector<Throwable>
          , GenericIterable<Throwable>
{
    public Throwable                                    get             (CallContext context, long index) throws DoesNotExist;
    public Throwable                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_Throwable_long_ReadOnlyVector_Throwable_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_Throwable_long_ReadOnlyVector_Throwable_long__  tryGetReference (CallContext context, long index);

    public Throwable                                    set             (CallContext context, long index, Throwable item);
    public void                                        add             (CallContext context, long index, Throwable item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, Throwable item);
    public void                                        append          (CallContext context, Throwable item);
    public void                                        insertBefore    (CallContext context, long index, Throwable item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, Throwable item) throws DoesNotExist;
    public Throwable                                    replace         (CallContext context, long index, Throwable item) throws DoesNotExist;
    public Throwable                                    unset           (CallContext context, long index);
    public Throwable                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_Throwable_long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<Throwable>              getIterator_Throwable_ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_Throwable_long_          getIterable_Throwable_ (CallContext context);
    public Iterable<Throwable> getIterable (CallContext context);
}

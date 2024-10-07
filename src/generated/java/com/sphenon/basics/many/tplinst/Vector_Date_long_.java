// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Vector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;

import java.util.Date;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

import com.sphenon.ui.annotations.*;

@UIId("")
@UIName("")
@UIClassifier("Vector_Date_")
@UIParts("js:instance.getIterable(context)")
public interface Vector_Date_long_
  extends ReadOnlyVector_Date_long_,
          WriteVector_Date_long_
          , GenericVector<Date>
          , GenericIterable<Date>
{
    public Date                                    get             (CallContext context, long index) throws DoesNotExist;
    public Date                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_Date_long_ReadOnlyVector_Date_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_Date_long_ReadOnlyVector_Date_long__  tryGetReference (CallContext context, long index);

    public Date                                    set             (CallContext context, long index, Date item);
    public void                                        add             (CallContext context, long index, Date item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, Date item);
    public void                                        append          (CallContext context, Date item);
    public void                                        insertBefore    (CallContext context, long index, Date item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, Date item) throws DoesNotExist;
    public Date                                    replace         (CallContext context, long index, Date item) throws DoesNotExist;
    public Date                                    unset           (CallContext context, long index);
    public Date                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_Date_long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<Date>              getIterator_Date_ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_Date_long_          getIterable_Date_ (CallContext context);
    public Iterable<Date> getIterable (CallContext context);
}

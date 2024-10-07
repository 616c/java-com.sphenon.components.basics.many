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
@UIClassifier("Vector_String_")
@UIParts("js:instance.getIterable(context)")
public interface Vector_String_long_
  extends ReadOnlyVector_String_long_,
          WriteVector_String_long_
          , GenericVector<String>
          , GenericIterable<String>
{
    public String                                    get             (CallContext context, long index) throws DoesNotExist;
    public String                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_String_long_ReadOnlyVector_String_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_String_long_ReadOnlyVector_String_long__  tryGetReference (CallContext context, long index);

    public String                                    set             (CallContext context, long index, String item);
    public void                                        add             (CallContext context, long index, String item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, String item);
    public void                                        append          (CallContext context, String item);
    public void                                        insertBefore    (CallContext context, long index, String item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, String item) throws DoesNotExist;
    public String                                    replace         (CallContext context, long index, String item) throws DoesNotExist;
    public String                                    unset           (CallContext context, long index);
    public String                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_String_long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<String>              getIterator_String_ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_String_long_          getIterable_String_ (CallContext context);
    public Iterable<String> getIterable (CallContext context);
}

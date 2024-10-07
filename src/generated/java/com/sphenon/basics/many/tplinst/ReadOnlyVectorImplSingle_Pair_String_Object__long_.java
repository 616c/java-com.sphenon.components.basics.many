// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReadOnlyVectorImplSingle.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.many.*;

import com.sphenon.basics.many.returncodes.*;

public class ReadOnlyVectorImplSingle_Pair_String_Object__long_
  implements ReadOnlyVector_Pair_String_Object__long_ {
    protected Pair_String_Object_ item;

    public ReadOnlyVectorImplSingle_Pair_String_Object__long_ (CallContext context, Pair_String_Object_ item) {
        this.item = item;
    }

    public Pair_String_Object_ get          (CallContext context, long index) throws DoesNotExist {
        if (index != 0) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return item;
    }

    public Pair_String_Object_ tryGet       (CallContext context, long index) {
        if (index != 0) {
            return null;
        }
        return item;
    }

    public boolean  canGet       (CallContext context, long index) {
        return (index == 0 ? true : false);
    }

    public IteratorItemIndex_Pair_String_Object__long_ getNavigator (CallContext context) {
        return new VectorIteratorImpl_Pair_String_Object__long_ (context, this);
    }

    public VectorReferenceToMember_Pair_String_Object__long_ getReference (CallContext context, long index) throws DoesNotExist {
        if ( ! canGet(context, index)) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return new VectorReferenceToMember_Pair_String_Object__long_(context, this, 0L);
    }

    public VectorReferenceToMember_Pair_String_Object__long_ tryGetReference (CallContext context, long index) {
        if ( ! canGet(context, index)) { return null; }
        return new VectorReferenceToMember_Pair_String_Object__long_(context, this, 0L);
    }

    public long     getSize      (CallContext context) {
        return 1;
    }
}

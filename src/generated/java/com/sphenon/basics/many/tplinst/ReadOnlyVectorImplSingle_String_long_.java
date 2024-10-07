// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReadOnlyVectorImplSingle.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.many.*;

import com.sphenon.basics.many.returncodes.*;

public class ReadOnlyVectorImplSingle_String_long_
  implements ReadOnlyVector_String_long_ {
    protected String item;

    public ReadOnlyVectorImplSingle_String_long_ (CallContext context, String item) {
        this.item = item;
    }

    public String get          (CallContext context, long index) throws DoesNotExist {
        if (index != 0) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return item;
    }

    public String tryGet       (CallContext context, long index) {
        if (index != 0) {
            return null;
        }
        return item;
    }

    public boolean  canGet       (CallContext context, long index) {
        return (index == 0 ? true : false);
    }

    public IteratorItemIndex_String_long_ getNavigator (CallContext context) {
        return new VectorIteratorImpl_String_long_ (context, this);
    }

    public VectorReferenceToMember_String_long_ getReference (CallContext context, long index) throws DoesNotExist {
        if ( ! canGet(context, index)) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return new VectorReferenceToMember_String_long_(context, this, 0L);
    }

    public VectorReferenceToMember_String_long_ tryGetReference (CallContext context, long index) {
        if ( ! canGet(context, index)) { return null; }
        return new VectorReferenceToMember_String_long_(context, this, 0L);
    }

    public long     getSize      (CallContext context) {
        return 1;
    }
}

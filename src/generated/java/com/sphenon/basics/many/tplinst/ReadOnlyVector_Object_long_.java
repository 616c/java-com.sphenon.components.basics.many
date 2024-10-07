// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/ReadOnlyVector.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;



import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public interface ReadOnlyVector_Object_long_
  extends ReadVector_Object_long_,
          ReadOnlyVector<Object>,
          OfKnownSize
{
    public Object                                    get             (CallContext context, long index) throws DoesNotExist;
    public Object                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_Object_long_ReadOnlyVector_Object_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_Object_long_ReadOnlyVector_Object_long__  tryGetReference (CallContext context, long index);
}


// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/MapReferenceToMember.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.reference.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.monitoring.*;

import com.sphenon.basics.many.returncodes.*;

public class MapReferenceToMember_long_long_
    implements ReferenceToMember_long_long_Map_long_long__
{
    private Map_long_long_    map;
    private long                  index;

    public MapReferenceToMember_long_long_ (CallContext context, Map_long_long_ map, long index) {
        this.map    = map;
        this.index  = index;
        assert map.canGet(context, this.index) : SystemStateMessage.create(context, MessageText.create(context, "MapIndex created with invalid index '%(index)'", "index", new Long(index)), ProblemState.ERROR);
    }

    public Map_long_long_ getContainer (CallContext context) {
        return this.map;
    }

    public long getIndex (CallContext context) {
        return this.index;
    }

    public Long get (CallContext context) {
        try {
            return map.get(context, this.index);
        } catch (DoesNotExist dne) {
            CustomaryContext.create(Context.create(context)).throwPreConditionViolation(context, dne, "MapIndex contains invalid index '%(index)'", "index", new Long(index));
            throw (ExceptionPreConditionViolation) null; // compiler insists
        }
    }

    public boolean equals (Object object) {
        if (object == null) return false;
        if (! (object instanceof MapReferenceToMember_long_long_)) return false;
        if (((MapReferenceToMember_long_long_) object).map != this.map) return false;
        if (((MapReferenceToMember_long_long_) object).index  != this.index ) return false;
        return true;
    }

    public int hashCode () {
        return (this.map.hashCode() ^ (int) this.index);
    }
}

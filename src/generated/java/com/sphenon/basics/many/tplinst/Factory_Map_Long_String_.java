// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Factory_Map.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;
import com.sphenon.basics.many.traits.*;

public class Factory_Map_Long_String_
{
    private String[] names;
    private Long[] values;

    public Map_Long_String_ create (CallContext context) {
        Map_Long_String_ map = new MapImpl_Long_String_(context);
        for (int i=0; i<names.length; i++) {
            String index = ConversionTraits_String_.tryConvertFromString(context, names[i]);
            try {
                map.add(context, index, values[i]);
            } catch (AlreadyExists ae) {
                CustomaryContext.create(Context.create(context)).throwPreConditionViolation(context, ManyStringPool.get(context, "0.6.1" /* Map contains already a key named '%(key)' */), "key", index.toString());
            }
        }
        return map;
    }

    public void set_ParametersAtOnce(CallContext call_context, String[] names, Long[] values) {
        if (names.length != values.length) {
            Context context = Context.create(call_context);
            CustomaryContext cc = CustomaryContext.create(context);
            cc.throwPreConditionViolation(context, ManyStringPool.get(context, "0.6.0" /* Number of names differs from number of values */));
        }
        this.names = names;
        this.values = values;
    }
}

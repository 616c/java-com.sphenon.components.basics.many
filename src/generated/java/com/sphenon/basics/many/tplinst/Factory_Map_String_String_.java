// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Factory_Map.javatpl

/****************************************************************************
  Copyright 2001-2018 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;
import com.sphenon.basics.many.traits.*;

public class Factory_Map_String_String_
{
    private String[] names;
    private String[] values;

    public Map_String_String_ create (CallContext context) {
        Map_String_String_ map = new MapImpl_String_String_(context);
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

    public void set_ParametersAtOnce(CallContext call_context, String[] names, String[] values) {
        if (names.length != values.length) {
            Context context = Context.create(call_context);
            CustomaryContext cc = CustomaryContext.create(context);
            cc.throwPreConditionViolation(context, ManyStringPool.get(context, "0.6.0" /* Number of names differs from number of values */));
        }
        this.names = names;
        this.values = values;
    }
}

package com.sphenon.basics.many;

/****************************************************************************
  Copyright 2001-2024 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import com.sphenon.basics.context.*;
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collection;

public class ObjectExistenceCheck {

    protected CallContext context;
    protected Object object;
    protected Object other_object;

    public ObjectExistenceCheck (CallContext context, Object object) {
        this.context = context;
        this.object = object;
    }

    public ObjectExistenceCheck (CallContext context, Object object, Object other_object) {
        this.context = context;
        this.object = object;
        this.other_object = other_object;
    }

    public boolean exists(CallContext context) {
        return (    this.object != null
                 && (    (this.object instanceof Voidable) == false
                      || ((Voidable) this.object).isVoid(context) == false
                    )
               );
    }

    public boolean notexists(CallContext context) {
        return ! exists(context);
    }

    public boolean isvalid(CallContext context) {
        if (this.exists(context) == false) { return false; }
        if (this.object instanceof Boolean) {
            return ((Boolean) this.object);
        }
        if (this.object instanceof Short) {
            return ((Short) this.object) != 0;
        }
        if (this.object instanceof Integer) {
            return ((Integer) this.object) != 0;
        }
        if (this.object instanceof Long) {
            return ((Long) this.object) != 0;
        }
        return false;
    }

    public boolean isinvalid(CallContext context) {
        return ! isvalid(context);
    }

    public boolean empty(CallContext context) {
        if (this.exists(context) == false) { return true; }
        if (this.object instanceof GenericIterable) {
            Iterator iterator = ((GenericIterable) this.object).getIterator(context);
            if (iterator == null) { return true; }
            if ( ! iterator.hasNext()) { return true; }
            return false;
        }
        if (this.object instanceof Iterable) {
            Iterator iterator = ((Iterable) this.object).iterator();
            if (iterator == null) { return true; }
            if ( ! iterator.hasNext()) { return true; }
            return false;
        }
        if (this.object instanceof String) {
            String s = (String) object;
            return (s == null || s.length() == 0 || s.matches("\\s*"));
        }
        if (this.object instanceof Short) {
            Short s = (Short) object;
            return (s == null || s == 0);
        }
        if (this.object instanceof Integer) {
            Integer i = (Integer) object;
            return (i == null || i == 0);
        }
        if (this.object instanceof Long) {
            Long l = (Long) object;
            return (l == null || l == 0);
        }
        if (this.object.getClass().isArray()) {
            return (java.lang.reflect.Array.getLength(object) == 0 ? true : false);
        }
        return true;
    }

    public boolean notempty(CallContext context) {
        return ! empty(context);
    }

    public boolean element(CallContext context) {
        if (this.other_object == null) { return false; }
        if (this.other_object.getClass().isArray()) {
            return Arrays.asList((Object[]) this.other_object).contains(this.object);
        }
        if (this.other_object instanceof Collection) {
            return ((Collection) this.other_object).contains(this.object);
        }
        return false;
    }

    public boolean notelement(CallContext context) {
        return ! element(context);
    }

    public Object getValue(CallContext context) {
        return this.object;
    }
}

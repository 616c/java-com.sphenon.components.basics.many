package com.sphenon.basics.many;

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

import com.sphenon.basics.context.*;
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;

import com.sphenon.basics.many.returncodes.*;

import java.lang.reflect.Array;

public interface GenericVector<T>
    extends GenericIterable<T>,
            ReadOnlyVector<T> {
    public T          get          (CallContext context, long index) throws DoesNotExist;
    public T          tryGet       (CallContext context, long index);
    public boolean    canGet       (CallContext context, long index);
    public T          set          (CallContext context, long index, T item);
    public void       add          (CallContext context, long index, T item) throws AlreadyExists;
    public void       prepend      (CallContext context, T item);
    public void       append       (CallContext context, T item);
    public void       insertBefore (CallContext context, long index, T item) throws DoesNotExist;
    public void       insertBehind (CallContext context, long index, T item) throws DoesNotExist;
    public T          replace      (CallContext context, long index, T item) throws DoesNotExist;
    public T          unset        (CallContext context, long index);
    public T          remove       (CallContext context, long index) throws DoesNotExist;
    public IteratorItemIndex<T> getNavigator(CallContext context);
    public long       getSize      (CallContext context);

    static public class ToArray {
        static public<T> T[] convert(CallContext context, GenericVector<T> vector, Class<T> clazz) {
            if (vector == null) { return (T[]) new Object[0]; }
            @SuppressWarnings("unchecked") T[] result = (T[]) Array.newInstance(clazz, (int) vector.getSize(context));
            int i=0;
            for (T t : vector.getIterable(context)) {
                result[i++] = t;
            }
            return result;
        }
    }
}

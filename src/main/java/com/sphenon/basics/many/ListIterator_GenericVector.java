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

import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Collection;

public class ListIterator_GenericVector<T> implements ListIterator<T>, WithModifiableContext {

    protected CallContext context;
    protected GenericVector<T> vector;
    protected int index;
    protected boolean can_remove;

    public ListIterator_GenericVector(CallContext context, GenericVector<T> vector) {
        this(context, vector, 0);
    }

    public ListIterator_GenericVector(CallContext context, GenericVector<T> vector, int index) {
        this.context    = context;
        this.vector     = vector;
        this.index      = index;
        this.can_remove = false;
    }

    public void setContext(CallContext context) {
        this.context = context;
    }

    public CallContext getContext() {
        return this.context;
    }

    public void add(T item) {
        if (this.index >= this.vector.getSize(context)) {
            this.vector.append(context, item);
        } else {
            try {
                this.vector.insertBefore(context, this.index, item);
            } catch (DoesNotExist dne) {
                // should be safe
            }
        }
        this.index++;
        this.can_remove = false;
    }

    public boolean hasNext() {
        return (this.index < this.vector.getSize(context) ? true : false);
    }

    public boolean hasPrevious() {
        return (this.index > 0 ? true : false);
    }

    public T next() {
        try {
            T item = this.vector.get(context, this.index);
            this.index++;
            this.can_remove = true;
            return item;
        } catch (DoesNotExist dne) {
            throw new java.util.NoSuchElementException();
        }
    }

    public int nextIndex() {
        return this.index;
    }

    public T previous() {
        try {
            T item = this.vector.get(context, this.index - 1);
            this.index--;
            this.can_remove = true;
            return item;
        } catch (DoesNotExist dne) {
            throw new java.util.NoSuchElementException();
        }
    }

    public int previousIndex() {
        return this.index - 1;
    }

    public void remove() {
        if ( ! this.can_remove) {
            throw new IllegalStateException();
        }
        this.vector.unset(context, this.index);
        this.can_remove = false;
    }

    public void set(T item) {
        if ( ! this.can_remove) {
            throw new IllegalStateException();
        }
        this.vector.set(context, this.index, item);
    }
}

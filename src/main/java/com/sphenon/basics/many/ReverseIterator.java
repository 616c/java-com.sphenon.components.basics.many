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

public class ReverseIterator<T> implements ListIterator<T> {

    protected CallContext context;
    protected List<T> list;
    protected ListIterator<T> iterator;

    public ReverseIterator(CallContext context, List<T> list, int index) {
        this.context    = context;
        this.list       = list;
        this.iterator   = list.listIterator(list.size() - index);
    }

    public void setContext(CallContext context) {
        this.context = context;
    }

    public CallContext getContext() {
        return this.context;
    }

    public void add(T item) {
        this.iterator.add(item);
    }

    public boolean hasNext() {
        return this.iterator.hasPrevious();
    }

    public boolean hasPrevious() {
        return this.iterator.hasNext();
    }

    public T next() {
        return this.iterator.previous();
    }

    public int nextIndex() {
        int size = this.list.size();
        return size-1-this.iterator.previousIndex();
    }

    public T previous() {
        return this.iterator.next();
    }

    public int previousIndex() {
        int size = this.list.size();
        return size-1-this.iterator.nextIndex();
    }

    public void remove() {
        this.iterator.remove();
    }

    public void set(T item) {
        this.iterator.set(item);
    }
}

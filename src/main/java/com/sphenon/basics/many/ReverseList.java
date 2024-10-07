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
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Collection;

public class ReverseList<T> implements List<T> {

    protected CallContext context;
    protected List<T> list;

    public ReverseList(CallContext context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    static public<T> ReverseList create(CallContext context, List<T> list) {
        return new ReverseList<T>(context, list);
    }

    static public<T> ReverseList create(CallContext context, T[] array) {
        return new ReverseList<T>(context, Arrays.asList(array));
    }

    static public ReverseList create(CallContext context, Object whatever) {
        if (whatever instanceof List) {
            return new ReverseList(context, (List) whatever);
        }
        if (whatever != null && whatever.getClass().isArray()) {
            return new ReverseList(context, Arrays.asList((Object[]) whatever));
        }
        CustomaryContext.create((Context)context).throwPreConditionViolation(context, "Cannot create reverse list from object of type '%(class)', only 'List' and 'Array' are valid", "class", whatever.getClass().getName());
        throw (ExceptionPreConditionViolation) null; // compiler insists
    }

    public void setContext(CallContext context) {
        this.context = context;
    }

    public CallContext getContext() {
        return this.context;
    }

    public boolean add(T item) {
        this.list.add(0, item);
        return true;
    }

    public void add(int index, T item) {
        this.list.add(this.list.size() - index, item);
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean added = false;
        for (T item : c) {
            this.list.add(0, item);
            added = true;
        }
        return added;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        int size = this.list.size();
        boolean added = false;
        for (T item : c) {
            this.list.add(size - index, item);
            added = true;
        }
        return added;
    }

    public void clear() {
        this.list.clear();
    }

    public boolean contains(Object o) {
        return this.list.contains(o);
    }

    public boolean containsAll(Collection<?> c) {
        return this.list.containsAll(c);
    }

    public boolean equals(Object o) {
        if ((o instanceof List) == false) { return false; }
        List l = (List) o;
        int size1 = this.list.size();
        int size2 = l.size();
        if (size1 != size2) { return false; }
        for (int index = 0; index<size1; index++) {
            Object item1 = this.list.get(index);
            Object item2 = l.get(size2-1-index);
            if ((item1 == null ? item2 == null : item1.equals(item2)) == false) { return false; }
        }
        return true;
    }

    public T get(int index) {
        int size = this.list.size();
        return this.list.get(size-1-index);
    }

    public int hashCode() {
        return this.list.hashCode() ^ -1;
    }

    public int indexOf(Object o) {
        int index = this.list.lastIndexOf(o);
        if (index == -1) { return -1; }
        int size = this.list.size();
        return size-1-index;
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public ListIterator<T> iterator() {
        return new ReverseIterator(context, this.list, 0);
    }

    public int lastIndexOf(Object o) {
        int index = this.list.indexOf(o);
        if (index == -1) { return -1; }
        int size = this.list.size();
        return size-1-index;
    }

    public ListIterator<T> listIterator() {
        return new ReverseIterator(context, this.list, 0);
    }

    public ListIterator<T> listIterator(int index) {
        int size = this.list.size();
        return new ReverseIterator(context, this.list, index);
    }

    public T remove(int index) {
        int size = this.list.size();
        return this.list.remove(size-1-index);
    }

    public boolean remove(Object o) {
        int index = this.list.lastIndexOf(o);
        if (index == -1) { return false; }
        return (remove(index) != null ? true : false);
    }

    public boolean removeAll(Collection<?> c) {
        return this.list.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return this.list.retainAll(c);
    }

    public T set(int index, T element) {
        int size = this.list.size();
        return set(size-1-index, element);
    }
    
    public int size() {
        return this.list.size();
    }

    public List<T> subList(int fromIndex, int toIndex) {
        int size = this.list.size();
        return new ReverseList(this.context, this.list.subList(size-1-fromIndex, size-1-toIndex));
    }

    public Object[] toArray() {
        int size = this.list.size();
        Object[] array = new Object[size];
        for(int i=0, j=size-1; i<size; i++, j--) {
            array[i] = this.list.get(j);
        }
        return array;
    }

    public <T> T[] toArray(T[] array) {
        if (array == null) { throw new NullPointerException(); }
        int size = this.list.size();
        if (array.length < size) {
            array = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
        }
        int i=0, j=size-1;
        for(; i<size; i++, j--) {
            try {
                array[i] = (T) this.list.get(j);
            } catch (ClassCastException cce) {
                throw ((ArrayStoreException) (new ArrayStoreException("Types do not match").initCause(cce)));
            }
        }
        for(; i<array.length; i++, j--) {
            array[i] = null;
        }
        return array;
    }
}

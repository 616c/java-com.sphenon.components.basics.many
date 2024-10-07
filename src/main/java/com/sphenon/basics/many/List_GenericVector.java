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

public class List_GenericVector<T> implements List<T>, WithModifiableContext {

    protected CallContext context;
    protected GenericVector<T> vector;

    public List_GenericVector(CallContext context, GenericVector<T> vector) {
        this.context = context;
        this.vector = vector;
    }

    public void setContext(CallContext context) {
        this.context = context;
    }

    public CallContext getContext() {
        return this.context;
    }

    public boolean add(T item) {
        this.vector.append(context, item);
        return true;
    }

    public void add(int index, T item) {
        try {
            this.vector.insertBefore(context, index, item);
        } catch (DoesNotExist dne) {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean added = false;
        for (T item : c) {
            this.vector.append(context, item);
            added = true;
        }
        return added;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        try {
            boolean added = false;
            for (T item : c) {
                this.vector.insertBefore(context, index++, item);
                added = true;
            }
            return added;
        } catch (DoesNotExist dne) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void clear() {
        while (this.vector.getSize(context) > 0) {
            this.vector.unset(context, 0);
        }
    }

    public boolean contains(Object o) {
        if (this.vector instanceof VectorOptimized) {
            return ((VectorOptimized<T>) this.vector).contains(context, (T) o);
        } else {
            for (T item : this.vector.getIterable(context)) {
                if (o == null ? item == null : o.equals(item)) { return true; }
            }
            return false;
        }
    }

    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (this.contains(item) == false) { return false; }
        }
        return true;
    }

    public boolean equals(Object o) {
        if ((o instanceof List) == false) { return false; }
        List l = (List) o;
        int size = l.size();
        if (size != this.vector.getSize(context)) { return false; }
        for (int index = 0; index<size; index++) {
            Object item1 = this.vector.tryGet(context, index);
            Object item2 = l.get(index);
            if ((item1 == null ? item2 == null : item1.equals(item2)) == false) { return false; }
        }
        return true;
    }

    public T get(int index) {
        try {
            return this.vector.get(context, index);
        } catch (DoesNotExist dne) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int hashCode() {
        return this.vector.hashCode();
    }

    public int indexOf(Object o) {
        int index = 0;
        for (T item : this.vector.getIterable(context)) {
            if (o == null ? item == null : o.equals(item)) { return index; }
            index++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return (this.vector.getSize(context) == 0 ? true : false);
    }

    public Iterator<T> iterator() {
        return new ListIterator_GenericVector(context, this.vector);
    }

    public int lastIndexOf(Object o) {
        int index = 0;
        int last_index = -1;
        for (T item : this.vector.getIterable(context)) {
            if (o == null ? item == null : o.equals(item)) { last_index = index; }
            index++;
        }
        return last_index;
    }

    public ListIterator<T> listIterator() {
        return new ListIterator_GenericVector(context, this.vector);
    }

    public ListIterator<T> listIterator(int index) {
        return new ListIterator_GenericVector(context, this.vector, index);
    }

    public T remove(int index) {
        try {
            return this.vector.remove(context, index);
        } catch (DoesNotExist dne) {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean remove(Object o) {
        if (this.vector instanceof VectorOptimized) {
            return ((VectorOptimized<T>) this.vector).removeFirst(context, (T) o);
        } else {
            int index = 0;
            for (T item : this.vector.getIterable(context)) {
                if (o == null ? item == null : o.equals(item)) {
                    this.vector.unset(context, index);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean removeAll(Collection<?> c) {
        // Removes from this list all of its elements that are contained in the specified collection (optional operation).
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> c) {
        // Retains only the elements in this list that are contained in the specified collection (optional operation).
        throw new UnsupportedOperationException();
    }

    public T set(int index, T element) {
        try {
            return this.vector.replace(context, index, element);
        } catch (DoesNotExist dne) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    public int size() {
        return (int) this.vector.getSize(context);
    }

    public List<T> subList(int fromIndex, int toIndex) {
        // Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
        return null;
    }

    public Object[] toArray() {
        return this.toArray(new Object[(int) this.vector.getSize(context)]);
    }

    public <X> X[] toArray(X[] a) {
        if (a == null) { throw new NullPointerException(); }
        if (a.length < this.vector.getSize(context)) {
            a = (X[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), (int) this.vector.getSize(context));
        }
        int index = 0;
        for (T item : this.vector.getIterable(context)) {
            a[index++] = (X) item;
        }
        while (index < a.length) {
            a[index++] = null;
        }
        return a;
    }
}

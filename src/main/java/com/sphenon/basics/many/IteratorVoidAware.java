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

import java.util.Iterator;
import java.lang.Iterable;
import java.util.Arrays;

public class IteratorVoidAware implements Iterator {

    protected CallContext context;
    protected Iterator iterator;
    protected Object next;
    protected boolean got_next;

    public IteratorVoidAware (CallContext context, Iterator iterator) {
        this.context = context;
        this.iterator = iterator;
        this.next = null;
        this.got_next = false;
    }

    public boolean hasNext() {
        if (this.iterator == null) {
            return false;
        }
        if (this.got_next) {
            return true;
        }
        while (this.iterator.hasNext()) {
            Object test = this.iterator.next();
            if (    (test instanceof Voidable) == false
                 || ((Voidable) test).isVoid(this.context) == false
               ) {
                this.next = test;
                this.got_next = true;
                return true;
            }
        }
        return false;
    }

    public Object next() {
        if (this.hasNext()) {
            Object result = this.next;
            this.next = null;
            this.got_next = false;
            return result;
        }
        throw new java.util.NoSuchElementException();
    }

    public void remove() {
        this.iterator.remove();
        next = null;
    }
}

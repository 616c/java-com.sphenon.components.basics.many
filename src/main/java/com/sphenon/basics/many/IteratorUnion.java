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

public class IteratorUnion implements Iterator {

    protected Iterator[] iterators;
    protected Iterator   iterator;
    protected int        index;

    public IteratorUnion (CallContext context, Iterator... iterators) {
        this.iterators = iterators;
        this.iterator = null;
        this.index = 0;
    }

    public boolean hasNext() {
        if (this.iterator != null && this.iterator.hasNext()) {
            return true;
        }
        if (this.iterators != null) {
            while (this.index < this.iterators.length) {
                this.iterator = this.iterators[this.index++];
                if (this.iterator.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object next() {
        if(this.hasNext()) {
            return this.iterator.next();
        }
        throw new java.util.NoSuchElementException();
    }

    public void remove() {
    }
}

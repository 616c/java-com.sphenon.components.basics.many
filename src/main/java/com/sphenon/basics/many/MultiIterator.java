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
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.expression.*;
import com.sphenon.basics.expression.returncodes.*;

import java.util.Iterator;
import java.lang.Iterable;

import java.util.Arrays;

public class MultiIterator implements Iterator {

    protected boolean           throw_exceptions;
    protected CallContext       context;
    protected Iterator[]        iterators;
    protected Expression[]      expressions;
    protected Expression        value_expression;
    protected boolean           return_all_levels;
    protected Object[]          current;
    protected Boolean           has_next;
    protected int               size;
    protected int               current_size;
    protected ObjectIterable.IteratorConverter iterator_converter;

    public MultiIterator(CallContext context, Iterator iterator, boolean return_all_levels, boolean last_is_value, Expression... expressions) {
        this(context, iterator, return_all_levels, true, null, last_is_value, expressions);
    }

    public MultiIterator(CallContext context, Iterator iterator, boolean return_all_levels, ObjectIterable.IteratorConverter iterator_converter, boolean last_is_value, Expression... expressions) {
        this(context, iterator, return_all_levels, true, iterator_converter, last_is_value, expressions);
    }

    public MultiIterator(CallContext context, Iterator iterator, boolean return_all_levels, boolean throw_exceptions, boolean last_is_value, Expression... expressions) {
        this(context, iterator, return_all_levels, throw_exceptions, null, last_is_value, expressions);
    }

    public MultiIterator(CallContext context, Iterator iterator, boolean return_all_levels, boolean throw_exceptions, ObjectIterable.IteratorConverter iterator_converter, boolean last_is_value, Expression... expressions) {
        this.context = context;
        this.expressions = (expressions == null ? new Expression[0] : Arrays.copyOfRange(expressions, 0, expressions.length - (last_is_value ? 1 : 0)));
        this.value_expression = last_is_value ? expressions[expressions.length - 1] : null;
        this.size = this.expressions.length + 1;
        this.iterators = new Iterator[size];
        this.iterators[0] = iterator;
        this.current_size = size + (last_is_value ? 1 : 0);
        this.current = new Object[current_size];
        this.return_all_levels = return_all_levels;
        this.throw_exceptions = throw_exceptions;
        this.iterator_converter = iterator_converter;
    }

    public boolean hasNext() {
        if (has_next == null) {
            int level = size-1;
            do {
                if (this.iterators[level] != null && this.iterators[level].hasNext()) {
                    Object next_value = this.iterators[level].next();
                    this.current[level] = next_value;
                    level++;
                    if (level < size) {
                        try {
                            this.iterators[level] = new ObjectIterable(context, this.iterator_converter, this.expressions[level-1].evaluate(context, "current", next_value)).iterator();
                        } catch (EvaluationFailure ef) {
                            if (this.throw_exceptions) {
                                CustomaryContext.create((Context)context).throwConfigurationError(context, ef, "In MultiIterator, an expresion failed");
                                throw (ExceptionConfigurationError) null; // compiler insists
                            } else {
                                this.iterators[level] = null;
                            }
                        }
                    } else {
                        if (this.value_expression != null) {
                            try {
                                this.current[level] = this.value_expression.evaluate(context, "current", next_value);
                            } catch (EvaluationFailure ef) {
                                if (this.throw_exceptions) {
                                    CustomaryContext.create((Context)context).throwConfigurationError(context, ef, "In MultiIterator, an expresion failed");
                                    throw (ExceptionConfigurationError) null; // compiler insists
                                } else {
                                    this.current[level] = null;
                                }
                            }
                        }
                    }
                } else {
                    this.current[level] = null;
                    level--;
                }
            } while (level >= 0 && level < size);
            has_next = new Boolean(level >= size ? true : false);            
        }
        return has_next;
    }

    public Object next() {
        if(this.hasNext()) {
            this.has_next = null;
            return this.return_all_levels ? this.current : this.current[this.current_size - 1];
        }
        throw new java.util.NoSuchElementException();
    }

    public void remove() {
    }
}

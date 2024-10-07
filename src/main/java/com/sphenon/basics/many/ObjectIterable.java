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
import com.sphenon.basics.expression.*;
import com.sphenon.basics.expression.returncodes.*;

import java.util.Iterator;
import java.lang.Iterable;
import java.util.Arrays;
import java.util.Vector;

public class ObjectIterable implements Iterable {

    static public interface IteratorConverter {
        public Iterator getIterator(CallContext context, Object object);
    }

    protected CallContext context;
    protected Object object;
    protected boolean multiple;
    protected Expression initial_expression;
    protected Expression[] expressions;
    protected boolean return_all_levels;
    protected boolean last_is_value;
    protected boolean throw_exceptions;
    protected IteratorConverter iterator_converter;

    public ObjectIterable (CallContext context, boolean blubber, Object object) {
        throw new Error();
    }

    public ObjectIterable (CallContext context, Object object) {
        this.context = context;
        this.object = object;
        this.multiple = false;
        this.initial_expression = null;
        this.return_all_levels = true;
        this.last_is_value = false;
        this.expressions = null;
        this.iterator_converter = null;
    }

    public ObjectIterable (CallContext context, IteratorConverter iterator_converter, Object object) {
        this.context = context;
        this.object = object;
        this.multiple = false;
        this.initial_expression = null;
        this.return_all_levels = true;
        this.last_is_value = false;
        this.expressions = null;
        this.iterator_converter = iterator_converter;
    }

    public ObjectIterable (CallContext context, Object... objects) {
        this.context = context;
        this.object = objects;
        this.multiple = true;
        this.initial_expression = null;
        this.return_all_levels = true;
        this.last_is_value = false;
        this.expressions = null;
        this.iterator_converter = null;
    }
    
    public ObjectIterable (CallContext context, IteratorConverter iterator_converter, Object... objects) {
        this.context = context;
        this.object = objects;
        this.multiple = true;
        this.initial_expression = null;
        this.return_all_levels = true;
        this.last_is_value = false;
        this.expressions = null;
        this.iterator_converter = iterator_converter;
    }

    static public ObjectIterable create(CallContext context, Object object) {
        return new ObjectIterable(context, object);
    }

    static public ObjectIterable createWithExpressions(CallContext context, Scope scope, boolean return_all_levels, boolean last_is_value, String... all_expressions) {
        ObjectIterable oi = new ObjectIterable(context, (Object) null);
        oi.setInitialExpressionString(context, all_expressions[0], scope);
        oi.setExpressionStrings(context, Arrays.copyOfRange(all_expressions, 1, all_expressions.length));
        oi.setReturnAllLevels(context, return_all_levels);
        oi.setLastIsValue(context, last_is_value);
        return oi;
    }

    public void setInitialExpressionString (CallContext context, String initial_expression, Scope scope) {
        this.initial_expression = new Expression(context, initial_expression, scope);
    }

    public void setReturnAllLevels(CallContext context, boolean return_all_levels) {
        this.return_all_levels = return_all_levels;
    }

    public void setLastIsValue(CallContext context, boolean last_is_value) {
        this.last_is_value = last_is_value;
    }

    public ObjectIterable setExpressions(CallContext context, Expression... expressions) {
        this.expressions = expressions;
        return this;
    }

    public ObjectIterable setExpressionStrings(CallContext context, String... expressions) {
        return setExpressionStrings(context, true, expressions);
    }

    public ObjectIterable setExpressionStrings(CallContext context, boolean throw_exceptions, String... expressions) {
        this.expressions = new Expression[expressions.length];
        this.throw_exceptions = throw_exceptions;
        for (int i=0; i<expressions.length; i++) {
            this.expressions[i] = new Expression(context, expressions[i]);
        }
        return this;
    }

    public Iterator iterator() {
        Iterator iterator = null;
        if (this.object == null && this.initial_expression != null) {
            try {
                object = this.initial_expression.evaluate(context);
            } catch (EvaluationFailure ef) {
                if (this.throw_exceptions) {
                    CustomaryContext.create((Context)context).throwConfigurationError(context, ef, "In Object(Multi)Iterator, the initial expresion failed");
                    throw (ExceptionConfigurationError) null; // compiler insists
                } else {
                    object = null;
                }
            }
        }
        if (    this.object == null
             || (    (this.object instanceof Voidable)
                  && ((Voidable) this.object).isVoid(context)
                )
           ) {
            iterator = new Iterator() {
                public boolean hasNext() { return false; }
                public Object next() { return null; }
                public void remove() { }
            };
        } else if (multiple) {
            Object[] objects = (Object[]) this.object;
            Iterator[] iterators = new Iterator[objects.length];
            int i=0;
            for (Object o : objects) {
                iterators[i++] = (new ObjectIterable(context, this.iterator_converter, o)).iterator();
            }
            iterator = new IteratorUnion(context, iterators);
        } else if (this.iterator_converter != null) {
            iterator = this.iterator_converter.getIterator(context, object);
        } else if (object instanceof Iterable) {
            iterator = new IteratorVoidAware(context, ((Iterable) object).iterator());
        } else if (object instanceof GenericIterable) {
            iterator = new IteratorVoidAware(context, ((GenericIterable) object).getIterator(context));
        } else if (object.getClass().isArray()) {
            iterator = new IteratorVoidAware(context, Arrays.asList((Object[]) object).iterator());
        } else {
            CustomaryContext.create((Context)context).throwPreConditionViolation(context, "Object '%(object)' of class '%(class)' in ObjectIterable is neither an Iterable nor a GenericIterable", "object", object, "class", object.getClass());
            throw (ExceptionPreConditionViolation) null; // compiler insists
        }

        if (expressions != null && expressions.length > 0) {
            return new MultiIterator(context, iterator, this.return_all_levels, this.throw_exceptions, this.iterator_converter, this.last_is_value, expressions);
        } else {
            return iterator;
        }
    }
}

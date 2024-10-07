package com.sphenon.basics.expression;

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
import com.sphenon.basics.message.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.encoding.*;
import com.sphenon.basics.many.*;
import com.sphenon.basics.data.*;
import com.sphenon.basics.operations.*;

import com.sphenon.basics.expression.classes.*;
import com.sphenon.basics.expression.returncodes.*;

import java.util.Arrays;

public class ExpressionEvaluator_MultiIterator implements ExpressionEvaluator {

    public ExpressionEvaluator_MultiIterator (CallContext context) {
        this.result_attribute = new Class_ActivityAttribute(context, "Result", "Object", "-", "*");
        this.activity_interface = new Class_ActivityInterface(context);
        this.activity_interface.addAttribute(context, this.result_attribute);
    }

    protected Class_ActivityInterface activity_interface;
    protected ActivityAttribute result_attribute;

    public String[] getIds(CallContext context) {
        return new String[] { "multiiterator" };
    }

    public Object evaluate(CallContext context, String instruction, Scope scope, DataSink<Execution> execution_sink) throws EvaluationFailure {
        if (instruction == null) { return null; }

        boolean return_all_levels = instruction.startsWith("[*]") ? true : false;
        if (return_all_levels) {
            instruction = instruction.substring(3);
        }

        String[] part_expressions = instruction.split("!\\*!",-1);
        int l = part_expressions.length;
        for (int i=0; i<l; i++) {
            part_expressions[i] = Encoding.recode(context, part_expressions[i], Encoding.URI, Encoding.UTF8);
        }

        boolean last_is_value = part_expressions[l-1].isEmpty() ? false : true;

        if (last_is_value == false) {
            part_expressions = Arrays.copyOfRange(part_expressions, 0, l-1);
        }

        ObjectIterable oi = ObjectIterable.createWithExpressions(context, scope, return_all_levels, last_is_value, part_expressions);

        return oi;
    }

    public ActivityClass parse(CallContext context, ExpressionSource expression_source) throws EvaluationFailure {
        return new ActivityClass_ExpressionEvaluator(context, this, expression_source, this.activity_interface, this.result_attribute, false, null);
    }
}

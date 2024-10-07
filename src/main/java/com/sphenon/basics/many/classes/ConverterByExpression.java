package com.sphenon.basics.many.classes;

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
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.expression.*;
import com.sphenon.basics.expression.returncodes.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.tplinst.*;

public class ConverterByExpression<SourceType,TargetType> implements com.sphenon.basics.many.Converter<SourceType,TargetType>,
                                                                     com.sphenon.basics.function.Converter<SourceType,TargetType> {

    public ConverterByExpression (CallContext context) {
    }

    public ConverterByExpression (CallContext context, String expression) {
        this.expression = expression;
    }

    public TargetType convert(CallContext context, SourceType source) {
        try {
            TargetType target = (TargetType) Expression.evaluate(context, this.expression, null, "source", source);
            return target;
        } catch (EvaluationFailure ef) {
            CustomaryContext.create((Context)context).throwConfigurationError(context, ef, "Could not convert '%(source)' using expression '%(expression)'", "source", source, "expression", this.expression);
            throw (ExceptionConfigurationError) null; // compiler insists
        }
    }

    protected String expression;

    public String getExpression (CallContext context) {
        return this.expression;
    }

    public void setExpression (CallContext context, String expression) {
        this.expression = expression;
    }
}


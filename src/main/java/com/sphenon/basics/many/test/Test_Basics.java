package com.sphenon.basics.many.test;

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
import com.sphenon.basics.monitoring.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.testing.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.tplinst.*;

public class Test_Basics extends com.sphenon.basics.testing.classes.TestBase {

    public Test_Basics (CallContext context) {
    }

    public String getId(CallContext context) {
        if (this.id == null) {
            this.id = "ManyBasics";
        }
        return this.id;
    }

    public TestResult perform (CallContext context, TestRun test_run) {

        try {

            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Many VectorFilter Test");

            Vector_String_long_ vsl = Factory_Vector_String_long_.construct(context);
            vsl.append(context, "eins");
            vsl.append(context, "zwei");
            vsl.append(context, "drei");
            vsl.append(context, "vier");
            vsl.append(context, "fuenf");
            vsl.append(context, "sechs");
            vsl.append(context, "sieben");
            vsl.append(context, "acht");
            vsl.append(context, "neun");
            vsl.append(context, "zehn");

            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Unfiltered:");

            for (String s : vsl.getIterable_String_(context)) {
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            for (int i=0; i<10; i++) {
                String s = vsl.tryGet(context, i);
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            for (int i=9; i>=0; i--) {
                String s = vsl.tryGet(context, i);
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Size: '%(size)'", "size", vsl.getSize(context));
            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Size: '%(size)'", "size", vsl.getSize(context));
            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Size: '%(size)'", "size", vsl.getSize(context));

            VectorFilter_String_long_ vfsl;

            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Filtered (all true):");
            vfsl = new VectorFilter_String_long_(context, vsl, true);

            for (String s : vfsl.getIterable_String_(context)) {
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            for (int i=0; i<10; i++) {
                String s = vfsl.tryGet(context, i);
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            for (int i=9; i>=0; i--) {
                String s = vfsl.tryGet(context, i);
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Size: '%(size)'", "size", vsl.getSize(context));
            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Size: '%(size)'", "size", vsl.getSize(context));
            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Size: '%(size)'", "size", vsl.getSize(context));

            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Filtered (all false):");
            vfsl = new VectorFilter_String_long_(context, vsl, true) {
                    protected boolean isMatching(CallContext context, String item) {
                        return false;
                    }
                };

            for (String s : vfsl.getIterable_String_(context)) {
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            for (int i=0; i<10; i++) {
                String s = vfsl.tryGet(context, i);
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            for (int i=9; i>=0; i--) {
                String s = vfsl.tryGet(context, i);
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Size: '%(size)'", "size", vfsl.getSize(context));
            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Size: '%(size)'", "size", vfsl.getSize(context));
            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Size: '%(size)'", "size", vfsl.getSize(context));

            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Filtered (regexp '.*i.*'):");
            vfsl = new VectorFilter_String_long_(context, vsl, true) {
                    protected boolean isMatching(CallContext context, String item) {
                        return item.matches(".*i.*");
                    }
                };

            for (String s : vfsl.getIterable_String_(context)) {
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            for (int i=0; i<10; i++) {
                String s = vfsl.tryGet(context, i);
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            for (int i=9; i>=0; i--) {
                String s = vfsl.tryGet(context, i);
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Size: '%(size)'", "size", vfsl.getSize(context));
            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Size: '%(size)'", "size", vfsl.getSize(context));
            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Size: '%(size)'", "size", vfsl.getSize(context));

            CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Filtered (regexp '.*i.*') - Iterator:");
            vfsl = new VectorFilter_String_long_(context, vsl, true) {
                    protected boolean isMatching(CallContext context, String item) {
                        return item.matches(".*i.*");
                    }
                };

            for (Iterator_String_ is = vfsl.getNavigator(context);
                 is.canGetCurrent(context);
                 is.next(context)) {
                String s = is.tryGetCurrent(context);
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Entry: '%(value)'", "value", s);
            }

            Integer[] ia = { 1, 2, 3 };
            ObjectIterable oi = new ObjectIterable(context, (Object) ia).setExpressionStrings(context, "js:[current * 10 + 4, current * 10 + 5, current * 10 + 6]", "js:[current * 10 + 7, current * 10 + 8, current * 10 + 9]");
            for (Object o : oi) {
                CustomaryContext.create((Context)context).sendTrace(context, Notifier.CHECKPOINT, "Current: '%(value)'", "value", o);
            }

        } catch (Throwable t) {
            return new TestResult_ExceptionRaised(context, t);
        }
        
        return TestResult.OK;
    }
}


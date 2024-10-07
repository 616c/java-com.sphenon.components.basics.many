// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Pair.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.ui.annotations.*;

import com.sphenon.basics.many.returncodes.*;

 public class Pair_String_Object_ {
    private String item1;
    private Object item2;

    public Pair_String_Object_ (CallContext context, String item1, Object item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public String getItem1(CallContext context) { return item1; }
    
    public void setItem1(CallContext context, String item1) { this.item1 = item1; }

    public Object getItem2(CallContext context) { return item2; }
    
    public void setItem2(CallContext context, Object item2) { this.item2 = item2; }
}

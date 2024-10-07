// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/Pair.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.ui.annotations.*;

import com.sphenon.basics.many.returncodes.*;

 public class Pair_Long_String_ {
    private Long item1;
    private String item2;

    public Pair_Long_String_ (CallContext context, Long item1, String item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public Long getItem1(CallContext context) { return item1; }
    
    public void setItem1(CallContext context, Long item1) { this.item1 = item1; }

    public String getItem2(CallContext context) { return item2; }
    
    public void setItem2(CallContext context, String item2) { this.item2 = item2; }
}

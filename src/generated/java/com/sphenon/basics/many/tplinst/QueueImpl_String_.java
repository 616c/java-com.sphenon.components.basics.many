// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/QueueImpl.javatpl
// please do not modify this file directly
package com.sphenon.basics.many.tplinst;


import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public class QueueImpl_String_
  implements Queue_String_
{
    private java.util.LinkedList list;

    public QueueImpl_String_ (CallContext context)
    {
        list = new java.util.LinkedList ();
    }

    public QueueImpl_String_ (CallContext context, java.util.LinkedList list)
    {
        this.list = list;
    }

    public String getFront     (CallContext context) throws DoesNotExist
    {
        try {
            return (String) list.getFirst();
        } catch (java.util.NoSuchElementException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
    }

    public String tryGetFront  (CallContext context)
    {
        try {
            return (String) list.getFirst();
        } catch (java.util.NoSuchElementException e) {
            return null;
        }
    }

    public boolean  isEmpty      (CallContext context)
    {
        return (list.size() == 0) ? true : false;
    }

    public void     pushBack     (CallContext context, String item)
    {
        list.addLast(item);
    }

    public String popFront     (CallContext context) throws DoesNotExist
    {
        try {
            return (String) list.removeFirst();
        } catch (java.util.NoSuchElementException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
    }

    public String tryPopFront  (CallContext context)
    {
        try {
            return (String) list.removeFirst();
        } catch (java.util.NoSuchElementException e) {
            return null;
        }
    }
}


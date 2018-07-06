// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/QueueImpl.javatpl

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


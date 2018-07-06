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

public class Pair<T1, T2> {
    private T1 item1;
    private T2 item2;

    public Pair (CallContext context, T1 item1, T2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public T1 getItem1(CallContext context) { return item1; }
    
    public void setItem1(CallContext context, T1 item1) { this.item1 = item1; }

    public T2 getItem2(CallContext context) { return item2; }
    
    public void setItem2(CallContext context, T2 item2) { this.item2 = item2; }
}

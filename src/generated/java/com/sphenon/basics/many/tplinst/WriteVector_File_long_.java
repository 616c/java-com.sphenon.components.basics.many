// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/many/v0001/origin/source/java/com/sphenon/basics/many/templates/WriteVector.javatpl

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

import java.io.File;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.returncodes.*;

public interface WriteVector_File_long_
{
    public File set          (CallContext context, long index, File item);
    public void     add          (CallContext context, long index, File item) throws AlreadyExists;
    public void     prepend      (CallContext context, File item);
    public void     append       (CallContext context, File item);
    public void     insertBefore (CallContext context, long index, File item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, File item) throws DoesNotExist;
    public File replace      (CallContext context, long index, File item) throws DoesNotExist;
    public File unset        (CallContext context, long index);
    public File remove       (CallContext context, long index) throws DoesNotExist;
}


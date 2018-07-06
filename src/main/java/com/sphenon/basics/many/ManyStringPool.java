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
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.variatives.classes.*;

public class ManyStringPool extends StringPoolClass {
    static protected ManyStringPool singleton = null;

    static public ManyStringPool getSingleton (CallContext cc) {
        if (singleton == null) {
            singleton = new ManyStringPool(cc);
        }
        return singleton;
    }

    static public VariativeString get(CallContext cc, String id) {
        return VariativeStringClass.createVariativeStringClass(cc, id, getSingleton(cc));
    }

    static public String get(CallContext cc, String id, String isolang) {
        return getSingleton(cc).getString(cc, id, isolang);
    }

    protected ManyStringPool (CallContext cc) {
        super(cc);
        /*************************************************/
        /* THE FOLLOWING SECTION IS PARTIALLY GENERATED. */
        /* BE CAREFUL WHEN EDITING MANUALLY !            */
        /*                                               */
        /* See StringPool.java for explanation.          */
        /*************************************************/
        //BEGINNING-OF-STRINGS
        //P-0-com.sphenon.basics.many.templates
        //F-0-0-Factory_OMap.javatpl
        addEntry(cc, "0.0.0", "en", "Number of names differs from number of values");
        addEntry(cc, "0.0.0", "de", "Anzahl der Namen und Werte ist unterschiedlich");
        //F-0-0-VectorImpl.javatpl
        addEntry(cc, "0.0.1", "en", "Cannot insert element at position 0, java-lib says 'out of bounds' ???");
        addEntry(cc, "0.0.1", "de", "Element kann nicht an Position 0 eingefügt werden, java-lib meldet 'out of bounds' ???");
        addEntry(cc, "0.0.2", "en", "An exception occured, with respect to which the java-lib documentation is unfortunately incorrect");
        addEntry(cc, "0.0.2", "de", "Eine Exception ist aufgetreten, hinsichtlich deren Bedeutung die java-lib-Dokumentation leider keine korrekten Angaben macht");
        //F-0-1-Factory_Set.javatpl
        addEntry(cc, "0.1.0", "en", "Number of names differs from number of values");
        addEntry(cc, "0.1.0", "de", "Anzahl der Namen und Werte ist unterschiedlich");
        //F-0-2-Factory_OSet.javatpl
        addEntry(cc, "0.2.0", "en", "Number of names differs from number of values");
        addEntry(cc, "0.2.0", "de", "Anzahl der Namen und Werte ist unterschiedlich");
        //F-0-3-Factory_TrackingVector.javatpl
        addEntry(cc, "0.3.0", "en", "Number of names differs from number of values");
        addEntry(cc, "0.3.0", "de", "Anzahl der Namen und Werte ist unterschiedlich");
        //F-0-4-TrackingVectorImpl.javatpl
        addEntry(cc, "0.4.0", "en", "TrackingVector was notified, but with no event - don't know what to do");
        addEntry(cc, "0.4.0", "de", "TrackingVector wurde benachrichtigt, jedoch ohne Event - keine Entscheidung möglich");
        //F-0-5-Factory_Vector.javatpl
        addEntry(cc, "0.5.0", "en", "Number of names differs from number of values");
        addEntry(cc, "0.5.0", "de", "Anzahl der Namen und Werte ist unterschiedlich");
        //F-0-6-Factory_Map.javatpl
        addEntry(cc, "0.6.0", "en", "Number of names differs from number of values");
        addEntry(cc, "0.6.0", "de", "Anzahl der Namen und Werte ist unterschiedlich");
        addEntry(cc, "0.6.1", "en", "Map contains already a key named '%(key)'");
        addEntry(cc, "0.6.1", "de", "Map enthaelt bereits einen Schluessel '%(key)'");
        //END-OF-STRINGS
        /*************************************************/
    }
}

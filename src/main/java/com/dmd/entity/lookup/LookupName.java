package com.dmd.entity.lookup;


import com.dmd.tools.json.StringHashMapValueDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;


public class LookupName {
    @JsonDeserialize(using = StringHashMapValueDeserializer.class)
    String name;
    List <LookupValue> values = new ArrayList<LookupValue>();
}

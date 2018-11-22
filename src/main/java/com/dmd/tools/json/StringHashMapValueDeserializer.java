package com.dmd.tools.json;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;


import java.io.IOException;
import java.util.HashMap;

    //https://stackoverflow.com/questions/39007668/deserialize-json-array-to-map-using-jackson
public class StringHashMapValueDeserializer extends JsonDeserializer<HashMap<String, String>> {

    @Override
    public HashMap<String, String> deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        HashMap<String, String> ret = new HashMap<String, String>();

        ObjectCodec codec = parser.getCodec();
        TreeNode node = codec.readTree(parser);

        if (node.isArray()) {
            for (JsonNode n : (ArrayNode) node) {
                JsonNode id = n.get("id");
                if (id != null) {
                    JsonNode name = n.get("name");
                    ret.put(id.asText(), name.asText());
                }
            }
        }
        return ret;
    }
}
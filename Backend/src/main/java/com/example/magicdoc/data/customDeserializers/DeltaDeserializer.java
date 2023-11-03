package com.example.magicdoc.data.customDeserializers;

import com.example.magicdoc.data.operations.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.ArrayList;

public class DeltaDeserializer extends JsonDeserializer<Delta> {
    @Override
    public Delta deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode root = jp.readValueAsTree();
        Delta delta = new Delta();
        delta.setOps(new ArrayList<>());

        if (root.has("ops") && root.get("ops").isArray()) {
            ArrayNode opsArray = (ArrayNode) root.get("ops");
            for (JsonNode opNode : opsArray) {
                if (opNode.isObject()) {
                    ObjectNode opObject = (ObjectNode) opNode;
                    ///add retain
                    if (opObject.has(OperationTypes.DELETE.toString())) {
                        delta.getOps().add(mapper.treeToValue(opNode, DeleteOperation.class));
                    } else if (opObject.has(OperationTypes.INSERT.toString())) {
                        delta.getOps().add(mapper.treeToValue(opNode, InsertOperation.class));
                    } else if (opObject.has(OperationTypes.RETAIN.toString())) {
                        delta.getOps().add(mapper.treeToValue(opNode , RetainOperation.class));
                    }
                }
            }
        }
        return delta;
    }
}

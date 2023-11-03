package com.example.magicdoc.data.operations;

import com.example.magicdoc.data.customDeserializers.DeltaDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonDeserialize(using = DeltaDeserializer.class)
public class Delta {
    private List<Operation> ops;

}

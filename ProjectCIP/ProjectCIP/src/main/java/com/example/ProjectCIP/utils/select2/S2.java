package com.example.ProjectCIP.utils.select2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class S2 implements Serializable {

    private String id;
    private String text;
    private Serializable extraData;
}

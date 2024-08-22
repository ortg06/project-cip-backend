package com.example.ProjectCIP.utils;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data(staticConstructor = "of")
public class ServiceResponse implements Serializable {
    @NonNull
    private Boolean success;
    private String message;
    private Serializable data;
}

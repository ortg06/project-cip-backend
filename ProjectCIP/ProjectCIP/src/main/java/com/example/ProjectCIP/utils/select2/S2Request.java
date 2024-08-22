package com.example.ProjectCIP.utils.select2;

import lombok.Data;
import lombok.NonNull;

@Data
public class S2Request {

    private String term;
    private String q;
    @NonNull
    private Integer page;
    @NonNull
    private Integer rows;
}

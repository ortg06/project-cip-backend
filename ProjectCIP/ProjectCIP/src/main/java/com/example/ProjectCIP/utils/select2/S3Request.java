package com.example.ProjectCIP.utils.select2;

import lombok.Data;
import lombok.NonNull;

@Data
public class S3Request extends S2Request {

    private String parentId1;

    private String parentId2;

    public S3Request(@NonNull Integer page, @NonNull Integer rows) {
        super(page, rows);
    }
}

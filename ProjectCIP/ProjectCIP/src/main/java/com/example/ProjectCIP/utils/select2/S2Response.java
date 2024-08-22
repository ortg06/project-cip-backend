package com.example.ProjectCIP.utils.select2;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;


@Data(staticConstructor = "of")
public class S2Response implements Serializable {
    @NonNull
    private List<S2> results;

    @NonNull
    private Pagination pagination;

    @Data(staticConstructor = "hasMore")
    public static class Pagination implements Serializable{

        @NonNull
        private Boolean more;

    }
}

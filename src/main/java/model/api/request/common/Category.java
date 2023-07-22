package model.api.request.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {
    private String name;
    private Integer id;
}
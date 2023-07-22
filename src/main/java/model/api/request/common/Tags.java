package model.api.request.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public  class Tags {
    private String name;
    private Integer id;
}

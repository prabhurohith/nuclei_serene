package model.data.api.response;

import lombok.Data;

@Data
public class PetError {
    private Integer code;
    private String type;
    private String message;
}

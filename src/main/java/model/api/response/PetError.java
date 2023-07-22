package model.api.response;

import lombok.Data;

@Data
public class PetError {
    // This can be mapped to enum directly
    private Integer code;
    private String type;
    private String message;
}

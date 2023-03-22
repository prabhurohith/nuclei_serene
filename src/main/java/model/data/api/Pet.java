package model.data.api;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pet {
    private String name;
    private String status;
    private Long id;

    public Pet(String name, String status, Long id) {
        this.name = name;
        this.status = status;
        this.id = id;
    }

    public Pet(String name, String status) {
        this.name = name;
        this.status = status;
    }
}

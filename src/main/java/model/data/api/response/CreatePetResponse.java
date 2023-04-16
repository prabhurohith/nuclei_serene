package model.data.api.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
public class CreatePetResponse {
    private List<String> photoUrls;
    private String name;
    private Integer id;
    private Category category;
    private List<Tags> tags;
    private String status;
    @Getter
    public class Category {
        private String name;
        private Integer id;
    }
    @Getter
    public static class Tags {
        private String name;
        private Integer id;
    }
}

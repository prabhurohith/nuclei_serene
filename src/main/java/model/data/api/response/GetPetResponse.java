package model.data.api.response;

import lombok.Getter;

import java.util.List;

@Getter
public class GetPetResponse {
    private List<String> photoUrls;
    private String name;
    private Integer id;
    private Category category;
    private List<Tags> tags;
    private String status;
    @Getter
    public static class Category {
        private String name;
        private Integer id;

    }
    @Getter
    public static class Tags {
        private String name;
        private Integer id;

    }

}

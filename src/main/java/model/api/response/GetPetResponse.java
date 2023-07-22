package model.api.response;

import lombok.Getter;
import model.api.response.common.Category;
import model.api.response.common.Tags;

import java.util.List;

@Getter
public class GetPetResponse {
    private List<String> photoUrls;
    private String name;
    private Integer id;
    private Category category;
    private List<Tags> tags;
    private String status;
}

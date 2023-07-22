package model.api.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import model.api.response.common.Category;
import model.api.response.common.Tags;

import java.util.List;

@Getter
public class CreatePetResponse {
    private List<String> photoUrls;
    private String name;
    private Integer id;
    private Category category;
    private List<Tags> tags;
    private String status;
}

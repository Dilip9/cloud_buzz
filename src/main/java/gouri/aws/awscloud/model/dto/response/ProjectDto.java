package gouri.aws.awscloud.model.dto.response;



import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long id;

    private String projectName;
    private String description;
    private String technologies;  // String or List<String>
}


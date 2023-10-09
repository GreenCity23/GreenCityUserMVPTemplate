package greencity.dto.econews;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EcoNewsDto {
    private Long id;
    private ZonedDateTime creationDate;
    private String imagePath;
    private String source;
    private String shortInfo;
    private String title;
    private String text;
    private List<Long> tagIds;
    private Set<Long> usersLikedNewsIds;
    private Set<Long> usersDislikedNewsIds;

}



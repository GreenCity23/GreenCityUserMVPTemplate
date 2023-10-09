package greencity.dto.econews;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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



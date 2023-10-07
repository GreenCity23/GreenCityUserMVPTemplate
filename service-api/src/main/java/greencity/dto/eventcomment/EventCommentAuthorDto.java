package greencity.dto.eventcomment;

import lombok.*;

import javax.validation.constraints.NotEmpty;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class EventCommentAuthorDto {
    @NotEmpty
    private Long id;

    @NotEmpty
    private String name;

    private String userProfilePicturePath;
}

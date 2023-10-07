package greencity.dto.user;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link greencity.entity.User}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
public class AttendersEmailsDto implements Serializable {
    Long id;
    String name;
    String email;
}

package greencity.dto.user;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class UserManagementViewDto {
    @Pattern(regexp = "^\\d*$",
        message = "Id should be a number!")
    private String id;

    private String name;

    @Email
    private String email;

    private String userCredo;

    @Pattern(regexp = "^ROLE_[a-zA-Z]*$",
        message = "Role should start from 'ROLE_' and can't contain any numbers or special symbols!")
    private String role;

    @Pattern(regexp = "^\\d*$",
        message = "Status should be a number!")
    private String userStatus;
}

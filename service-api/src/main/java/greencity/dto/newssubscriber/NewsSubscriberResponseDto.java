package greencity.dto.newssubscriber;

import static greencity.constant.AppConstant.VALIDATION_EMAIL;

import java.io.Serializable;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class NewsSubscriberResponseDto implements Serializable {
    Long id;
    @Email(regexp = VALIDATION_EMAIL)
    private String email;
    private String unsubscribeToken;
    private String confirmationToken;
}

package greencity.service;

import greencity.security.dto.SuccessSignInDto;

public interface FacebookSecurityService {
    String generateFacebookAuthorizeURL();
}

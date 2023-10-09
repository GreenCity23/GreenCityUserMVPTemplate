package greencity.service;

import greencity.security.jwt.JwtTool;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

@Service
public class FacebookSecurityServiceImpl implements FacebookSecurityService {
    @Value("${facebook.appId}")
    private String facebookAppId;
    @Value("${facebook.appSecret}")
    private String facebookAppSecret;

    private final UserService userService;
    private final JwtTool jwtTool;
    private final ModelMapper modelMapper;

    @Autowired
    public FacebookSecurityServiceImpl(UserService userService,
        JwtTool jwtTool,
        ModelMapper modelMapper) {
        this.userService = userService;
        this.jwtTool = jwtTool;
        this.modelMapper = modelMapper;
    }

    private FacebookConnectionFactory createFacebookConnection() {
        return new FacebookConnectionFactory(facebookAppId, facebookAppSecret);
    }

    @Override
    public String generateFacebookAuthorizeURL() {
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri("http://localhost:8065" + "/facebookSecurity/facebook");
        params.setScope("email");
        return createFacebookConnection()
            .getOAuthOperations()
            .buildAuthenticateUrl(params);
    }
}

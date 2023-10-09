package greencity.security.controller;

import greencity.service.FacebookSecurityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facebookSecurity")
public class FacebookSecurityController {
    private final FacebookSecurityService facebookSecurityService;

    @Autowired
    public FacebookSecurityController(FacebookSecurityService facebookSecurityService) {
        this.facebookSecurityService = facebookSecurityService;
    }

    @ApiOperation("Generate Facebook Authorization URL")
    @GetMapping("/generateFacebookAuthorizeURL")
    public String generateFacebookAuthorizeURL() {
        return facebookSecurityService.generateFacebookAuthorizeURL();
    }
}
package greencity.controller;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuth2LoginSuccessController {

    @GetMapping("/login/oauth2/code/google")
    public String googleLoginSuccess(@AuthenticationPrincipal OAuth2User oauth2User) {
        // Redirect or perform further actions as needed
        return "redirect:/";
    }
}

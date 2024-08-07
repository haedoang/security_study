package io.haedoang.sampleproject;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping
    public String index() {
        return "hello";
    }


    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("authentication")
    public String authentication(Authentication authentication) {

        if (authentication instanceof AnonymousAuthenticationToken) {
            return "anonymous"; //Unreachable
        }

        return "not anonymous";
    }

    @GetMapping("anonymousContext")
    public String anonymousContext(@CurrentSecurityContext SecurityContext securityContext) {
        return securityContext.getAuthentication().getName();
    }

    @GetMapping("anonymous")
    public String anonymous() {
        return "anonymous";
    }
}

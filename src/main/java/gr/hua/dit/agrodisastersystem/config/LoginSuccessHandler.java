package gr.hua.dit.agrodisastersystem.config;

import gr.hua.dit.agrodisastersystem.model.UserDetailsImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Value("${app.react.proxy}")
    String baseRedirectURL;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        logger.info("Authentication Success for user: {}", userDetails.getUsername());

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        String redirectURL = baseRedirectURL;

        for (GrantedAuthority authority : authorities) {
            logger.info("Authority: {}", authority.getAuthority());
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                redirectURL += "admin/users/register";
                break;
            }
            if (authority.getAuthority().equals("ROLE_FARMER")) {
                redirectURL += "request/form";
                break;
            }
            if (authority.getAuthority().equals("ROLE_EMPLOYEE")) {
                redirectURL += "requests/sendTo";
                break;
            }
        }

        response.sendRedirect(redirectURL);
    }
}

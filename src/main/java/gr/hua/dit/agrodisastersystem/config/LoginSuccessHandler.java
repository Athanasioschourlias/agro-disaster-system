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
import java.util.Objects;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Value("${app.react.proxy}")
    String redirectURL;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        UserDetailsImpl userDetails= (UserDetailsImpl) authentication.getPrincipal();

        logger.info("Authentication Success for user: {}", userDetails.getUsername());

        Collection<? extends GrantedAuthority> authorities= userDetails.getAuthorities();

        authorities.forEach(auth -> logger.info("Authority: {}", auth.getAuthority()));

        if(Objects.equals(userDetails.hasRole(), "ADMIN")){
            redirectURL += "admin/users/register";
        }
        if(Objects.equals(userDetails.hasRole(), "FARMER")){
            redirectURL += "request/form";
        }
        if(Objects.equals(userDetails.hasRole(), "EMPLOYEE")){
            redirectURL += "requests/sendTo";
        }

        response.sendRedirect(redirectURL);
    }
}

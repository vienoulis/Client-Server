package ru.vienoulis.client.component.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.vienoulis.client.component.model.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

//        httpServletResponse.sendRedirect("/admin");

        if (authentication.getAuthorities().contains(new Role(1L, "ROLE_ADMIN"))) {
            httpServletResponse.sendRedirect("admin");
        } else if (authentication.getAuthorities().contains(new Role(2L, "ROLE_USER"))) {
            httpServletResponse.sendRedirect("user");
        }
    }
}
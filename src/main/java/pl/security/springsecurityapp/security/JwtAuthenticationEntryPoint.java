package pl.security.springsecurityapp.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import pl.security.springsecurityapp.exception.UnauthorizedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Log4j2
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      AuthenticationException e) throws IOException {
    httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
            "Sorry, You're not authorized to access this resource.");
//    throw new UnauthorizedException("Unauthorized. You dont' have access to this resource");
  }
}

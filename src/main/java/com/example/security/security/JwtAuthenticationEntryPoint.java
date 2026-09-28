package com.example.security.security;
import com.example.security.dto.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.IOException;
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        String message = (String) request.getAttribute("JWT_ERROR");
        if (message == null) {
            message = "Unauthorized: Token không hợp lệ hoặc đã hết hạn";
        }

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(HttpServletResponse.SC_UNAUTHORIZED)
                .message("Lỗi xác thực Token: " + message)
                .status("FAIL")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(errorResponse));
    }
}

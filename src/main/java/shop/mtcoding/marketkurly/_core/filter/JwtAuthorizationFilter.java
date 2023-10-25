package shop.mtcoding.marketkurly._core.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.MediaType;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import shop.mtcoding.marketkurly._core.errors.exception.Exception401;
import shop.mtcoding.marketkurly._core.utils.JwtTokenUtils;
import shop.mtcoding.marketkurly.user.User;

// public class JwtAuthorizationFilter implements Filter {

// @Override
// public void doFilter(ServletRequest req, ServletResponse resp, FilterChain
// chain)
// throws IOException, ServletException {
// HttpServletRequest request = (HttpServletRequest) req;
// HttpServletResponse response = (HttpServletResponse) resp;

// String jwt = request.getHeader("Authorization");
// if (jwt == null || jwt.isEmpty()) {
// onError(response, "토큰이 없습니다");
// return;
// }

// try {
// DecodedJWT decodedJWT = JwtTokenUtils.verify(jwt);
// int userId = decodedJWT.getClaim("id").asInt();
// String email = decodedJWT.getClaim("email").asString();

// User sessionUser = User.builder().id(userId).userEmail(email).build();

// HttpSession session = request.getSession();
// session.setAttribute("sessionUser", sessionUser);

// chain.doFilter(request, response);
// } catch (SignatureVerificationException | JWTDecodeException e1) {
// onError(response, "토큰 검증 실패");
// } catch (TokenExpiredException e2) {
// onError(response, "토큰 시간 만료");
// }
// }

// private void onError(HttpServletResponse response, String msg) {
// Exception401 e401 = new Exception401(msg);

// try {
// String body = new ObjectMapper().writeValueAsString(e401.body());
// response.setStatus(e401.status().value());
// // response.setHeader("Content-Type", "application/json; charset=utf-8");
// response.setContentType(MediaType.APPLICATION_JSON_VALUE);
// PrintWriter out = response.getWriter();
// out.println(body);
// } catch (Exception e) {
// System.out.println("파싱 에러가 날 수 없음");
// }
// }
// }

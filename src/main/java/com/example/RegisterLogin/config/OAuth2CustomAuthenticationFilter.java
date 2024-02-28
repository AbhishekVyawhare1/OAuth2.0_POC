//package com.example.RegisterLogin.config;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OAuth2CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//
//    private final TokenStore tokenStore = new InMemoryTokenStore();
//    private final DefaultTokenServices tokenServices = new DefaultTokenServices();
//
//    
//    
//    @Autowired
//    public OAuth2CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
//        super("/oauth/token");
//        setAuthenticationManager(authenticationManager);
//        tokenServices.setTokenStore(tokenStore);
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        Authentication authentication = getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(email, password));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        return authentication;
//    }
//
//    
//}

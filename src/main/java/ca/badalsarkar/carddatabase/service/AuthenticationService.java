package ca.badalsarkar.carddatabase.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;

public class AuthenticationService {

    static final long EXPIRATIONTIME= 864_000_00;
    static final String SIGNINKEY = "Store this to some hidden place";
    static final String PREFIX= "Bearer";

    // Add token to the response Authorization header
    static public void addToken(HttpServletResponse response, String username){
        String token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SIGNINKEY)
                .compact();
        response.addHeader("Authorization", PREFIX+" "+token);
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    // Extract token from request
    static public Authentication getAuthentication(HttpServletRequest request){
        String token= request.getHeader("Authorization");
        if(token!=null){
            String user = Jwts.parser()
                    .setSigningKey(SIGNINKEY)
                    .parseClaimsJws(token.replace(PREFIX,""))
                    .getBody()
                    .getSubject();

            if (user != null){
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            }
        }
        return null;
    }
}

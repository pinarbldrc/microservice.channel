package customerApplication.security.auth;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenManager {


    @Value("${jwt.privatekey}")
    private  String privatekey;

    @Value("${jwt.issuer}")
    private String issuer;




    public String generateToken(String username){


     try {

         Algorithm algorithm=Algorithm.HMAC512(privatekey);

         return JWT.create()
                 .withAudience()
                 .withClaim("username",username)
                 .withIssuedAt(new Date())
                 .withKeyId("id")
                 .withIssuer(issuer)
                 .sign(algorithm);

     }
     catch (Exception e){
         return null;
     }
    }


    public DecodedJWT verifyToken(String token){

        try {

            Algorithm algorithm=Algorithm.HMAC512(privatekey);
            JWTVerifier jwtVerifier=JWT.require(algorithm)
                                       .withIssuer(issuer)
                                        .acceptLeeway(1)
                                         .acceptExpiresAt(100*60)
                                         .build();
            return jwtVerifier.verify(token);

        }
        catch (Exception e){
            return null;
        }
    }
}

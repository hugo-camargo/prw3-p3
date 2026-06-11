package br.edu.ifsp.prw3.p3.util.security;

import br.edu.ifsp.prw3.p3.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class PW3TokenService {

    @Value("${pw3.senha.principal.geracao.token")
    private String secret;

    public String gerarToken(Usuario usuario) {
        System.out.println(secret);
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("MECANICA LUIGI E HUGO")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            JWTVerifier jwtv = JWT.require(algoritmo)
                    .withIssuer("MECANICA LUIGI E HUGO")
                    .build();
            return jwtv.verify(tokenJWT).getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
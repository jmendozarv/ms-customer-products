package encora.challenger.api.mscustomerproducts.infraestructure.adapters.security.jwt.manager;

import encora.challenger.api.mscustomerproducts.infraestructure.adapters.security.jwt.provider.JwtProvider;
import java.util.List;
import java.util.Map;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationManager implements ReactiveAuthenticationManager {

    private final JwtProvider jwtProvider;

    public JwtAuthenticationManager(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return Mono.just(authentication)
            .map(auth -> jwtProvider.getClaims(auth.getCredentials().toString()))
            .map(claims -> {
                List<Map<String, String>> roles = (List<Map<String, String>>) claims.get("roles");
                if (roles == null || roles.isEmpty()) {
                    roles = List.of(Map.of("authority", "ROLE_USER"));
                }
                List<SimpleGrantedAuthority> authorities = roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.get("authority")))
                    .toList();
                return new UsernamePasswordAuthenticationToken(claims.getSubject(), null, authorities);
            });
    }
}
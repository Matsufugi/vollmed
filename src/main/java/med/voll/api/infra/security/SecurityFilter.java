package med.voll.api.infra.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.domain.usuario.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// @Component é utilizado para que o spring  carregue uma classe/componente de forma genérica
@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private IUsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @Override
    // request -> pegar coisas da requisição
    // reponse -> enviar
    // filterChain -> cadeia de filtros da requisição
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null){
            var subject = tokenService.getSubject(tokenJWT);
            var user = repository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken( user,null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        // chama os proximos filtros da aplicação
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "").trim();
        }

        return null;
    }
}

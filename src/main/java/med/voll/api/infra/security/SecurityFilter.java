package med.voll.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // utilizamos para que o spring carregue uma classe/componente genérico
public class SecurityFilter extends OncePerRequestFilter { //implementa a interface filter

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJDW = recuperarToken(request);

        if(tokenJDW != null){
            var subject = tokenService.getSubject(tokenJDW); // recupera  token
            var usuario = repository.findByLogin(subject); // valida se o token esta correto

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            // pega o usuario que esta dentro do token

            SecurityContextHolder.getContext().setAuthentication(authentication); // força uma autenticação
        }

        filterChain.doFilter(request, response); // encaminha para próximo filtro da aplicação.
    } // esse método garante que o token será gerado apenas 1 vez

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader != null){
            return authorizationHeader.replace("Bearer", "").trim();
        }

        return null;
    }
}

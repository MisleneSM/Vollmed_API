package med.voll.api.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // explica pro spring que a classe seria um componente do tipo serviço (sendo de autenticação)
public class AutenticacaoService implements UserDetailsService { // UserDetailsService lida com autenticação
    @Autowired // utilizamos para injetar dependencia (construtor diferenciado)
    private UsuarioRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    } // sempre que o usuario realizar o login o spring ira chamar essa classe
}

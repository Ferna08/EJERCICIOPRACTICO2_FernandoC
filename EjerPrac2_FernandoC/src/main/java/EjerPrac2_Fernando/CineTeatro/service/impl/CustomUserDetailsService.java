/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.service.impl;
import EjerPrac2_Fernando.CineTeatro.dao.UsuarioDao;
import EjerPrac2_Fernando.CineTeatro.domain.Usuario;
import java.util.Collections;
import java.util.Optional;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferna
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioDao usuarioDao;

    public CustomUserDetailsService(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Optional<Usuario> optionalUsuario = usuarioDao.findByCorreo(correo);

        if (optionalUsuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        Usuario usuario = optionalUsuario.get();

        return new User(
            usuario.getCorreo(),
            usuario.getContrasena(),
            Collections.singleton(new SimpleGrantedAuthority(usuario.getRol()))
        );
    }
}


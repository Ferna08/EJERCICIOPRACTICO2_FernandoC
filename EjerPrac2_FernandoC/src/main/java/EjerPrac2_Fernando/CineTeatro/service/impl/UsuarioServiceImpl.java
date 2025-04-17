/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.service.impl;
import EjerPrac2_Fernando.CineTeatro.dao.UsuarioDao;
import EjerPrac2_Fernando.CineTeatro.domain.Usuario;
import EjerPrac2_Fernando.CineTeatro.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferna
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioDao.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorCorreo(String correo) {
        return usuarioDao.findByCorreo(correo);
    }

    @Override
    public void guardar(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public void eliminar(int id) {
        usuarioDao.deleteById(id);
    }
}

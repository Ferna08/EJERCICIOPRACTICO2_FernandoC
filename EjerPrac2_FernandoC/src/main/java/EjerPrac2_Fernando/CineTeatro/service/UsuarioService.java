/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.service;
import EjerPrac2_Fernando.CineTeatro.domain.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ferna
 */

public interface UsuarioService {
    List<Usuario> obtenerTodos();
    Optional<Usuario> obtenerPorCorreo(String correo);
    void guardar(Usuario usuario);
    void eliminar(int id);
}

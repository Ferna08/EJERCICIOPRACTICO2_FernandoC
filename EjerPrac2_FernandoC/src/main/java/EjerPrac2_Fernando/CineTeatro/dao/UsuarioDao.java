/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.dao;
import EjerPrac2_Fernando.CineTeatro.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ferna
 */

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreo(String correo);
}


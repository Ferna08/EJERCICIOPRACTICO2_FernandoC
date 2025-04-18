/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.dao;
import EjerPrac2_Fernando.CineTeatro.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import EjerPrac2_Fernando.CineTeatro.domain.Usuario;

/**
 *
 * @author ferna
 */

public interface ReservaDao extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByUsuario(Usuario usuario);
}

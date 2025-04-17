/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.service;
import EjerPrac2_Fernando.CineTeatro.domain.Reserva;
import java.util.List;

/**
 *
 * @author ferna
 */

public interface ReservaService {
    List<Reserva> obtenerPorCorreoUsuario(String correo);
    void reservar(String correo, int idFuncion, int cantidad);
    void cancelar(int idReserva);
}
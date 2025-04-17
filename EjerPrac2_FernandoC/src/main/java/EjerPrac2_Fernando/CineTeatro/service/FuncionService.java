/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.service;
import EjerPrac2_Fernando.CineTeatro.domain.Funcion;
import java.util.List;

/**
 *
 * @author ferna
 */

public interface FuncionService {
    List<Funcion> obtenerTodas();
    Funcion obtenerPorId(int id);
    void guardar(Funcion funcion);
    void eliminar(int id);
}

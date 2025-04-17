/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.service;
import EjerPrac2_Fernando.CineTeatro.domain.Pelicula;
import java.util.List;

/**
 *
 * @author ferna
 */

public interface PeliculaService {
    List<Pelicula> obtenerTodas();
    Pelicula obtenerPorId(int id);
    void guardar(Pelicula pelicula);
    void eliminar(int id);
}

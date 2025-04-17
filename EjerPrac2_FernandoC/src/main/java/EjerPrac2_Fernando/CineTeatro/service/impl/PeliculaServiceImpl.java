/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.service.impl;
import EjerPrac2_Fernando.CineTeatro.dao.PeliculaDao;
import EjerPrac2_Fernando.CineTeatro.domain.Pelicula;
import EjerPrac2_Fernando.CineTeatro.service.PeliculaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferna
 */
@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaDao peliculaDao;

    @Override
    public List<Pelicula> obtenerTodas() {
        return peliculaDao.findAll();
    }

    @Override
    public Pelicula obtenerPorId(int id) {
        Optional<Pelicula> optional = peliculaDao.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void guardar(Pelicula pelicula) {
        peliculaDao.save(pelicula);
    }

    @Override
    public void eliminar(int id) {
        peliculaDao.deleteById(id);
    }
}

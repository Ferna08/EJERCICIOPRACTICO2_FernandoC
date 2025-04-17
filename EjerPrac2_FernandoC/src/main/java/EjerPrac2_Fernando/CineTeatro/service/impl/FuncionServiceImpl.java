/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.service.impl;
import EjerPrac2_Fernando.CineTeatro.dao.FuncionDao;
import EjerPrac2_Fernando.CineTeatro.domain.Funcion;
import EjerPrac2_Fernando.CineTeatro.service.FuncionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferna
 */


@Service
public class FuncionServiceImpl implements FuncionService {

    @Autowired
    private FuncionDao funcionDao;

    @Override
    public List<Funcion> obtenerTodas() {
        return funcionDao.findAll();
    }

    @Override
    public Funcion obtenerPorId(int id) {
        Optional<Funcion> optional = funcionDao.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void guardar(Funcion funcion) {
        funcionDao.save(funcion);
    }

    @Override
    public void eliminar(int id) {
        funcionDao.deleteById(id);
    }
}

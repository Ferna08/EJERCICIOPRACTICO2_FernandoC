/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.service.impl;
import EjerPrac2_Fernando.CineTeatro.dao.FuncionDao;
import EjerPrac2_Fernando.CineTeatro.dao.ReservaDao;
import EjerPrac2_Fernando.CineTeatro.dao.UsuarioDao;
import EjerPrac2_Fernando.CineTeatro.domain.Funcion;
import EjerPrac2_Fernando.CineTeatro.domain.Reserva;
import EjerPrac2_Fernando.CineTeatro.domain.Usuario;
import EjerPrac2_Fernando.CineTeatro.service.ReservaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferna
 */

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaDao reservaDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private FuncionDao funcionDao;

    @Override
    public List<Reserva> obtenerPorCorreoUsuario(String correo) {
        Optional<Usuario> usuario = usuarioDao.findByCorreo(correo);
        return usuario.map(reservaDao::findByUsuario).orElse(List.of());
    }

    @Override
    public void reservar(String correo, int idFuncion, int cantidad) {
Usuario usuario = usuarioDao.findByCorreo(correo)
    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

Funcion funcion = funcionDao.findById(idFuncion)
    .orElseThrow(() -> new RuntimeException("Función no encontrada"));

        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setFuncion(funcion);
        reserva.setCantidad(cantidad);

        reservaDao.save(reserva);
    }

    @Override
    public void cancelar(int idReserva) {
        reservaDao.deleteById(idReserva);
    }
}

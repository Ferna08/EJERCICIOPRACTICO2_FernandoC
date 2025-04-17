/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import EjerPrac2_Fernando.CineTeatro.domain.*;
import EjerPrac2_Fernando.CineTeatro.service.*;
/**
 *
 * @author ferna
 */
@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private FuncionService funcionService;

    @GetMapping
    public String verReservas(Model model, Authentication auth) {
        String correo = auth.getName();
        model.addAttribute("reservas", reservaService.obtenerPorCorreoUsuario(correo));
        return "reservas";
    }

    @PostMapping("/realizar")
    public String realizarReserva(@RequestParam int idFuncion, @RequestParam int cantidad, Authentication auth) {
        String correo = auth.getName();
        reservaService.reservar(correo, idFuncion, cantidad);
        return "redirect:/reservas";
    }

    @PostMapping("/cancelar")
    public String cancelarReserva(@RequestParam int idReserva) {
        reservaService.cancelar(idReserva);
        return "redirect:/reservas";
    }
}

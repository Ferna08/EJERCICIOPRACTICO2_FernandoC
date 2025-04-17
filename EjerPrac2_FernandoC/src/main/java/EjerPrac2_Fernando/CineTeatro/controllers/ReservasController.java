/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.controllers;

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

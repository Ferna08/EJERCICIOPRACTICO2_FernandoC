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
@RequestMapping("/gestion")
@PreAuthorize("hasAuthority('ADMIN')")
public class GestionController {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private FuncionService funcionService;

    @GetMapping("/peliculas")
    public String verPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.obtenerTodas());
        return "gestionPeliculas";
    }

    @PostMapping("/peliculas/guardar")
    public String guardarPelicula(Pelicula pelicula) {
        peliculaService.guardar(pelicula);
        return "redirect:/gestion/peliculas";
    }

    @GetMapping("/funciones")
    public String verFunciones(Model model) {
        model.addAttribute("funciones", funcionService.obtenerTodas());
        model.addAttribute("peliculas", peliculaService.obtenerTodas());
        return "gestionFunciones";
    }

    @PostMapping("/funciones/guardar")
    public String guardarFuncion(Funcion funcion) {
        funcionService.guardar(funcion);
        return "redirect:/gestion/funciones";
    }
}


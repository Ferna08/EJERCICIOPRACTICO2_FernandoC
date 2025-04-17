/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.controllers;
import EjerPrac2_Fernando.CineTeatro.domain.Funcion;
import EjerPrac2_Fernando.CineTeatro.domain.Pelicula;
import EjerPrac2_Fernando.CineTeatro.service.FuncionService;
import EjerPrac2_Fernando.CineTeatro.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestParam;
import EjerPrac2_Fernando.CineTeatro.domain.*;
import EjerPrac2_Fernando.CineTeatro.service.*;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjerPrac2_Fernando.CineTeatro.controllers;
import EjerPrac2_Fernando.CineTeatro.dao.FuncionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ferna
 */

@Controller
public class CarteleraController {

    @Autowired
    private FuncionDao funcionDao;

    @GetMapping("/cartelera")
    public String verCartelera(Model model) {
        model.addAttribute("funciones", funcionDao.findAll());
        return "cartelera";
    }
}

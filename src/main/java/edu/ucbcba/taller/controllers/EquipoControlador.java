package edu.ucbcba.taller.controllers;

import edu.ucbcba.taller.entities.Equipo;
import edu.ucbcba.taller.services.EquipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by HP on 20/8/2017.
 */
@Controller
public class EquipoControlador {

    private EquipoServicio equipoServicio;

    @Autowired
    public void setEquipoServicio(EquipoServicio equipoServicio) {
        this.equipoServicio = equipoServicio;
    }



    @RequestMapping(value = "/equipo/{id}", method = RequestMethod.GET)
    public String verEquipo(@PathVariable Integer id, Model model) {
        model.addAttribute("equipo", equipoServicio.getEquipoById(id));
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(equipoServicio.getEquipoById(id).getFundacion());
        model.addAttribute("fecha",fecha);
        return "equipoShow";
    }



    @RequestMapping(value = "/equipo/new", method = RequestMethod.GET)
    public String newEquipo(Model model) {
        model.addAttribute("equipo", new Equipo());
        return "equipoForm";
    }

    @RequestMapping(value = "equipo", method = RequestMethod.POST)
    public String saveEquipo(@Valid Equipo equipo, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            return "equipoForm";
        }

        equipoServicio.saveEquipo(equipo);
        return "redirect:/equipo/" + equipo.getId();
    }

    @RequestMapping("/equipo/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("equipo", equipoServicio.getEquipoById(id));
        return "equipoForm";
    }
}

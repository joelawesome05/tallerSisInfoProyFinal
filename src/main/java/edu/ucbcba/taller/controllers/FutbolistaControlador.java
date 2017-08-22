package edu.ucbcba.taller.controllers;

import edu.ucbcba.taller.entities.Futbolista;
import edu.ucbcba.taller.services.FutbolistaServicio;
import edu.ucbcba.taller.services.PosicionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by HP on 13/8/2017.
 */
@Controller
public class FutbolistaControlador {

    private FutbolistaServicio futbolistaServicio;
    private PosicionServicio posicionServicio;

    @Autowired
    public void setFutbolistaServicio(FutbolistaServicio futbolistaServicio) {
        this.futbolistaServicio = futbolistaServicio;
    }
    @Autowired
    public void setPosicionServicio(PosicionServicio posicionServicio) {
        this.posicionServicio = posicionServicio;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/futbolistas", method = RequestMethod.GET)
    public String listarJugadores(Model model) {
        model.addAttribute("futbolistas", futbolistaServicio.listAllFutbolistas());
        return "futbolistas";
    }

    @RequestMapping(value = "/futbolista/{id}", method = RequestMethod.GET)
    public String verJugador(@PathVariable Integer id, Model model) {
        model.addAttribute("futbolista", futbolistaServicio.getFutbolistaById(id));
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(futbolistaServicio.getFutbolistaById(id).getNacimiento());
        model.addAttribute("fecha",fecha);
        return "futbolistaShow";
    }

    @RequestMapping(value = "/futbolista/delete/{id}", method = RequestMethod.GET)
    public String deleteTerminal(@PathVariable Integer id, Model model) {
        futbolistaServicio.deleteFutbolista(id);
        model.addAttribute("futbolistas", futbolistaServicio.listAllFutbolistas());
        return "futbolistas";
    }

    @RequestMapping(value = "/futbolista/new", method = RequestMethod.GET)
    public String newTerminal(Model model) {
        model.addAttribute("futbolista", new Futbolista());
        model.addAttribute("posiciones", posicionServicio.listAllPosiciones());
        return "futbolistaForm";
    }

    @RequestMapping(value = "futbolista", method = RequestMethod.POST)
    public String saveFutbolista(@Valid Futbolista futbolista, BindingResult bindingResult,Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("posiciones", posicionServicio.listAllPosiciones());
            return "futbolistaForm";
        }

        futbolistaServicio.saveFutbolista(futbolista);
        return "redirect:/futbolista/" + futbolista.getId();
    }

    @RequestMapping("/futbolista/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("futbolista", futbolistaServicio.getFutbolistaById(id));
        model.addAttribute("posiciones", posicionServicio.listAllPosiciones());
        return "futbolistaForm";
    }

    /*
    @RequestMapping(value = "futbolista", method = RequestMethod.POST)
    public String saveFutbolista(Futbolista futbolista) {
        futbolistaServicio.saveFutbolista(futbolista);
        return "redirect:/futbolista/" + futbolista.getId();
    }*/
}

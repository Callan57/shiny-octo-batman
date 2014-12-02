package fr.utbm.web.controller;

import fr.utbm.core.entity.Station;
import fr.utbm.core.model.Wendu;
import fr.utbm.core.service.IServiceListeTemperatures;
import fr.utbm.core.service.IServiceStation;
import fr.utbm.web.form.StationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Yohann on 22/11/2014.
 * Classe gérant les demandes des utilisateurs
 */

@Controller
public class RechercheController {

    @Autowired
    IServiceListeTemperatures serviceTemp; //service température
    @Autowired
    IServiceStation serviceStation; //service station

    //------------------------------------------------------------------------
    //Page d'accueil recheche.jsp en GET
    //pModel : permet de passe des paramètres
    //------------------------------------------------------------------------
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String LastTemperature(final ModelMap pModel) {
        //récupération des dernières températures
        ArrayList<Wendu> tempList = serviceTemp.getLastTemperatures();
        //passage de la liste à la vue
        pModel.addAttribute("tempList", tempList);
        //redirection vers recherche.jsp
        return "recherche";
    }

    //------------------------------------------------------------------------
    //Page station station.jsp en GET (sans filtrage)
    //id : correspond à la station recherchée {id}
    //pModel : permet de passe des paramètres
    //------------------------------------------------------------------------
    @RequestMapping(value = "/station/{id}", method = RequestMethod.GET)
    public String StationTempetature(@PathVariable int id ,final ModelMap pModel) {

        //initailisation du formulaire avec des champs vide
        StationForm formData = new StationForm("","");
        //initinalisation de la variable d'erreurs
        ArrayList<String> errors = new ArrayList<String>();

        //récupération des températures de la station
        ArrayList<Wendu> tempList = serviceTemp.getTemperatures(id);
        //récupération des information de la station
        Station station = serviceStation.getStaionById(id);
        //passage des paramètres à la vue
        pModel.addAttribute("tempList", tempList);// liste température
        pModel.addAttribute("station", station.getLabel());//nom de la station
        pModel.addAttribute("zone", station.getArea().getLabel());//zone de la station
        pModel.addAttribute("route", station.getArea().getRoad());//route de la zone
        pModel.addAttribute("id", id);// idendifiant de la station
        pModel.addAttribute("errors", errors);//liste des erreurs
        pModel.addAttribute("StationForm",formData);//données du formulaire
        //redirection vers station.jsp
        return "station";
    }

    //------------------------------------------------------------------------
    //Page station station.jsp en POST (avec filtrage)
    //id : correspond à la station recherchée {id}
    //formData : données saisie dans le formulaire
    //pModel : permet de passe des paramètres
    //------------------------------------------------------------------------
    @RequestMapping(value = "/station/{id}", method = RequestMethod.POST)
    public String StationTempetatureFilterd(@PathVariable int id ,@ModelAttribute("StationForm") StationForm formData,final ModelMap pModel) {

        //initinalisation de la variable d'erreurs
        ArrayList<String> errors = new ArrayList<String>();
        //choix du format de date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //initialisation des date
        Date dateBegin = null;
        Date dateEnd = null;
        //initailisation de la liste de températures
        ArrayList<Wendu> tempList = null;

        try {
            //conversion des dates en type Date
            dateBegin = sdf.parse(formData.getBegin());
            dateEnd = sdf.parse(formData.getEnd());
            //récupération des information de la station en fonction de la période
            tempList = serviceTemp.getFilteredTemperatures(dateBegin, dateEnd, id);
            //si impossibe de convertir
        } catch (ParseException e) {
            //récupération des information de la station
            tempList = serviceTemp.getTemperatures(id);
            //ajout d'une erreur : format de date incorrect
            errors.add("Format de date incorrect ! YYYY-MM-DD");
            e.printStackTrace();
        }
        //récupération des information de la station
        Station station = serviceStation.getStaionById(id);
        //passage des paramètres à la vue
        pModel.addAttribute("tempList", tempList);// liste température
        pModel.addAttribute("station", station.getLabel());//nom de la station
        pModel.addAttribute("zone", station.getArea().getLabel());//zone de la station
        pModel.addAttribute("route", station.getArea().getRoad());//route de la zone
        pModel.addAttribute("id", id);// idendifiant de la station
        pModel.addAttribute("errors", errors);//liste des erreurs
        pModel.addAttribute("StationForm",formData);//données du formulaire
        //redirection vers station.jsp
        return "station";
    }
}
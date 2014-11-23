package fr.utbm.web.controller;

import fr.utbm.core.entity.Station;
import fr.utbm.core.model.Wendu;
import fr.utbm.core.service.IServiceListeTemperatures;
import fr.utbm.core.service.IServiceStation;
import fr.utbm.web.form.StationForm;
import org.exolab.castor.types.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class RechercheController {

    @Autowired
    IServiceListeTemperatures serviceTemp;
    IServiceStation serviceStation;

	@RequestMapping(value = "/", method = RequestMethod.GET)
     public String LastTemperature(final ModelMap pModel) {
        ArrayList<Wendu> tempList = serviceTemp.getLastTemperatures();
        pModel.addAttribute("tempList", tempList);
        return "recherche";
    }

    @RequestMapping(value = "/station/{id}", method = RequestMethod.GET)
    public String StationTempetature(@PathVariable int id ,final ModelMap pModel) {

        StationForm formData = new StationForm("","");

        ArrayList<Wendu> tempList = serviceTemp.getTemperatures(id);
        Station station = serviceStation.getStaionById(id);
        pModel.addAttribute("tempList", tempList);
        pModel.addAttribute("station", station.getLabel());
        pModel.addAttribute("zone", station.getArea().getLabel());
        pModel.addAttribute("route", station.getArea().getRoad());
        pModel.addAttribute("id", id);
        pModel.addAttribute("StationForm",formData);
        return "station";
    }

    @RequestMapping(value = "/station/{id}", method = RequestMethod.POST)
    public String StationTempetatureFilterd(@PathVariable int id ,@ModelAttribute("StationForm") StationForm formData,final ModelMap pModel) {



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

        Date dateBegin = null;
        Date dateEnd = null;

        try {
            dateBegin = sdf.parse(formData.getBegin());
            dateEnd = sdf.parse(formData.getEnd());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ArrayList<Wendu> tempList = serviceTemp.getFilteredTemperatures(dateBegin, dateEnd, id);
        Station station = serviceStation.getStaionById(id);
        pModel.addAttribute("tempList", tempList);
        pModel.addAttribute("station", station.getLabel());
        pModel.addAttribute("zone", station.getArea().getLabel());
        pModel.addAttribute("route", station.getArea().getRoad());
        pModel.addAttribute("id", id);
        pModel.addAttribute("StationForm",formData);

        return "station";
    }
}
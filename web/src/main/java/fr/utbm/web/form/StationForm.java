package fr.utbm.web.form;

import com.sun.istack.internal.NotNull;


/**
 * Created by Yohann on 22/11/2014.
 * Classe utilisée pour echanger avec le formulaire de la page station
 */


public class StationForm {
    @NotNull
    private String begin; //début de la période de filtrage
    @NotNull
    private String end; //fin de la période de filtrage

    // constructeurs
    public StationForm() {
    }

    public StationForm(String begin, String end) {
        this.begin = begin;
        this.end = end;
    }

    //getters et setters
    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}

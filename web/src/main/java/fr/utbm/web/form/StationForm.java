package fr.utbm.web.form;

import com.sun.istack.internal.NotNull;

import java.util.Date;

/**
 * Created by Yohann on 22/11/2014.
 */
public class StationForm {
    @NotNull
    private String begin;
    @NotNull
    private String end;

    public StationForm() {
    }

    public StationForm(String begin, String end) {
        this.begin = begin;
        this.end = end;
    }

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

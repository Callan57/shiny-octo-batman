package fr.utbm.core.model;

import java.util.Date;

/**
 * Created by Julien on 21/11/14.
 * Classe correspondant au modèle température envoyé à la vue
 */
public class Wendu
{
    private int temperatureId;//idendifiant de la température
    private float temperatureValue;//valeur de la température
    private Date temperatureDate;//date de relevé de la température
    private int sensorId;//identifiant de la sonde
    private String sensorLabel;//nom de la sonde
    private int stationId;//identifiant de la station
    private String stationLabel;//nom de la station
    private int areaId;//identifiant de la zone
    private String areaLabel;//nom de la zone
    private String areaRoad;//nom de la route

    //constructeur
    public Wendu(int temperatureId, float temperatureValue, Date temperatureDate, int sensorId, String sensorLabel, int stationId, String stationLabel, int areaId, String areaLabel, String areaRoad) {
        this.temperatureId = temperatureId;
        this.temperatureValue = temperatureValue;
        this.temperatureDate = temperatureDate;
        this.sensorId = sensorId;
        this.sensorLabel = sensorLabel;
        this.stationId = stationId;
        this.stationLabel = stationLabel;
        this.areaId = areaId;
        this.areaLabel = areaLabel;
        this.areaRoad = areaRoad;
    }

    //getters et setters
    public int getTemperatureId() {
        return temperatureId;
    }

    public void setTemperatureId(int temperatureId) {
        this.temperatureId = temperatureId;
    }

    public float getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(float temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    public Date getTemperatureDate() {
        return temperatureDate;
    }

    public void setTemperatureDate(Date temperatureDate) {
        this.temperatureDate = temperatureDate;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorLabel() {
        return sensorLabel;
    }

    public void setSensorLabel(String sensorLabel) {
        this.sensorLabel = sensorLabel;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationLabel() {
        return stationLabel;
    }

    public void setStationLabel(String stationLabel) {
        this.stationLabel = stationLabel;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaLabel() {
        return areaLabel;
    }

    public void setAreaLabel(String areaLabel) {
        this.areaLabel = areaLabel;
    }

    public String getAreaRoad() {
        return areaRoad;
    }

    public void setAreaRoad(String areaRoad) {
        this.areaRoad = areaRoad;
    }
}

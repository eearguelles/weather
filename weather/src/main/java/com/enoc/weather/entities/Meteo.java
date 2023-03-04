/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enoc.weather.entities;


/**
 *
 * @author earguelles
 */
public class Meteo {
    
    private Double latitude;
    private Double longitude;
    private Double generationtime_ms;
    private Double utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private Double elevation;
    private Currentweather current_weather;

    public Meteo() {
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getGenerationtime_ms() {
        return generationtime_ms;
    }

    public Double getUtc_offset_seconds() {
        return utc_offset_seconds;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getTimezone_abbreviation() {
        return timezone_abbreviation;
    }

    public Double getElevation() {
        return elevation;
    }

    public Currentweather getCurrent_weather() {
        return current_weather;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setGenerationtime_ms(Double generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }

    public void setUtc_offset_seconds(Double utc_offset_seconds) {
        this.utc_offset_seconds = utc_offset_seconds;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setTimezone_abbreviation(String timezone_abbreviation) {
        this.timezone_abbreviation = timezone_abbreviation;
    }

    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    public void setCurrent_weather(Currentweather current_weather) {
        this.current_weather = current_weather;
    }
}

class Currentweather {

    private Double temperature;
    private Double windspeed;
    private Double winddirection;
    private Long weathercode;
    private String time;

    public Currentweather() {
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getWindspeed() {
        return windspeed;
    }

    public Double getWinddirection() {
        return winddirection;
    }

    public Long getWeathercode() {
        return weathercode;
    }

    public String getTime() {
        return time;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setWindspeed(Double windspeed) {
        this.windspeed = windspeed;
    }

    public void setWinddirection(Double winddirection) {
        this.winddirection = winddirection;
    }

    public void setWeathercode(Long weathercode) {
        this.weathercode = weathercode;
    }

    public void setTime(String time) {
        this.time = time;
    }

}

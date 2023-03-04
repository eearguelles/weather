/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enoc.weather.entities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author earguelles Entity Class to map detail table
 */
@Entity
@Data
@Table(name = "detail")
public class Detail {

    @Id   //  @id and @generatedvalue helps to identifie the id from the record
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Double temperature;
    private Double windspeed;
    private Double winddirection;
    private Long weathercode;
    private Date time;
    private Date localtime;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "masterid", referencedColumnName = "id")
    private Master master;
    
    public Detail() {
    }

    public Detail(Meteo m) throws ParseException {
        this.temperature = m.getCurrent_weather().getTemperature();
        this.windspeed = m.getCurrent_weather().getWindspeed();
        this.winddirection = m.getCurrent_weather().getWinddirection();
        this.weathercode = m.getCurrent_weather().getWeathercode();
        this.time = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(m.getCurrent_weather().getTime());
        this.localtime = new Date();
    }

}

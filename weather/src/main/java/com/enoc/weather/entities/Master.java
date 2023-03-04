/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enoc.weather.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * NOTAS: Esta clase al ser una entidad se deben de agregar ciertas anotaciones
 * para ser identificadas como tal por JPA
 *
 * @author earguelles
 */
@Entity
@Data
@Table(name = "master")
public class Master {

    @Id   //  @id and @generatedvalue helps to identifie the id from the record
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Double latitude;
    private Double longitude;
    private Double generationtime_ms;
    private Double utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private Double elevation;
    @OneToOne(mappedBy = "master")
    private Detail current_weather;

    public Master() {

    }

    public Master(Meteo m) {
        this.latitude = m.getLatitude();
        this.longitude = m.getLongitude();
        this.generationtime_ms = m.getGenerationtime_ms();
        this.utc_offset_seconds = m.getUtc_offset_seconds();
        this.timezone = m.getTimezone();
        this.timezone_abbreviation = m.getTimezone();
        this.elevation = m.getElevation();
    }

}

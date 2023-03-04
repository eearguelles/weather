/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enoc.weather.controller;

import com.enoc.weather.entities.Detail;

import java.util.List;

/**
 *
 * @author earguelles
 * Aux class to serialize the List of details weathers to XML file
 */
public class DetailList {
      private List<Detail> list;

    public DetailList( List<Detail> details){
        list = details;
    }   
}

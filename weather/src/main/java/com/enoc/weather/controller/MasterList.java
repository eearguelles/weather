/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enoc.weather.controller;

import com.enoc.weather.entities.Master;
import java.util.List;

/**
 *
 * @author earguelles
 * Aux class to serialize the List of master weathers to XML file
 */
public class MasterList {
      private List<Master> list;

    public MasterList( List<Master> masters){
        list = masters;
    }   
}

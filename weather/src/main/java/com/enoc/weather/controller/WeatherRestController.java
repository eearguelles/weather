/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.enoc.weather.controller;

import com.enoc.weather.entities.Detail;
import com.enoc.weather.entities.Master;
import com.enoc.weather.entities.Meteo;
import com.enoc.weather.repository.DetailRepository;
import com.enoc.weather.repository.MasterRepository;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.io.Resource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.hibernate.collection.internal.PersistentBag;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

/**
 *
 * @author earguelles
 *
 */
@Service
@RestController
@RequestMapping("/weather")
public class WeatherRestController {

    @Autowired
    MasterRepository masterRepository;

    @Autowired
    DetailRepository detailRepository;

    @GetMapping()
    public List<Master> findAll() {
        return masterRepository.findAll();
    }

    @GetMapping("/{latitude}/{longitude}")
    public ResponseEntity<?> get(@PathVariable String latitude, @PathVariable String longitude) throws ParseException, ParserConfigurationException, TransformerException, SAXException, IOException {
        Meteo meteo = new Meteo();
        String xml = new String();        
        try {
            Map<String, String> map = new HashMap<>();
            map.put("lat", latitude);
            map.put("lon", longitude);
            String uri = new String("https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}&current_weather=true");
            RestTemplate restTemplate = new RestTemplate();
            try {
                meteo = restTemplate.getForObject(uri, Meteo.class, map);
            } catch (RestClientException e) {
                return new ResponseEntity<>(new String("Latitude and loingitude with wrong format, please send a float foprmat. For Example: /52.52/18.00"), HttpStatus.NOT_ACCEPTABLE);
            }
            Master master = new Master(meteo);
            Detail detail = new Detail(meteo);

            masterRepository.save(master);
            detail.setMaster(master);
            detailRepository.save(detail);
            XStream xstream = new XStream();
            xstream.alias("master", Master.class);
            xstream.alias("masters", MasterList.class);            
            xstream.addDefaultImplementation(ArrayList.class, PersistentBag.class);
            xstream.alias("java.util.ArrayList", PersistentBag.class);
            xstream.addImplicitCollection(MasterList.class, "list");
            
            List<Master> lm = masterRepository.findAll();
            MasterList list = new MasterList(lm);
            xml = xstream.toXML(list);
          
            Resource resource = new ByteArrayResource(xml.getBytes());            
           
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new String("weather.xml") + "\"")
                    .body(resource);            
        } catch (RestClientException e) {
            return new ResponseEntity<>(new String("Latitude and loingitude with wrong format, please send a float foprmat. For Example: /52.52/18.00"), HttpStatus.NOT_ACCEPTABLE);
        }
    }

}

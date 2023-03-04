/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.enoc.weather.repository;

import com.enoc.weather.entities.Master;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author earguelles
 */
public interface MasterRepository extends JpaRepository<Master, Long> {
    
}

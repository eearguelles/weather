package com.enoc.weather;

import com.enoc.weather.controller.WeatherRestController;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeatherApplicationTests {

    @Autowired
    private WeatherRestController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}

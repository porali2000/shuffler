package com.init;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by Porali_S on 12/15/2016.
 */

@SpringBootConfiguration
@ComponentScan(basePackages = {"com.*"})
@ActiveProfiles(profiles = {"simple"})
public class App {
}

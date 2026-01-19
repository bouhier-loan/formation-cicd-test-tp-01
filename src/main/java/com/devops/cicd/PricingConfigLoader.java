package com.devops.cicd;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PricingConfigLoader {

    public PricingConfig load() {
        Properties prop = new Properties();

        // On charge le fichier depuis le classpath
        try (InputStream input = PricingConfigLoader.class.getClassLoader().getResourceAsStream("app.properties")) {

            if (input == null) {
                System.out.println("Impossible de trouver le fichier app.properties");
                return null;
            }

            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new PricingConfig(Double.parseDouble(required(prop, "vatRate")),
                (Double.parseDouble(required(prop, "freeShippingThreshold"))));
    }

    private String required(Properties props, String key) {
        return props.getProperty(key);
    }
}

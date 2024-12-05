package org.clusterbr.ruples.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Implements a Singleton pattern to read application.properties file.
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/PropertiesProvider.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
*/
public class PropertiesProvider {
    
    private static final Logger logger = LoggerFactory.getLogger(PropertiesProvider.class);

    private static final String APPLICATION_PROPERTIES = "application.properties";

    private static PropertiesProvider instance;

    private Properties properties;

    private PropertiesProvider() {
        properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {

        String msg;
        String methodName = "PropertiesProvider:loadProperties";
        
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES)) {

            if (input == null) {
                msg = String.format("[Error] (%s) Unable to find %s file.", methodName, APPLICATION_PROPERTIES);
                logger.error(msg);
                return;
            }
            properties.load(input);
            
            msg = String.format("[Info] (%s) Properties file <%s> loaded successfully.", methodName, APPLICATION_PROPERTIES);
            logger.info(msg);

        } catch (IOException ex) {
            ex.printStackTrace();
            msg = String.format("[Exception] (%s)", methodName);
            logger.error(msg, ex);
        }
    }

    public static PropertiesProvider getInstance() {
        if (instance == null) {
            instance = new PropertiesProvider();
        }
        return instance;
    }

    /**
     * Get property value by key
     * @param key
     * @return String instace
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

package io.github.abritoh.ruples.util;

import java.io.StringWriter;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 
 * Uses fasterxml.jackson to serialize objects.
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/JacksonSerializer.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 *  
 **/
public class JacksonSerializer {

    private static final Logger logger = LoggerFactory.getLogger(JacksonSerializer.class);

    public static String serializeToXml(Object object) {
        String xml = "<data>NULL</data>";

        try {

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);
            xml = xmlMapper.writeValueAsString(object);
            
        } catch(Exception ex) {
            ex.printStackTrace();
            logger.error("[Exception] (JacksonSerializer::serializeToXml)", ex);
        }

        return xml;
    }

}
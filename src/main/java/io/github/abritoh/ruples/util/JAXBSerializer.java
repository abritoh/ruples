package io.github.abritoh.ruples.util;

import java.io.StringWriter;

import io.github.abritoh.ruples.abztract.JAXBSerializable;
import org.glassfish.jaxb.runtime.marshaller.NamespacePrefixMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

/**
 * 
 * Uses JABX to serialize objects.
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/JAXBSerializer.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 *  
 **/
public class JAXBSerializer {

    private static final Logger logger = LoggerFactory.getLogger(JAXBSerializer.class);


    public static String serializeToXml(JAXBSerializable jaxbSerializable) {
        
        return serializeToXml(jaxbSerializable, jaxbSerializable.getJAXBContext());
        
    }    

    public static String serializeToXml(Object jaxbSerializable, JAXBContext context) {
        String xml = "<data>NULL</data>";

        try(StringWriter writer = new StringWriter()) {

            if( context == null) {                
                context = JAXBContext.newInstance(jaxbSerializable.getClass());
            }

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);    
            marshaller.marshal(jaxbSerializable, writer);
            
            xml = writer.toString();

            xml = xml.replace(" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"", "")
                    .replace(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"", "")
                    ;
            
        } catch(Exception ex) {
            ex.printStackTrace();
            logger.error("[Exception] (JAXBSerializer::serializeToXml)", ex);
        }

        return xml;
    }


}
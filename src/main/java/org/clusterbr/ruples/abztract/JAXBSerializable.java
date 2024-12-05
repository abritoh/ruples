package org.clusterbr.ruples.abztract;

import jakarta.xml.bind.JAXBContext;

/**
 * Implementers of this interface are required to implement tha getJAXBContext() method  
 * to ensure that this class serializes correctly through JAXB.  
 * 
 * The getJAXBContext() must initialize the JAXB context porperly.  
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/JAXBSerializable.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR* 
 */
public interface JAXBSerializable {
    /**
     * Provides the JAXBContext for serializing and deserializing this class.
     * Implementers must properly initialize the context for their specific use case.
     *
     * @return an instance of JAXBContext or null if JAXBContext initialization fails
     */
    JAXBContext getJAXBContext();
}

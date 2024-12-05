package org.clusterbr.ruples.util;

import com.google.gson.Gson;

/**
 * Uses Gson to serialize objects.
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/GsonSerializer.png" alt="UML Diagram"></div>
 * * 
 * @since 2024-1118
 * @author ClusterBR
 */
public class GsonSerializer {    

    /**
     * Serializes the input object into a JSON string using the GSON serializer.
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }    
}

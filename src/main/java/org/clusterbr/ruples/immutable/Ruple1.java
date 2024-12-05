package org.clusterbr.ruples.immutable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.clusterbr.ruples.mutable.*;

/**
 * Represents an immutable Ruple structure that can hold a fixed number of related values. Each Ruple is designed to 
 * store values in a specific order, with each value being accessible through a dedicated getter method. Once created, 
 * the values inside a Ruple cannot be changed, ensuring data integrity and providing a predictable, thread-safe structure.
 *
 * Typical use cases include:
 * - Storing fixed data, such as configuration settings, that shouldn't change during the lifecycle of your application.
 * - Returning multiple values from a method where the values need to remain constant throughout the execution.
 * - Grouping related constants or parameters that should remain unchanged, like API response data or predefined options.
 *
 * The immutability of the Ruple makes it ideal for scenarios where you want to ensure that data cannot be modified by accident, 
 * providing a stable and safe container for critical values.
 * 
 * Example:
 * {@code
 * Ruple2<String, Integer> myRuple = Ruple2.of("If Tuples were immutables, they would be Ruples!", 911);
 * System.out.println(myRuple.first());  // Prints "If Tuples were immutables, they would be Ruples!"
 * }
 *
 * Ruples are a great choice when you want to make sure your data stays constant and consistent, 
 * offering a simple way to keep things reliable and stable in your Application.
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/Ruple1.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 */
public record Ruple1<T1>(T1 first) implements Serializable {

    /** 
     * 
     * Create a Ruple of the next dimension based on current instance.
     * 
     * @param second
     * @return an immutable type-safe Ruple with 2-values.
     */
    public <T2> 
        Ruple2<T1, T2> 
        createNext(T2 second) {
        return new Ruple2<>(this.first, second);
    }  
    
    /**
     * Converts the current Ruple to a Map.
     * <p>The Map will contain keys with names like "first", "second", "third", etc., 
     *  corresponding to the values in the Ruple.</p>
     * <p>For example, a Ruple with elements [first, second, third]
     * will be converted to a Map with entries:
     * <code>{"first": first(), "second": second(), "third": third(), ...}</code></p>
     * 
     * @return a new instance of Map |String, Object| where each key corresponds to a Ruple field.
     */
    public Map<String, Object> 
        toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("first", first());
        return map;
    }       
  
    /** 
     * 
     * Factory method to create a Ruple
     * 
     * @param first
     * @return an immutable Ruple with 1-value.
     */
    public static <T1> 
        Ruple1<T1> 
        of(T1 first) {
        return new Ruple1<>(first);
    }

    /** 
     * 
     * Convert Ruple to Tuple
     * 
     * @param record
     * @return a mutable Tuple with 1-value.
     */
    public static <T1> 
        Tuple1<T1> 
        fromRecord(Ruple1<T1> record) {
        return new Tuple1<>(record.first());
    }

    /** 
     * 
     * Convert Tuple to Ruple
     * 
     * @param tuple
     * @return an immutable Ruple with 1-value.
     */
    public static <T1> 
        Ruple1<T1> 
        toRecord(Tuple1<T1> tuple) {
        return new Ruple1<>(tuple.getV1());
    }

}

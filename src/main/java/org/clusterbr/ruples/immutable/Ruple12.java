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
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/Ruple12.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 */
public record Ruple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>
    (T1 first, T2 second, T3 third, T4 fourth, T5 fifth, T6 sixth, T7 seventh, T8 eighth, T9 ninth, T10 tenth, T11 eleventh, T12 twelfth) 
        implements Serializable {  

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
        map.put("second", second());
        map.put("third", third());
        map.put("fourth", fourth());
        map.put("fifth", fifth());
        map.put("sixth", sixth());
        map.put("seventh", seventh());
        map.put("eighth", eighth());
        map.put("ninth", ninth());
        map.put("tenth", tenth());
        map.put("eleventh", eleventh());
        map.put("twelfth", twelfth());
     
        return map;
    } 
    
    /** 
     * 
     * Factory method to create a Ruple
     * 
     * @param first
     * @param second
     * @param third
     * @param fourth
     * @param fifth
     * @param sixth
     * @param seventh
     * @param eighth
     * @param ninth
     * @param tenth
     * @param eleventh
     * @param twelfth
     * @return an immutable Ruple with 12-values
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        Ruple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        of(T1 first, T2 second, T3 third, T4 fourth, T5 fifth, T6 sixth, T7 seventh, T8 eighth, T9 ninth, T10 tenth, T11 eleventh, T12 twelfth) {
        return new Ruple12<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth);
    }      

    /** 
     * 
     * Convert Ruple to Tuple
     * 
     * @param record
     * @return a mutable Tuple with 12-values
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        fromRecord(Ruple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> record) {
        return new Tuple12<>(record.first(), record.second(), record.third(), record.fourth(), record.fifth(), record.sixth(), record.seventh(), record.eighth(), record.ninth(), record.tenth(), record.eleventh(), record.twelfth());
    }

    /** 
     * 
     * Convert Tuple to Ruple
     * 
     * @param tuple
     * @return an immutable Ruple with 12-values
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        Ruple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        toRecord(Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> tuple) {
        return new Ruple12<>(tuple.getV1(), tuple.getV2(), tuple.getV3(), tuple.getV4(), tuple.getV5(), tuple.getV6(), tuple.getV7(), tuple.getV8(), tuple.getV9(), tuple.getV10(), tuple.getV11(), tuple.getV12());
    }

}

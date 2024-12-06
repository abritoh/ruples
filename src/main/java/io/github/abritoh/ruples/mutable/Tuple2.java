package io.github.abritoh.ruples.mutable;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import io.github.abritoh.ruples.immutable.*;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Represents a mutable Tuple structure that can hold a fixed number of related values. The Tuple is a lightweight 
 * container that allows you to group multiple values together, making it perfect for when you need to pass around 
 * multiple values as a single entity. This class supports values of any type and provides an easy way to store and 
 * retrieve them. 
 *
 * Typical use cases include:
 * - Storing temporary data like user inputs or calculations that may change during runtime.
 * - Grouping multiple related properties together, such as when working with key-value pairs, 
 *   records, or multidimensional arrays.
 * - Passing data between different parts of your application without creating custom classes.
 *
 * The mutable nature of the Tuple allows for flexibility in scenarios where the stored values need to change over time. 
 * The Tuple classes provide methods for accessing and modifying values, making them ideal for temporary or mutable data.
 * 
 * Example:
 * {@code
 * Tuple3<String, Integer, Boolean> myTuple = new Tuple3<>("Java can be as funny as Python but Strict as C++", 3.1416, true);
 * myTuple.setV1("Null pointer exception isn't optional, isn't it?");
 * System.out.println(myTuple.getV2());  // Prints "Null pointer exception isn't optional, isn't it?"
 * }
 * 
 * Tuples are simple, efficient, and powerful – ideal for organizing dynamic data without the overhead of custom-structures.
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/Tuple2.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 */
@XmlRootElement(name = "Tuple2")
public class Tuple2<T1, T2> implements Serializable {
    private T1 v1;
    private T2 v2;

    /**
     * Default constructor, sets initial values to null.
     */    
    public Tuple2() {
        this.v1 = null;
        this.v2 = null;
    }

    /**
     * 
     * @param v1
     * @param v2
     */
    public Tuple2(T1 v1, T2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    /** 
     * Converts the instance into its string representation.
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Tuple2(v1=%s, v2=%s)", v1, v2);
    }

    /** 
     * Compares input Object "o" with this Tuple instance.
     * @param o
     * @return boolean
     */    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.equals(v1, tuple2.v1) && Objects.equals(v2, tuple2.v2);
    }

    /** 
     * Gets the instance hash-code based on instance-values.
     * The hash of each value contributes to generate the total hash.
     * @return int
     */    
    @Override
    public int hashCode() {
        return Objects.hash(v1, v2);
    }

    
    /** 
     * Create a Tuple of the next dimension based on the current instance by adding another typed value.
     * @param v3
     * @return a new instance of Tuple
     */
    public <T3> 
        Tuple3<T1, T2, T3> 
        createNext(T3 v3) {
        return new Tuple3<>(this.v1, this.v2, v3);
    }  

    /** 
     * Convert current Tuple to a Map.
     * <p>The Map will contain keys with names like: "v1", "v2", "v3",...
     * corresponding to the values in the Tuple.</p>
     * <p>For example, a Tuple with elements (v1, v2, v3)
     * will be converted to a Map with entries:
     * <code>{"v1":v1, "v2":v2, "v3":v3, ...}</code></p>
     * @return a new instance of Map |String, Object| where each key corresponds to a Tuple field.
     */
    public Map<String, Object> 
        toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("v1", v1);
        map.put("v2", v2);
        return map;
    }      
    
    /** 
     * Factory method to create a Tuple
     * @param v1
     * @param v2
     * @return a new instance of Tuple
     */
    public static <T1, T2> 
        Tuple2<T1, T2> 
        of(T1 v1, T2 v2) {
        return new Tuple2<>(v1, v2);
    }

    
    /** 
     * Creates a new instance of a Tuple based on the provided Ruple.
     * @param record
     * @return a new instance of Tuple
     */
    public static <T1, T2> 
        Tuple2<T1, T2> 
        fromRecord(Ruple2<T1, T2> record) {
        return new Tuple2<>(record.first(), record.second());
    }

    
    /** 
     * Creates a new instance of a Ruple using the values from this Tuple instance.
     * @param tuple
     * @return a new instance of Ruple
     */
    public static <T1, T2> 
        Ruple2<T1, T2> 
        toRecord(Tuple2<T1, T2> tuple) {
        return new Ruple2<>(tuple.getV1(), tuple.getV2());
    }

    
    /** 
     * Gets the value-1
     * @return T1
     */
    @XmlElement(name = "value1")
    public T1 getV1() {
        return v1;
    }

    
    /** 
     * Sets the value-1
     * @param v1
     */
    public void setV1(T1 v1) {
        this.v1 = v1;
    }

    
    /** 
     * Gets the value-2
     * @return T2
     */
    @XmlElement(name = "value2")
    public T2 getV2() {
        return v2;
    }

    
    /** 
     * Sets the value-2
     * @param v2
     */
    public void setV2(T2 v2) {
        this.v2 = v2;
    }    

}

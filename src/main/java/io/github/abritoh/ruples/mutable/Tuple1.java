package io.github.abritoh.ruples.mutable;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import io.github.abritoh.ruples.immutable.*;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents a mutable Tuple structure that can hold a fixed number of related values. The Tuple is a lightweight 
 * container that allows you to group multiple values together, making it perfect for when you need to pass around 
 * multiple values as a single entity. This class supports values of any type and provides an easy way to store and 
 * retrieve them. 
 *
 * Typical use cases include:
 * - Storing temporary data like user inputs or calculations that may change during runtime.
 * - Grouping multiple related properties together, such as when working with key-value pairs, records, or multidimensional arrays.
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
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/Tuple1.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 */
@XmlRootElement(name = "Tuple1")
public class Tuple1<T1> implements Serializable {
    private T1 v1;

    /**
     * Default constructor, sets initial values to null.
     */
    public Tuple1() {
        this.v1 = null;
    }

    /**
     * Parametrized constructor.
     * @param v1 - value
     */
    public Tuple1(T1 v1) {
        this.v1 = v1;
    }
    
    /** 
     * Converts the instance into its string representation.
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Tuple1(v1=%s)", v1);
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
        Tuple1<?> tuple = (Tuple1<?>) o;
        return Objects.equals(v1, tuple.v1);
    }
    
    /** 
     * Gets the instance hash-code based on instance-values.
     * The hash of each value contributes to generate the total hash.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(v1);
    }
    
    /** 
     * Create a Tuple of the next dimension based on the current instance by adding another typed value.
     * @param v2 - value
     * @return a new instance of Tuple
     */
    public <T2> 
        Tuple2<T1, T2> 
        createNext(T2 v2) {
        return new Tuple2<>(this.v1, v2);
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
        return map;
    }  
    
    /** 
     * Factory method to create a Tuple
     * @param v1
     * @return a new instance of Tuple
     */
    public static <T1> 
        Tuple1<T1> 
        of(T1 v1) {
        return new Tuple1<>(v1);
    }
    
    /** 
     * Creates a new instance of a Tuple based on the provided Ruple.
     * @param record
     * @return a new instance of Tuple
     */
    public static <T1> 
        Tuple1<T1> 
        fromRecord(Ruple1<T1> record) {
        return new Tuple1<>(record.first());
    }
    
    /** 
     * Creates a new instance of a Ruple using the values from this Tuple instance.
     * @param tuple
     * @return a new instance of Ruple
     */
    public static <T1> 
        Ruple1<T1> 
        toRecord(Tuple1<T1> tuple) {
        return new Ruple1<>(tuple.getV1());
    }
    
    /** 
     * Gets the value-1
     * @return the value-1 of the Tuple instance
     */
    @XmlElement(name = "value1")
    public T1 getV1() {
        return v1;
    }
    
    /** 
     * Sets the value-1
     * @param v1 - the value-1 to set into the Tuple
     */
    public void setV1(T1 v1) {
        this.v1 = v1;
    }

}

package org.clusterbr.ruples.mutable;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import org.clusterbr.ruples.immutable.*;

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
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/Tuple4.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 */
@XmlRootElement(name = "Tuple4")
public class Tuple4<T1, T2, T3, T4> implements Serializable {
    private T1 v1;
    private T2 v2;
    private T3 v3;
    private T4 v4; 

    /**
     * Default constructor, sets initial values to null.
     */      
    public Tuple4() {
        this.v1 = null;
        this.v2 = null;
        this.v3 = null;
        this.v4 = null;
    }

    /**
     * Parametrized constructor.
     * @param v1
     * @param v2
     * @param v3
     * @param v4
     */
    public Tuple4(T1 v1, T2 v2, T3 v3, T4 v4) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }    

    /** 
     * Converts the instance into its string representation.
     * @return String
     */    
    @Override
    public String toString() {
        return String.format("Tuple4(v1=%s, v2=%s, v3=%s, v4=%s)", v1, v2, v3, v4);
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
        Tuple4<?, ?, ?, ?> tuple4 = (Tuple4<?, ?, ?, ?>) o; 
        return Objects.equals(v1, tuple4.v1) && Objects.equals(v2, tuple4.v2) && Objects.equals(v3, tuple4.v3) && Objects.equals(v4, tuple4.v4);
    }

    /** 
     * Gets the instance hash-code based on instance-values.
     * The hash of each value contributes to generate the total hash.
     * @return int
     */    
    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, v3, v4);
    }

    
    /** 
     * Create a Tuple of the next dimension based on the current instance by adding another typed value.
     * @param v5
     * @return a new instance of Tuple
     */
    public <T5> 
        Tuple5<T1, T2, T3, T4, T5> 
        createNext(T5 v5) {
        return new Tuple5<>(this.v1, this.v2, this.v3, this.v4, v5);
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
        map.put("v3", v3);
        map.put("v4", v4);
        return map;
    }
    
    /** 
     * Factory method to create a Tuple
     * @param v1
     * @param v2
     * @param v3
     * @param v4
     * @return a new instance of Tuple
     */
    public static <T1, T2, T3, T4> 
        Tuple4<T1, T2, T3, T4> 
        of(T1 v1, T2 v2, T3 v3, T4 v4) {
        return new Tuple4<>(v1, v2, v3, v4);
    }    

    
    /** 
     * Creates a new instance of a Tuple based on the provided Ruple.
     * @param record
     * @return a new instance of Tuple
     */
    public static <T1, T2, T3, T4> 
        Tuple4<T1, T2, T3, T4> 
        fromRecord(Ruple4<T1, T2, T3, T4> record) {
        return new Tuple4<>(record.first(), record.second(), record.third(), record.fourth());
    }

    
    /** 
     * Creates a new instance of a Ruple using the values from this Tuple instance.
     * @param tuple
     * @return a new instance of Ruple
     */
    public static <T1, T2, T3, T4> 
        Ruple4<T1, T2, T3, T4> 
        toRecord(Tuple4<T1, T2, T3, T4> tuple) {
        return new Ruple4<>(tuple.getV1(), tuple.getV2(), tuple.getV3(), tuple.getV4());
    }    

    
    /** 
     * Gets the corresponding value-n
     * @return T1
     */
    @XmlElement(name = "value1")
    public T1 getV1() {
        return v1;
    }

    
    /** 
     * Sets the corresponding value-n
     * @param v1
     */
    public void setV1(T1 v1) {
        this.v1 = v1;
    }

    
    /** 
     * Gets the corresponding value-n
     * @return T2
     */
    @XmlElement(name = "value2")
    public T2 getV2() {
        return v2;
    }

    
    /** 
     * Sets the corresponding value-n
     * @param v2
     */
    public void setV2(T2 v2) {
        this.v2 = v2;
    }

    
    /** 
     * Gets the corresponding value-n
     * @return T3
     */
    @XmlElement(name = "value3")
    public T3 getV3() {
        return v3;
    }

    
    /** 
     * Sets the corresponding value-n
     * @param v3
     */
    public void setV3(T3 v3) {
        this.v3 = v3;
    }

    
    /** 
     * Gets the corresponding value-n
     * @return T4
     */
    @XmlElement(name = "value4")
    public T4 getV4() {
        return v4;
    }

    
    /** 
     * Sets the corresponding value-n
     * @param v4
     */
    public void setV4(T4 v4) {
        this.v4 = v4;
    }

    

}

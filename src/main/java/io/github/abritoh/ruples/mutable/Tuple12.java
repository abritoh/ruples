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
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/Tuple12.png" alt="UML Diagram"></div>
 * 
* @since 2024-1118
 * @author ClusterBR
 */
@XmlRootElement(name = "Tuple12")
public class Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> implements Serializable {
    private T1 v1;
    private T2 v2;
    private T3 v3;
    private T4 v4;
    private T5 v5;
    private T6 v6;
    private T7 v7;
    private T8 v8;
    private T9 v9;
    private T10 v10;
    private T11 v11;
    private T12 v12;

    /**
     * Default constructor, sets initial values to null.
     */      
    public Tuple12() {
        this.v1 = null;
        this.v2 = null;
        this.v3 = null;
        this.v4 = null;
        this.v5 = null;
        this.v6 = null;
        this.v7 = null;
        this.v8 = null;
        this.v9 = null;
        this.v10 = null;
        this.v11 = null;
        this.v12 = null;
    }

    /**
     * Parametrized constructor.
     * @param v1
     * @param v2
     * @param v3
     * @param v4
     * @param v5
     * @param v6
     * @param v7
     * @param v8
     * @param v9
     * @param v10
     * @param v11
     * @param v12
     */
    public Tuple12(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11, T12 v12) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
        this.v5 = v5;
        this.v6 = v6;
        this.v7 = v7;
        this.v8 = v8;
        this.v9 = v9;
        this.v10 = v10;
        this.v11 = v11;
        this.v12 = v12;
    }

    /** 
     * Converts the instance into its string representation.
     * @return String
     */     
    @Override
    public String toString() {
        return String.format("Tuple12(v1=%s, v2=%s, v3=%s, v4=%s, v5=%s, v6=%s, v7=%s, v8=%s, v9=%s, v10=%s, v11=%s, v12=%s)", v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12);
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
        Tuple12<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> tuple12 = (Tuple12<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>) o;
        return Objects.equals(v1, tuple12.v1) && Objects.equals(v2, tuple12.v2) && 
               Objects.equals(v3, tuple12.v3) && Objects.equals(v4, tuple12.v4) && 
               Objects.equals(v5, tuple12.v5) && Objects.equals(v6, tuple12.v6) && 
               Objects.equals(v7, tuple12.v7) && Objects.equals(v8, tuple12.v8) && 
               Objects.equals(v9, tuple12.v9) && Objects.equals(v10, tuple12.v10) && 
               Objects.equals(v11, tuple12.v11) && Objects.equals(v12, tuple12.v12);
    }

    /** 
     * Gets the instance hash-code based on instance-values.
     * The hash of each value contributes to generate the total hash.
     * @return int
     */    
    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12);
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
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("v1", v1);
        map.put("v2", v2);
        map.put("v3", v3);
        map.put("v4", v4);
        map.put("v5", v5);
        map.put("v6", v6);
        map.put("v7", v7);
        map.put("v8", v8);
        map.put("v9", v9);
        map.put("v10", v10);
        map.put("v11", v11);
        return map;
    }    
    
    /** 
     * Factory method to create a Tuple
     * @param v1
     * @param v2
     * @param v3
     * @param v4
     * @param v5
     * @param v6
     * @param v7
     * @param v8
     * @param v9
     * @param v10
     * @param v11
     * @param v12
     * @return a new instance of Tuple
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        of(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11, T12 v12) {        
        return new Tuple12<>(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12);
    } 
    
    /** 
     * Creates a new instance of a Tuple based on the provided Ruple.
     * @param record
     * @return a new instance of Tuple
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        fromRecord(Ruple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> record) {
        return new Tuple12<>(record.first(), record.second(), record.third(), record.fourth(), record.fifth(), record.sixth(), record.seventh(), record.eighth(), record.ninth(), record.tenth(), record.eleventh(), record.twelfth());
    }
    
    /** 
     * Creates a new instance of a Ruple using the values from this Tuple instance.
     * @param tuple
     * @return a new instance of Ruple
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        Ruple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> 
        toRecord(Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> tuple) {
        return new Ruple12<>(tuple.getV1(), tuple.getV2(), tuple.getV3(), tuple.getV4(), tuple.getV5(), tuple.getV6(), tuple.getV7(), tuple.getV8(), tuple.getV9(), tuple.getV10(), tuple.getV11(), tuple.getV12());
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

    
    /** 
     * Gets the corresponding value-n
     * @return T5
     */
    @XmlElement(name = "value5")
    public T5 getV5() {
        return v5;
    }

    
    /** 
     * Sets the corresponding value-n
     * @param v5
     */
    public void setV5(T5 v5) {
        this.v5 = v5;
    }

    
    /** 
     * Gets the corresponding value-n
     * @return T6
     */
    @XmlElement(name = "value6")
    public T6 getV6() {
        return v6;
    }

    
    /** 
     * Sets the corresponding value-n
     * @param v6
     */
    public void setV6(T6 v6) {
        this.v6 = v6;
    }

    
    /** 
     * Gets the corresponding value-n
     * @return T7
     */
    @XmlElement(name = "value7")
    public T7 getV7() {
        return v7;
    }

    
    /** 
     * Sets the corresponding value-n
     * @param v7
     */
    public void setV7(T7 v7) {
        this.v7 = v7;
    }

    
    /** 
     * Gets the corresponding value-n
     * @return T8
     */
    @XmlElement(name = "value8")
    public T8 getV8() {
        return v8;
    }

    
    /** 
     * Sets the corresponding value-n
     * @param v8
     */
    public void setV8(T8 v8) {
        this.v8 = v8;
    }

    
    /** 
     * Gets the corresponding value-n
     * @return T9
     */
    @XmlElement(name = "value9")
    public T9 getV9() {
        return v9;
    }

    
    /** 
     * Sets the corresponding value-n
     * @param v9
     */
    public void setV9(T9 v9) {
        this.v9 = v9;
    }

    
    /** 
     * Gets the corresponding value-n
     * @return T10
     */
    @XmlElement(name = "value10")
    public T10 getV10() {
        return v10;
    }

    
    /** 
     * Sets the corresponding value-n
     * @param v10
     */
    public void setV10(T10 v10) {
        this.v10 = v10;
    }

    
    /** 
     * Gets the corresponding value-n
     * @return T11
     */
    @XmlElement(name = "value11")
    public T11 getV11() {
        return v11;
    }

    
    /** 
     * Sets the corresponding value-n
     * @param v11
     */
    public void setV11(T11 v11) {
        this.v11 = v11;
    }

    
    /** 
     * Gets the corresponding value-n
     * @return T12
     */
    @XmlElement(name = "value12")
    public T12 getV12() {
        return v12;
    }

    
    /** 
     * Sets the corresponding value-n
     * @param v12
     */
    public void setV12(T12 v12) {
        this.v12 = v12;
    }


}

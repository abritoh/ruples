package org.clusterbr.ruples.mutable.table;

import java.io.Serializable;
import java.util.Objects;

import org.clusterbr.ruples.immutable.*;
import org.clusterbr.ruples.mutable.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


/**
 * Represents a generic key-value pair where the key and value types are parameterized.
 * 
 * 
 * @param <KEY>   The type of the key.
 * @param <VALUE> The type of the value.
 * 
 * <p>Key features:</p>
 * <ul>
 * <li>Default and parameterized constructors for flexible instantiation.</li>
 * <li>Factory methods for creating instances from tuples or ruples.</li>
 * <li>Standard implementations of `toString`, `equals`, and `hashCode` for object representation and comparison.</li>
 * <li>XML annotation support for serialization/deserialization.</li>
 * </ul>
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/KeyValue.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 */
@XmlRootElement(name = "KeyValue")
public class KeyValue<KEY, VALUE> implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(KeyValue.class);

    private KEY key;
    private VALUE value;

    /**
     * Default constructor, sets initial values to null.
     */    
    public KeyValue() {
        this.key = null;
        this.value = null;
    }

    /**
     * 
     * @param key
     * @param value
     */
    public KeyValue(KEY key, VALUE value) {
        this.key = key;
        this.value = value;
    }

    /** 
     * Converts the instance into its string representation.
     * @return String
     */
    @Override
    public String toString() {
        return String.format("KeyValue{key=%s, value=%s}", key, value);
    }

    /** 
     * Compares input Object "o" with this KeyValue instance.
     * @param o
     * @return boolean
     */    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        KeyValue<?, ?> keyvalue = (KeyValue<?, ?>) o;
        return Objects.equals(key, keyvalue.key) && Objects.equals(value, keyvalue.value);
    }

    /** 
     * Gets the instance hash-code based on instance-values.
     * The hash of each value contributes to generate the total hash.
     * @return int
     */    
    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

   
    /** 
     * Factory method to create a KeyValue
     * @param key
     * @param value
     * @return a new instance of KeyValue
     */
    public static <KEY, VALUE> 
        KeyValue<KEY, VALUE> 
        of(KEY key, VALUE value) {
        return new KeyValue<>(key, value);
    }
    
    /** 
     * Creates a new instance of a KeyValue based on the provided Ruple.
     * @param record
     * @return a new instance of KeyValue
     */
    public static <VALUE> 
        KeyValue<String, VALUE> 
        fromRuple(Ruple2<String, VALUE> record) {
        return new KeyValue<>(record.first(), record.second());
    }

    
    /** 
     * Creates a new instance of a Ruple using the values from the provided KeyValue instance.
     * @param keyvalue
     * @return a new instance of Ruple
     */
    public static <T1, T2> 
        Ruple2<T1, T2> 
        toRuple(KeyValue<T1, T2> keyvalue) {
        return new Ruple2<>(keyvalue.getKey(), keyvalue.getValue());
    }

    
    /** 
     * Creates a new instance of a KeyValue based on the provided Tuple.
     * @param tuple
     * @return a new instance of KeyValue
     */
    public static <VALUE> 
        KeyValue<String, VALUE> 
        fromTuple(Tuple2<String, VALUE> tuple) {
        return new KeyValue<>(tuple.getV1(), tuple.getV2());
    }
    
    /** 
     * Creates a new instance of a Tuple using the values from the provided KeyValue instance.
     * @param keyvalue
     * @return a new instance of Ruple
     */
    public static <T1, T2> 
        Tuple2<T1, T2> 
        toTuple(KeyValue<T1, T2> keyvalue) {
        return new Tuple2<>(keyvalue.getKey(), keyvalue.getValue());
    }

    
    /** 
     * Gets the key
     * @return T1
     */    
    @XmlElement(name = "key")
    public KEY getKey() {
        return key;
    }

    
    /** 
     * Sets the key
     * @param key
     */
    public void setKey(KEY key) {
        this.key = key;
    }

    
    /** 
     * Gets the value
     * @return VALUE
     */
    @XmlElement(name = "value")
    public VALUE getValue() {
        return value;
    }

    
    /** 
     * Sets the value
     * @param value
     */
    public void setValue(VALUE value) {
        this.value = value;
    }    

}

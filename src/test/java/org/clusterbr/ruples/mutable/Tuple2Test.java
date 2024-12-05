package org.clusterbr.ruples.mutable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.clusterbr.ruples.immutable.Ruple2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit tests for the Tuple2 class.
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/Tuple2Test.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 * 
 * <p><b>Example Usage and Test Case:</b></p>
 *
 * <pre>{@code
 * public class Tuple2Test {
 *     private static final Logger logger = LoggerFactory.getLogger(Tuple2Test.class);
 *     private Tuple2<String, Integer> tuple;
 *     private final int v2Val = 911;
 *     private final String v1Val = "TUPLE";
 *
 *     @BeforeEach
 *     public void setUp() {        
 *         tuple = new Tuple2<>(v1Val,v2Val);
 *     }
 *
 *     @Test
 *     public void testConstructor() {
 *         assertNotNull(tuple);
 *         assertEquals(v1Val, tuple.getV1());
 *         assertEquals(v2Val, tuple.getV2());
 *     }
 *
 *     @Test
 *     public void testToString() {
 *         String expected = "Tuple2(v1="+v1Val+", v2="+String.valueOf(v2Val)+")";
 *         assertEquals(expected, tuple.toString());
 *     }
 *
 *     @Test
 *     public void testEqualsAndHashCode() {
 *         Tuple2<String, Integer> anotherTuple = new Tuple2<>(v1Val, v2Val);
 *         assertEquals(tuple, anotherTuple);
 *         assertEquals(tuple.hashCode(), anotherTuple.hashCode());
 *         Tuple2<String, Integer> differentTuple = new Tuple2<>("different", 100);
 *         assertNotEquals(tuple, differentTuple);
 *     }
 *
 *     @Test
 *     public void testToMap() {
 *         Map<String, Object> map = tuple.toMap();
 *         assertEquals(2, map.size());
 *         assertEquals(v1Val, map.get("v1"));
 *         assertEquals(v2Val, map.get("v2"));
 *     }
 *
 *     @Test
 *     public void testCreateNext() {
 *         Tuple3<String, Integer, Boolean> nextTuple = tuple.createNext(true);
 *         assertNotNull(nextTuple);
 *         assertEquals(v1Val, nextTuple.getV1());
 *         assertEquals(v2Val, nextTuple.getV2());
 *         assertTrue(nextTuple.getV3());
 *     }
 *
 *     @Test
 *     public void testSetters() {
 *         tuple.setV1("newValue");
 *         tuple.setV2(99);
 *         assertEquals("newValue", tuple.getV1());
 *         assertEquals(99, tuple.getV2());
 *     }
 *
 *     @Test
 *     public void testNullValues() {
 *         Tuple2<String, Integer> nullTuple = new Tuple2<>(null, null);
 *         assertNull(nullTuple.getV1());
 *         assertNull(nullTuple.getV2());
 *     }
 *
 *     @Test
 *     public void testToRecord() {
 *         Ruple2<String, Integer> record = Tuple2.toRecord(tuple);
 *         assertNotNull(record);
 *         assertEquals(v1Val, record.first());
 *         assertEquals(v2Val, record.second());
 *     }
 *
 *     @Test
 *     public void testFromRecord() {
 *         Ruple2<String, Integer> record = new Ruple2<>("recordTest", 123);
 *         Tuple2<String, Integer> newTuple = Tuple2.fromRecord(record);
 *         assertEquals("recordTest", newTuple.getV1());
 *         assertEquals(123, newTuple.getV2());
 *     }
 * }
 * 
 *}</pre>
 *
 *  
 * */
public class Tuple2Test {

    private static final Logger logger = LoggerFactory.getLogger(Tuple2Test.class);
    private Tuple2<String, Integer> tuple;

    private final int v2Val = 911;
    private final String v1Val = "TUPLE";

    @BeforeEach
    public void setUp() {        
        tuple = new Tuple2<>(v1Val,v2Val);
    }

    @Test
    public void testConstructor() {
        assertNotNull(tuple);
        assertEquals(v1Val, tuple.getV1());
        assertEquals(v2Val, tuple.getV2());
    }

    @Test
    public void testToString() {
        String expected = "Tuple2(v1="+v1Val+", v2="+String.valueOf(v2Val)+")";
        assertEquals(expected, tuple.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        Tuple2<String, Integer> anotherTuple = new Tuple2<>(v1Val, v2Val);
        assertEquals(tuple, anotherTuple);
        assertEquals(tuple.hashCode(), anotherTuple.hashCode());

        Tuple2<String, Integer> differentTuple = new Tuple2<>("different", 100);
        assertNotEquals(tuple, differentTuple);
    }

    @Test
    public void testToMap() {
        Map<String, Object> map = tuple.toMap();
        assertEquals(2, map.size());
        assertEquals(v1Val, map.get("v1"));
        assertEquals(v2Val, map.get("v2"));
    }

    @Test
    public void testCreateNext() {
        Tuple3<String, Integer, Boolean> nextTuple = tuple.createNext(true);
        assertNotNull(nextTuple);
        assertEquals(v1Val, nextTuple.getV1());
        assertEquals(v2Val, nextTuple.getV2());
        assertTrue(nextTuple.getV3());
    }

    @Test
    public void testSetters() {
        tuple.setV1("newValue");
        tuple.setV2(99);
        assertEquals("newValue", tuple.getV1());
        assertEquals(99, tuple.getV2());
    }

    @Test
    public void testNullValues() {
        Tuple2<String, Integer> nullTuple = new Tuple2<>(null, null);
        assertNull(nullTuple.getV1());
        assertNull(nullTuple.getV2());
    }

    @Test
    public void testToRecord() {
        Ruple2<String, Integer> record = Tuple2.toRecord(tuple);
        assertNotNull(record);
        assertEquals(v1Val, record.first());
        assertEquals(v2Val, record.second());
    }

    @Test
    public void testFromRecord() {
        Ruple2<String, Integer> record = new Ruple2<>("recordTest", 123);
        Tuple2<String, Integer> newTuple = Tuple2.fromRecord(record);
        assertEquals("recordTest", newTuple.getV1());
        assertEquals(123, newTuple.getV2());
    }
}

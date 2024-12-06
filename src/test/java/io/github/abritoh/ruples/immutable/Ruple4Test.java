package io.github.abritoh.ruples.immutable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import io.github.abritoh.ruples.mutable.Tuple4;
import io.github.abritoh.ruples.util.JacksonSerializer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Perform unit testing for Ruple4 inmmutable record.
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/Ruple4Test.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 *
 * <p><b>Example Usage and Test Case:</b></p>
 *
 * <pre>{@code
 * public class Ruple4Test {
 *     private static final Logger logger = LoggerFactory.getLogger(Ruple4Test.class);
 *     @Test
 *     public void testCreateNext() {
 *         Ruple4<Integer, String, Double, Boolean> ruple4 = Ruple4.of(1, "two", 3.0, true);
 *         Ruple5<Integer, String, Double, Boolean, Character> ruple5 = ruple4.createNext('x');
 * 
 *         assertEquals(1, ruple5.first());
 *         assertEquals("two", ruple5.second());
 *         assertEquals(3.0, ruple5.third());
 *         assertEquals(true, ruple5.fourth());
 *         assertEquals('x', ruple5.fifth());
 *     }
 * 
 *     @Test
 *     public void testToMap() {
 *         Ruple4<Integer, String, Double, Boolean> ruple4 = Ruple4.of(1, "two", 3.0, true);
 *         Map<String, Object> map = ruple4.toMap();
 * 
 *         assertEquals(4, map.size());
 *         assertEquals(1, map.get("first"));
 *         assertEquals("two", map.get("second"));
 *         assertEquals(3.0, map.get("third"));
 *         assertEquals(true, map.get("fourth"));
 *     }
 * 
 *     @Test
 *     public void testFromRecord() {
 *         Ruple4<Integer, String, Double, Boolean> ruple4 = Ruple4.of(1, "two", 3.0, true);
 *         Tuple4<Integer, String, Double, Boolean> tuple4 = Ruple4.fromRecord(ruple4);
 * 
 *         assertEquals(1, tuple4.getV1());
 *         assertEquals("two", tuple4.getV2());
 *         assertEquals(3.0, tuple4.getV3());
 *         assertEquals(true, tuple4.getV4());
 *     }
 * 
 *     @Test
 *     public void testToRecord() {
 *         Tuple4<Integer, String, Double, Boolean> tuple4 = new Tuple4<>(1, "two", 3.0, true);
 *         Ruple4<Integer, String, Double, Boolean> ruple4 = Ruple4.toRecord(tuple4);
 * 
 *         assertEquals(1, ruple4.first());
 *         assertEquals("two", ruple4.second());
 *         assertEquals(3.0, ruple4.third());
 *         assertEquals(true, ruple4.fourth());
 *     }
 * 
 *     @Test
 *     public void testXmlSerialization() {
 *         Ruple4<Integer, String, Double, Boolean> ruple4 = Ruple4.of(1, "two", 3.0, true);
 *         String xml = JacksonSerializer.serializeToXml(ruple4);
 *         logger.info("(Ruple4Test::testXmlSerialization) ruple4.toString()");
 *         logger.info(ruple4.toString());
 *         logger.info("(Ruple4Test::testXmlSerialization) xml");
 *         logger.info(xml);
 * 
 *         assertNotNull(xml);
 *         assertTrue(xml.contains("<Ruple4>"));
 *         assertTrue(xml.contains("<first>1</first>"));
 *         assertTrue(xml.contains("<second>two</second>"));
 *         assertTrue(xml.contains("<third>3.0</third>"));
 *         assertTrue(xml.contains("<fourth>true</fourth>"));
 *     }
 * }
 *
 *}</pre>
 *  
 **/
public class Ruple4Test {

    private static final Logger logger = LoggerFactory.getLogger(Ruple4Test.class);

    @Test
    public void testCreateNext() {

        Ruple4<Integer, String, Double, Boolean> ruple4 = Ruple4.of(1, "two", 3.0, true);
        Ruple5<Integer, String, Double, Boolean, Character> ruple5 = ruple4.createNext('x');

        assertEquals(1, ruple5.first());
        assertEquals("two", ruple5.second());
        assertEquals(3.0, ruple5.third());
        assertEquals(true, ruple5.fourth());
        assertEquals('x', ruple5.fifth());
    }

    @Test
    public void testToMap() {

        Ruple4<Integer, String, Double, Boolean> ruple4 = Ruple4.of(1, "two", 3.0, true);
        Map<String, Object> map = ruple4.toMap();

        assertEquals(4, map.size());
        assertEquals(1, map.get("first"));
        assertEquals("two", map.get("second"));
        assertEquals(3.0, map.get("third"));
        assertEquals(true, map.get("fourth"));
    }

    @Test
    public void testFromRecord() {

        Ruple4<Integer, String, Double, Boolean> ruple4 = Ruple4.of(1, "two", 3.0, true);
        Tuple4<Integer, String, Double, Boolean> tuple4 = Ruple4.fromRecord(ruple4);

        assertEquals(1, tuple4.getV1());
        assertEquals("two", tuple4.getV2());
        assertEquals(3.0, tuple4.getV3());
        assertEquals(true, tuple4.getV4());
    }

    @Test
    public void testToRecord() {

        Tuple4<Integer, String, Double, Boolean> tuple4 = new Tuple4<>(1, "two", 3.0, true);
        Ruple4<Integer, String, Double, Boolean> ruple4 = Ruple4.toRecord(tuple4);

        assertEquals(1, ruple4.first());
        assertEquals("two", ruple4.second());
        assertEquals(3.0, ruple4.third());
        assertEquals(true, ruple4.fourth());
    }

    @Test
    public void testXmlSerialization() {

        Ruple4<Integer, String, Double, Boolean> ruple4 = Ruple4.of(1, "two", 3.0, true);

        String xml = JacksonSerializer.serializeToXml(ruple4);

        logger.info("(Ruple4Test::testXmlSerialization) ruple4.toString()");
        logger.info(ruple4.toString());

        logger.info("(Ruple4Test::testXmlSerialization) xml");
        logger.info(xml);

        assertNotNull(xml);
        assertTrue(xml.contains("<Ruple4>"));
        assertTrue(xml.contains("<first>1</first>"));
        assertTrue(xml.contains("<second>two</second>"));
        assertTrue(xml.contains("<third>3.0</third>"));
        assertTrue(xml.contains("<fourth>true</fourth>"));
    }
}

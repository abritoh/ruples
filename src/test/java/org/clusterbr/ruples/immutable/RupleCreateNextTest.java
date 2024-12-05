package org.clusterbr.ruples.immutable;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.clusterbr.ruples.util.JacksonSerializer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * Validate the createNext(...) method for each Ruple.
 * Serializes each Ruple by using JacksonSerializer and GsonSerializer serializers.
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/RupleCreateNextTest.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 *  
 * <p><b>Example Usage and Test Case:</b></p>
 * 
 * <pre>{@code
 *public class RupleCreateNextTest {
 *    private static final Logger logger = LoggerFactory.getLogger(RupleCreateNextTest.class);
 *    @Test
 *    public void testCreateNextAndSerialization() {        
 *        Ruple1<String> ruple1 = Ruple1.of("First");
 *        Ruple2<String, Integer> ruple2 = ruple1.createNext(2);
 *        Ruple3<String, Integer, Boolean> ruple3 = ruple2.createNext(true);
 *        Ruple4<String, Integer, Boolean, Double> ruple4 = ruple3.createNext(4.0);
 *        Ruple5<String, Integer, Boolean, Double, Character> ruple5 = ruple4.createNext('A');
 *        Ruple6<String, Integer, Boolean, Double, Character, String> ruple6 = ruple5.createNext("Six");
 *        Ruple7<String, Integer, Boolean, Double, Character, String, Long> ruple7 = ruple6.createNext(7L);
 *        Ruple8<String, Integer, Boolean, Double, Character, String, Long, Float> ruple8 = ruple7.createNext(8.0f);
 *        Ruple9<String, Integer, Boolean, Double, Character, String, Long, Float, Short> ruple9 = ruple8.createNext((short) 9);
 *        Ruple10<String, Integer, Boolean, Double, Character, String, Long, Float, Short, Byte> ruple10 = ruple9.createNext((byte) 10);
 *        Ruple11<String, Integer, Boolean, Double, Character, String, Long, Float, Short, Byte, String> ruple11 = ruple10.createNext("Eleventh");
 *        Ruple12<String, Integer, Boolean, Double, Character, String, Long, Float, Short, Byte, String, Long> ruple12 = ruple11.createNext(10000000000000L);
 * 
 *        validateSerialization(ruple1, "Ruple1");
 *        validateSerialization(ruple2, "Ruple2");
 *        validateSerialization(ruple3, "Ruple3");
 *        validateSerialization(ruple4, "Ruple4");
 *        validateSerialization(ruple5, "Ruple5");
 *        validateSerialization(ruple6, "Ruple6");
 *        validateSerialization(ruple7, "Ruple7");
 *        validateSerialization(ruple8, "Ruple8");
 *        validateSerialization(ruple9, "Ruple9");
 *        validateSerialization(ruple10, "Ruple10");
 *        validateSerialization(ruple11, "Ruple11");
 *        validateSerialization(ruple12, "Ruple12");
 *    }
 * 
 *    private <T> void validateSerialization(T ruple, String rupleName) {
 *        try {
 *            String xml = JacksonSerializer.serializeToXml(ruple);            
 *            logger.info("(RupleCreateNextTest::testCreateNextAndSerialization) JacksonSerializer for: ".concat(rupleName) );
 *            logger.info(xml);
 * 
 *            String json = org.apache.ruples.util.GsonSerializer.toJson(ruple);
 *            logger.info("(RupleCreateNextTest::testCreateNextAndSerialization) GsonSerializer for: ".concat(rupleName) );
 *            logger.info(json);
 * 
 *            assertNotNull(xml, rupleName + " XML serialization failed!");
 *            assertNotNull(json, rupleName + " JSON serialization failed!");
 * 
 *        } catch (Exception ex) {
 *            fail(rupleName.concat(" serialization threw an exception: ")
 *                          .concat( (ex.getMessage() != null) ? ex.getMessage() : ex.toString() ) );
 *        }
 *    }
 * }
 * }</pre>
 * 
 */
public class RupleCreateNextTest {

    private static final Logger logger = LoggerFactory.getLogger(RupleCreateNextTest.class);

    @Test
    public void testCreateNextAndSerialization() {
        
        //-- uses createNext to chain up to Ruple12
        Ruple1<String> ruple1 = Ruple1.of("First");
        Ruple2<String, Integer> ruple2 = ruple1.createNext(2);
        Ruple3<String, Integer, Boolean> ruple3 = ruple2.createNext(true);
        Ruple4<String, Integer, Boolean, Double> ruple4 = ruple3.createNext(4.0);
        Ruple5<String, Integer, Boolean, Double, Character> ruple5 = ruple4.createNext('A');
        Ruple6<String, Integer, Boolean, Double, Character, String> ruple6 = ruple5.createNext("Six");
        Ruple7<String, Integer, Boolean, Double, Character, String, Long> ruple7 = ruple6.createNext(7L);
        Ruple8<String, Integer, Boolean, Double, Character, String, Long, Float> ruple8 = ruple7.createNext(8.0f);
        Ruple9<String, Integer, Boolean, Double, Character, String, Long, Float, Short> ruple9 = ruple8.createNext((short) 9);
        Ruple10<String, Integer, Boolean, Double, Character, String, Long, Float, Short, Byte> ruple10 = ruple9.createNext((byte) 10);
        Ruple11<String, Integer, Boolean, Double, Character, String, Long, Float, Short, Byte, String> ruple11 = ruple10.createNext("Eleventh");
        Ruple12<String, Integer, Boolean, Double, Character, String, Long, Float, Short, Byte, String, Long> ruple12 = ruple11.createNext(10000000000000L);

        //-- serialize each Ruple with Jackson and Gson
        validateSerialization(ruple1, "Ruple1");
        validateSerialization(ruple2, "Ruple2");
        validateSerialization(ruple3, "Ruple3");
        validateSerialization(ruple4, "Ruple4");
        validateSerialization(ruple5, "Ruple5");
        validateSerialization(ruple6, "Ruple6");
        validateSerialization(ruple7, "Ruple7");
        validateSerialization(ruple8, "Ruple8");
        validateSerialization(ruple9, "Ruple9");
        validateSerialization(ruple10, "Ruple10");
        validateSerialization(ruple11, "Ruple11");
        validateSerialization(ruple12, "Ruple12");
    }

    private <T> void validateSerialization(T ruple, String rupleName) {
        try {
            //-- serialize with Jackson
            String xml = JacksonSerializer.serializeToXml(ruple);            
            logger.info("(RupleCreateNextTest::testCreateNextAndSerialization) JacksonSerializer for: ".concat(rupleName) );
            logger.info(xml);

            //-- serialize with Gson
            String json = org.clusterbr.ruples.util.GsonSerializer.toJson(ruple);
            logger.info("(RupleCreateNextTest::testCreateNextAndSerialization) GsonSerializer for: ".concat(rupleName) );
            logger.info(json);

            //-- sssert serialization is not null
            assertNotNull(xml, rupleName + " XML serialization failed!");
            assertNotNull(json, rupleName + " JSON serialization failed!");

        } catch (Exception ex) {
            fail(rupleName.concat(" serialization threw an exception: ")
                          .concat( (ex.getMessage() != null) ? ex.getMessage() : ex.toString() ) );
        }
    }
}

package io.github.abritoh.ruples.mutable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

import io.github.abritoh.ruples.mutable.table.KeyValue;
import io.github.abritoh.ruples.mutable.table.MuTableKV;
import io.github.abritoh.ruples.mutable.table.MuTableRow;
import io.github.abritoh.ruples.util.JAXBSerializer;
import io.github.abritoh.ruples.util.JacksonSerializer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.xml.bind.JAXBException;

/**
 * Unit test class for testing the functionality of the MuTableKV class.
 * This class includes tests for data population, serialization, and integration with Sql.ResultSet
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/MuTableKVTest.png" alt="UML Diagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 * 
 * <p><b>Example Usage and Test Case:</b></p>
 *
 * <pre>{@code
  * @ExtendWith(MockitoExtension.class)
 * public class MuTableKVTest {
 *     private static final Logger logger = LoggerFactory.getLogger(MuTableKVTest.class);
 *     
 *     @Test
 *     public void testPopulateDataWithHardcodedItems() {
 *         MuTableRow row1 = new MuTableRow();        
 *         row1.getRowList().add(new KeyValue<>("groupId", "org.apache"));
 *         row1.getRowList().add(new KeyValue<>("artifactId", "maven-core"));
 *         row1.getRowList().add(new KeyValue<>("version", "3.9"));
 * 
 *         MuTableRow row2 = new MuTableRow();
 *         row2.getRowList().add(new KeyValue<>("groupId", "org.springframework"));
 *         row2.getRowList().add(new KeyValue<>("artifactId", "spring-core"));
 *         row2.getRowList().add(new KeyValue<>("version", "5.2"));        
 * 
 *         MuTableKV muTableKV = new MuTableKV();
 *         muTableKV.getTableData().add(row1);
 *         muTableKV.getTableData().add(row2);
 * 
 *         assertNotNull(muTableKV.getTableData());
 *         assertEquals(2, muTableKV.getTableData().size());
 *         assertEquals("org.apache", muTableKV.getTableData().get(0).getRowList().get(0).getValue() );
 * 
 *         logger.info("(MuTableKVTest::testPopulateDataWithHardcodedItems) muTableKV.toString()");
 *         logger.info(muTableKV.toString());
 *     }
 * 
 *     @Test
 *     public void testPopulateDataFromH2Database() {
 *         String h2cbdi = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", word1 = "c2E=", word2="";
 * 
 *         MuTableKV muTableKV = new MuTableKV();
 *         try (Connection conn = DriverManager.getConnection(h2cbdi, whisper(word1), whisper(word2))) {
 *             Statement stmt = conn.createStatement();
 *             stmt.execute(
 *                     "CREATE TABLE mavenplugins (groupId VARCHAR(255), artifactId VARCHAR(255), version VARCHAR(255), description VARCHAR(255))");
 *             stmt.execute(
 *                     "INSERT INTO mavenplugins (groupId, artifactId, version, description) VALUES ('org.apache', 'maven-core', '3.9', 'Maven Core')");
 *             stmt.execute(
 *                     "INSERT INTO mavenplugins (groupId, artifactId, version, description) VALUES ('org.springframework', 'spring-core', '5.2', 'Spring Core')");
 * 
 *             ResultSet rs = stmt.executeQuery("SELECT * FROM mavenplugins");
 *             while (rs.next()) {                
 *                 MuTableRow row = new MuTableRow();
 *                 row.getRowList().add(new KeyValue<>("groupId", rs.getString("groupId")));
 *                 row.getRowList().add(new KeyValue<>("artifactId", rs.getString("artifactId")));
 *                 row.getRowList().add(new KeyValue<>("version", rs.getString("version")));
 *                 row.getRowList().add(new KeyValue<>("description", rs.getString("description")));                
 *                 muTableKV.getTableData().add(row);
 *             }
 * 
 *             logger.info("(MuTableKVTest::testPopulateDataFromH2Database) muTableKV.toString()");
 *             logger.info(muTableKV.toString());
 * 
 *             assertNotNull(muTableKV.getTableData());
 *             assertEquals(2, muTableKV.getTableData().size());
 *             assertEquals("org.apache", muTableKV.getTableData().get(0).getRowList().get(0).getValue());
 *             assertEquals("Maven Core", muTableKV.getTableData().get(0).getRowList().get(3).getValue());
 * 
 *         } catch (Exception ex) {
 *             ex.printStackTrace();
 *             String msg = "Database setup failed: " + ( (ex.getMessage() != null) ? ex.getMessage() : ex.toString() );
 *             logger.error("[Exception] (MuTableKVTest::testPopulateDataFromH2Database)", ex);
 *             logger.error(msg);
 * 
 *             fail(msg);
 *         }
 *     }
 * 
 *     @Test
 *     public void testSerializeToXml() {        
 *         MuTableRow row1 = new MuTableRow();
 *         row1.getRowList().add(new KeyValue<>("groupId", "org.apache"));
 *         row1.getRowList().add(new KeyValue<>("artifactId", "maven-core"));
 *         row1.getRowList().add(new KeyValue<>("version", "3.9"));
 * 
 *         MuTableRow row2 = new MuTableRow();
 *         row2.getRowList().add(new KeyValue<>("groupId", "org.springframework"));
 *         row2.getRowList().add(new KeyValue<>("artifactId", "spring-core"));
 *         row2.getRowList().add(new KeyValue<>("version", "5.2"));
 * 
 *         MuTableKV muTableKV = new MuTableKV();
 *         muTableKV.getTableData().add(row1);
 *         muTableKV.getTableData().add(row2);
 * 
 *         String xmlJABX = JAXBSerializer.serializeToXml(muTableKV);
 *         String xmlJackson = JacksonSerializer.serializeToXml(muTableKV);        
 * 
 *         logger.info("(MuTableKVTest::testSerializeToXml) muTableKV.toString()");
 *         logger.info(muTableKV.toString());
 * 
 *         logger.info("(MuTableKVTest::testSerializeToXml::JAXBSerializer) xmlJABX");
 *         logger.info(xmlJABX);
 * 
 *         logger.info("(MuTableKVTest::testSerializeToXml::JacksonSerializer) xmlJackson");
 *         logger.info(xmlJackson);        
 * 
 *         assertNotNull(xmlJABX);
 *         assertTrue(xmlJABX.contains("rows"));
 *         assertTrue(xmlJABX.contains("<row>"));
 *         assertTrue(xmlJABX.contains("org.springframework"));
 *     }
 * }
 * }</pre>
 */
@ExtendWith(MockitoExtension.class)
public class MuTableKVTest {

    private static final Logger logger = LoggerFactory.getLogger(MuTableKVTest.class);

    /**
     * Test case to populate data into MuTableKV with hardcoded items.
     * Validates data addition and string representation of the object.
     */
    @Test
    public void testPopulateDataWithHardcodedItems() {        
        
        MuTableRow row1 = new MuTableRow();        
        row1.getRowList().add(new KeyValue<>("groupId", "org.apache"));
        row1.getRowList().add(new KeyValue<>("artifactId", "maven-core"));
        row1.getRowList().add(new KeyValue<>("version", "3.9"));

        MuTableRow row2 = new MuTableRow();
        row2.getRowList().add(new KeyValue<>("groupId", "org.springframework"));
        row2.getRowList().add(new KeyValue<>("artifactId", "spring-core"));
        row2.getRowList().add(new KeyValue<>("version", "5.2"));        

        MuTableKV muTableKV = new MuTableKV();
        muTableKV.getTableData().add(row1);
        muTableKV.getTableData().add(row2);

        assertNotNull(muTableKV.getTableData());
        assertEquals(2, muTableKV.getTableData().size());
        assertEquals("org.apache", muTableKV.getTableData().get(0).getRowList().get(0).getValue() );

        logger.info("(MuTableKVTest::testPopulateDataWithHardcodedItems) muTableKV.toString()");
        logger.info(muTableKV.toString());
    }

    /**
     * Test case to populate data into MuTableKV using an H2 in-memory database.
     * Validates data retrieval from the database into ResultSet and conversion to MuTableKV structure.
     */
    @Test
    public void testPopulateDataFromH2Database() {
        String h2cbdi = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", word1 = "c2E=", word2="";

        MuTableKV muTableKV = new MuTableKV();
        try (Connection conn = DriverManager.getConnection(h2cbdi, whisper(word1), whisper(word2))) {
            Statement stmt = conn.createStatement();
            stmt.execute(
                    "CREATE TABLE mavenplugins (groupId VARCHAR(255), artifactId VARCHAR(255), version VARCHAR(255), description VARCHAR(255))");
            stmt.execute(
                    "INSERT INTO mavenplugins (groupId, artifactId, version, description) VALUES ('org.apache', 'maven-core', '3.9', 'Maven Core')");
            stmt.execute(
                    "INSERT INTO mavenplugins (groupId, artifactId, version, description) VALUES ('org.springframework', 'spring-core', '5.2', 'Spring Core')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM mavenplugins");
            while (rs.next()) {                
                
                MuTableRow row = new MuTableRow();
                row.getRowList().add(new KeyValue<>("groupId", rs.getString("groupId")));
                row.getRowList().add(new KeyValue<>("artifactId", rs.getString("artifactId")));
                row.getRowList().add(new KeyValue<>("version", rs.getString("version")));
                row.getRowList().add(new KeyValue<>("description", rs.getString("description")));
                
                muTableKV.getTableData().add(row);
            }

            logger.info("(MuTableKVTest::testPopulateDataFromH2Database) muTableKV.toString()");
            logger.info(muTableKV.toString());

            assertNotNull(muTableKV.getTableData());
            assertEquals(2, muTableKV.getTableData().size());
            assertEquals("org.apache", muTableKV.getTableData().get(0).getRowList().get(0).getValue());
            assertEquals("Maven Core", muTableKV.getTableData().get(0).getRowList().get(3).getValue());

        } catch (Exception ex) {
            ex.printStackTrace();
            String msg = "Database setup failed: " + ( (ex.getMessage() != null) ? ex.getMessage() : ex.toString() );
            logger.error("[Exception] (MuTableKVTest::testPopulateDataFromH2Database)", ex);
            logger.error(msg);

            fail(msg);
        }
    }

    /**
     * Test case to serialize MuTableKV into an XML format.
     * Validates the XML serialization of MuTableKV, MuTableRow and KeyValue 
     * ensuring that the data is serialized correctly.
     */
    @Test
    public void testSerializeToXml() {
        
        MuTableRow row1 = new MuTableRow();
        row1.getRowList().add(new KeyValue<>("groupId", "org.apache"));
        row1.getRowList().add(new KeyValue<>("artifactId", "maven-core"));
        row1.getRowList().add(new KeyValue<>("version", "3.9"));

        MuTableRow row2 = new MuTableRow();
        row2.getRowList().add(new KeyValue<>("groupId", "org.springframework"));
        row2.getRowList().add(new KeyValue<>("artifactId", "spring-core"));
        row2.getRowList().add(new KeyValue<>("version", "5.2"));

        MuTableKV muTableKV = new MuTableKV();
        muTableKV.getTableData().add(row1);
        muTableKV.getTableData().add(row2);

        String xmlJABX = JAXBSerializer.serializeToXml(muTableKV);
        String xmlJackson = JacksonSerializer.serializeToXml(muTableKV);        

        logger.info("(MuTableKVTest::testSerializeToXml) muTableKV.toString()");
        logger.info(muTableKV.toString());

        logger.info("(MuTableKVTest::testSerializeToXml::JAXBSerializer) xmlJABX");
        logger.info(xmlJABX);

        logger.info("(MuTableKVTest::testSerializeToXml::JacksonSerializer) xmlJackson");
        logger.info(xmlJackson);        

        assertNotNull(xmlJABX);
        assertTrue(xmlJABX.contains("rows"));
        assertTrue(xmlJABX.contains("<row>"));
        assertTrue(xmlJABX.contains("org.springframework"));
    }

    private String whisper(String iunderztand) {
        if( iunderztand == null || iunderztand.isEmpty() ) return "";
        byte[] byeti3s = Base64.getDecoder().decode(iunderztand);
        return new String(byeti3s);
    }
}

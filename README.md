# Ruples
![JAVA](./src/main/resources/img/java-logo.png "JAVA")

_**Comprehensive Implementation of Immutable Ruples and Mutable Tuples in Java.**_


## Ruples Project Overview

The Ruples Project combines the reliability of **immutable records** with the flexibility of **mutable tuples**, all seamlessly integrated with Java's serialization capabilities.

### Changelog
  
  - Version 1.1 | 2024-1205: [Issue Report ─ Challenges Publishing to Maven Central and origin of the changes](./src/test/java/resources/deployment-issues-2024-1205.md). Maven Central Repository guidelines applied.
  - Version 1.0 | 2024-1118: Ruples & Tuples Initial version 

## Key Features

### Mutable Tuples
- **Scalable Variables**: These Tuples can handle a dynamic range of variables, from a single element up to twelve, making them useful for a wide array of applications.
- **Based on Java Class Serializables**: These tuples are mutable, allowing you to change their values as needed while maintaining full serializability.

### Immutable Ruples
- **Scalable Variables**: Just like the Tuples, Ruples can span from one to twelve elements, offering a robust solution for immutable data structures.
- **Based on Java Record Serializables**: These immutable Ruples leverage the power of Java Records, ensuring that your data remains constant and secure.

### MuTableKV Class
- **JAXB-Serializable Representation**: MuTableKV offers a versatile, table-like structure where each row is a list of key-value pairs.
- **Full Serializability**: Whether you're working with predefined data or dynamically populated rows from a database, MuTableKV ensures that your data structure is always serializable and ready for data exchange between layers of the application and with external application.

Dive in and see how Ruples & Tuples can enhance your coding experience!

## Versioned JavaDoc

### Version 1.1
<ul>
<li>Main Api documentation: 
<a target="_blank" href="https://abritoh.github.io/ruples/1.1/apidocs">https://abritoh.github.io/ruples/1.1/apidocs</a></li>
<li>Test Api documentation: 
<a target="_blank" href="https://abritoh.github.io/ruples/1.1/testapidocs">https://abritoh.github.io/ruples/1.1/testapidocs</a> </li>
</ul>

### Version 1.0
<ul>
<li>Main Api documentation: 
<a target="_blank" href="https://abritoh.github.io/ruples/1.0/apidocs">https://abritoh.github.io/ruples/1.0/apidocs</a></li>
<li>Test Api documentation: 
<a target="_blank" href="https://abritoh.github.io/ruples/1.0/testapidocs">https://abritoh.github.io/ruples/1.0/testapidocs</a> </li>
</ul>


## Example Usage

```java
public void testPopulateDataFromH2Database() {
    String h = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", u = "sa", p = "";

    MuTableKV muTableKV = new MuTableKV();
    try (Connection conn = DriverManager.getConnection(h, u, p)) {
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
```


```java
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
```



```java
@Test
public void testCreateNextAndSerialization() {
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
    ...
}

```
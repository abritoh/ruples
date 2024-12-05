package org.clusterbr.ruples.mutable.table;

import java.util.ArrayList;
import java.util.List;

import org.clusterbr.ruples.abztract.JAXBSerializable;
import org.clusterbr.ruples.mutable.table.MuTableRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The MuTableKV class is a JAXB-serializable representation of a table-like
 * structure where each row contains a list of key-value pairs.
 * 
 * <p>
 * <b>Class Diagram:</b>
 * </p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/MuTableKV.png" alt="UMLDiagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 * 
 */
@XmlRootElement(name = "rows")
public class MuTableKV implements JAXBSerializable {

    private static final Logger logger = LoggerFactory.getLogger(MuTableKV.class);

    @JsonIgnore
    private static final JAXBContext jaxbContext;

    private ArrayList<MuTableRow> tableData = new ArrayList<>();

    static {
        JAXBContext tempContext = null;
        try {
            tempContext = JAXBContext.newInstance(
                MuTableKV.class, MuTableRow.class, KeyValue.class)
            ;
        } catch (JAXBException ex) {
            ex.printStackTrace();
            logger.error("[Error] (MuTableKV:JAXBContext.newInstance)", ex);
        }
        jaxbContext = tempContext;
    }    

    /**
     * Retrieves the table data.
     *
     * @return a list of rows, where each row is a list of key-value pairs.
     */
    @XmlElement(name = "row")
    public ArrayList<MuTableRow> getTableData() {
        return tableData;
    }

    /**
     * Sets the table data.
     *
     * @param tableData a list of rows, where each row is a list of key-value pairs.
     */
    public void setTableData(ArrayList<MuTableRow> tableData) {
        this.tableData = tableData;
    }

    /**
     * Provides the JAXBContext instance used for serializing and deserializing
     * instances of this class.
     *
     * @return the JAXBContext instance.
     */
    @JsonIgnore
    public JAXBContext getJAXBContext() {
        return jaxbContext;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MuTableKV{\n");
        if (tableData != null && !tableData.isEmpty()) {
            int rowIndex = 0;
            for (MuTableRow row : tableData) {
                sb.append(" ")
                .append(rowIndex++).append(": ")
                .append(row.toString())
                .append("\n")
                ;
            }
        } else {
            sb.append("  No rows available\n");
        }
        sb.append("}");
        return sb.toString();
    }

}

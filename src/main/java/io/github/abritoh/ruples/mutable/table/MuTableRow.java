package io.github.abritoh.ruples.mutable.table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.github.abritoh.ruples.abztract.JAXBSerializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * The MuTableRow class is a JAXB-serializable representation of a row structure
 * this row contains a list of key-value pairs.
 * 
 * <p><b>Class Diagram:</b></p>
 * <div style="text-align:center;"><img src="{@docRoot}/generated-resources/uml/images/MuTableRow.png" alt="UMLDiagram"></div>
 * 
 * @since 2024-1118
 * @author ClusterBR
 * 
 */
@XmlRootElement(name = "row")
public class MuTableRow implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(MuTableRow.class);

    private List<KeyValue<String, Object>> rowList = new ArrayList<>();

    /**
     * Retrieves the row data.
     * 
     * @return
     */
    @XmlElement(name = "keyValue")
    public List<KeyValue<String, Object>> getRowList() {
        return rowList;
    }

    /**
     * Sets the row data.
     * 
     * @param rowList
     */
    public void setRowList(List<KeyValue<String, Object>> rowList) {
        this.rowList = rowList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MuTableRow{");
        if (rowList != null && !rowList.isEmpty()) {
            for (KeyValue<String, Object> kv : rowList) {
                sb.append("{key=").append(kv.getKey())
                        .append(", value=").append(kv.getValue())
                        .append("}, ");
            }
            //-- remove the last ", "
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");
        return sb.toString();
    }

}


package nl.strmark.demo;

import jakarta.annotation.Generated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for AuditTrail complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="AuditTrail">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="userID">
 *           <simpleType>
 *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               <maxLength value="20"/>
 *               <pattern value="\S.*"/>
 *             </restriction>
 *           </simpleType>
 *         </element>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditTrailType", propOrder = {
    "userID"
})
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v4.0.5", date = "2024-11-29T10:43:46+01:00")
@XmlRootElement(name = "AuditTrail")
public class AuditTrail {

    /**
     * Identificatie
     * 						van de gebruiker die de nieuwe versie heeftopgevoerd.
     *
     */
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v4.0.5", date = "2024-11-29T10:43:46+01:00")
    protected String userID;

    /**
     * Default no-arg constructor
     *
     */
    public AuditTrail() {
        super();
    }

    /**
     * Fully-initialising value constructor
     *
     */
    public AuditTrail(final String userID) {
        this.userID = userID;
    }

    /**
     * Identificatie
     * 						van de gebruiker die de nieuwe versie heeftopgevoerd.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v4.0.5", date = "2024-11-29T10:43:46+01:00")
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     * @see #getUserID()
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v4.0.5", date = "2024-11-29T10:43:46+01:00")
    public void setUserID(String value) {
        this.userID = value;
    }

}

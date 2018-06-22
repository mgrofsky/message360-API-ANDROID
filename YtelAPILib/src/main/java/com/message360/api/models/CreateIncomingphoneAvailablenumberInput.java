/*
 * YtelAPILib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.message360.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CreateIncomingphoneAvailablenumberInput 
        extends java.util.Observable
        implements java.io.Serializable {
    private static final long serialVersionUID = 5136759628971839824L;
    private Numbertype16Enum numbertype;
    private String areacode;
    private Integer pagesize = 10;
    /** GETTER
     * Number type either SMS,Voice or all
     */
    @JsonGetter("numbertype")
    public Numbertype16Enum getNumbertype ( ) { 
        return this.numbertype;
    }
    
    /** SETTER
     * Number type either SMS,Voice or all
     */
    @JsonSetter("numbertype")
    public void setNumbertype (Numbertype16Enum value) { 
        this.numbertype = value;
        notifyObservers(this.numbertype);
    }
 
    /** GETTER
     * Specifies the area code for the returned list of available numbers. Only available for North American numbers.
     */
    @JsonGetter("areacode")
    public String getAreacode ( ) { 
        return this.areacode;
    }
    
    /** SETTER
     * Specifies the area code for the returned list of available numbers. Only available for North American numbers.
     */
    @JsonSetter("areacode")
    public void setAreacode (String value) { 
        this.areacode = value;
        notifyObservers(this.areacode);
    }
 
    /** GETTER
     * The count of objects to return.
     */
    @JsonGetter("pagesize")
    public Integer getPagesize ( ) { 
        return this.pagesize;
    }
    
    /** SETTER
     * The count of objects to return.
     */
    @JsonSetter("pagesize")
    public void setPagesize (Integer value) { 
        this.pagesize = value;
        notifyObservers(this.pagesize);
    }
 
}
 
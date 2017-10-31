/*
 * Message360
 *
 * This file was automatically generated for message360 by APIMATIC v2.0 ( https://apimatic.io ).
 */
package message360.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class DeleteRecordingInput 
        extends java.util.Observable
        implements java.io.Serializable {
    private static final long serialVersionUID = 4800921057085375512L;
    private String recordingSid;
    private String responseType = "json";
    /** GETTER
     * Unique Recording Sid to be delete
     */
    @JsonGetter("RecordingSid")
    public String getRecordingSid ( ) { 
        return this.recordingSid;
    }
    
    /** SETTER
     * Unique Recording Sid to be delete
     */
    @JsonSetter("RecordingSid")
    public void setRecordingSid (String value) { 
        this.recordingSid = value;
        notifyObservers(this.recordingSid);
    }
 
    /** GETTER
     * Response type format xml or json
     */
    @JsonGetter("ResponseType")
    public String getResponseType ( ) { 
        return this.responseType;
    }
    
    /** SETTER
     * Response type format xml or json
     */
    @JsonSetter("ResponseType")
    public void setResponseType (String value) { 
        this.responseType = value;
        notifyObservers(this.responseType);
    }
 
}
 
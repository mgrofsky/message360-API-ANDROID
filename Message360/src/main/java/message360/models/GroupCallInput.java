/*
 * Message360
 *
 * This file was automatically generated for message360 by APIMATIC v2.0 ( https://apimatic.io ).
 */
package message360.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class GroupCallInput 
        extends java.util.Observable
        implements java.io.Serializable {
    private static final long serialVersionUID = 5544288881860116578L;
    private String from;
    private String to;
    private String url;
    private String responseType = "json";
    private String groupConfirmKey;
    private AudioFormatEnum groupConfirmFile;
    private HttpActionEnum method;
    private String statusCallBackUrl;
    private HttpActionEnum statusCallBackMethod;
    private String fallBackUrl;
    private HttpActionEnum fallBackMethod;
    private String heartBeatUrl;
    private HttpActionEnum heartBeatMethod;
    private Integer timeout;
    private String playDtmf;
    private String hideCallerId;
    private Boolean record;
    private String recordCallBackUrl;
    private HttpActionEnum recordCallBackMethod;
    private Boolean transcribe;
    private String transcribeCallBackUrl;
    /** GETTER
     * This number to display on Caller ID as calling
     */
    @JsonGetter("From")
    public String getFrom ( ) { 
        return this.from;
    }
    
    /** SETTER
     * This number to display on Caller ID as calling
     */
    @JsonSetter("From")
    public void setFrom (String value) { 
        this.from = value;
        notifyObservers(this.from);
    }
 
    /** GETTER
     * Please enter multiple E164 number. You can add max 10 numbers. Add numbers separated with comma. e.g : 1111111111,2222222222
     */
    @JsonGetter("To")
    public String getTo ( ) { 
        return this.to;
    }
    
    /** SETTER
     * Please enter multiple E164 number. You can add max 10 numbers. Add numbers separated with comma. e.g : 1111111111,2222222222
     */
    @JsonSetter("To")
    public void setTo (String value) { 
        this.to = value;
        notifyObservers(this.to);
    }
 
    /** GETTER
     * URL requested once the call connects
     */
    @JsonGetter("Url")
    public String getUrl ( ) { 
        return this.url;
    }
    
    /** SETTER
     * URL requested once the call connects
     */
    @JsonSetter("Url")
    public void setUrl (String value) { 
        this.url = value;
        notifyObservers(this.url);
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ResponseType")
    public String getResponseType ( ) { 
        return this.responseType;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ResponseType")
    public void setResponseType (String value) { 
        this.responseType = value;
        notifyObservers(this.responseType);
    }
 
    /** GETTER
     * Define the DTMF that the called party should send to bridge the call. Allowed Values : 0-9, #, *
     */
    @JsonGetter("GroupConfirmKey")
    public String getGroupConfirmKey ( ) { 
        return this.groupConfirmKey;
    }
    
    /** SETTER
     * Define the DTMF that the called party should send to bridge the call. Allowed Values : 0-9, #, *
     */
    @JsonSetter("GroupConfirmKey")
    public void setGroupConfirmKey (String value) { 
        this.groupConfirmKey = value;
        notifyObservers(this.groupConfirmKey);
    }
 
    /** GETTER
     * Specify the audio file you want to play when the called party picks up the call
     */
    @JsonGetter("GroupConfirmFile")
    public AudioFormatEnum getGroupConfirmFile ( ) { 
        return this.groupConfirmFile;
    }
    
    /** SETTER
     * Specify the audio file you want to play when the called party picks up the call
     */
    @JsonSetter("GroupConfirmFile")
    public void setGroupConfirmFile (AudioFormatEnum value) { 
        this.groupConfirmFile = value;
        notifyObservers(this.groupConfirmFile);
    }
 
    /** GETTER
     * Specifies the HTTP method used to request the required URL once call connects.
     */
    @JsonGetter("Method")
    public HttpActionEnum getMethod ( ) { 
        return this.method;
    }
    
    /** SETTER
     * Specifies the HTTP method used to request the required URL once call connects.
     */
    @JsonSetter("Method")
    public void setMethod (HttpActionEnum value) { 
        this.method = value;
        notifyObservers(this.method);
    }
 
    /** GETTER
     * Specifies the HTTP method used to request the required URL once call connects.
     */
    @JsonGetter("StatusCallBackUrl")
    public String getStatusCallBackUrl ( ) { 
        return this.statusCallBackUrl;
    }
    
    /** SETTER
     * Specifies the HTTP method used to request the required URL once call connects.
     */
    @JsonSetter("StatusCallBackUrl")
    public void setStatusCallBackUrl (String value) { 
        this.statusCallBackUrl = value;
        notifyObservers(this.statusCallBackUrl);
    }
 
    /** GETTER
     * Specifies the HTTP methodlinkclass used to request StatusCallbackUrl.
     */
    @JsonGetter("StatusCallBackMethod")
    public HttpActionEnum getStatusCallBackMethod ( ) { 
        return this.statusCallBackMethod;
    }
    
    /** SETTER
     * Specifies the HTTP methodlinkclass used to request StatusCallbackUrl.
     */
    @JsonSetter("StatusCallBackMethod")
    public void setStatusCallBackMethod (HttpActionEnum value) { 
        this.statusCallBackMethod = value;
        notifyObservers(this.statusCallBackMethod);
    }
 
    /** GETTER
     * URL requested if the initial Url parameter fails or encounters an error
     */
    @JsonGetter("FallBackUrl")
    public String getFallBackUrl ( ) { 
        return this.fallBackUrl;
    }
    
    /** SETTER
     * URL requested if the initial Url parameter fails or encounters an error
     */
    @JsonSetter("FallBackUrl")
    public void setFallBackUrl (String value) { 
        this.fallBackUrl = value;
        notifyObservers(this.fallBackUrl);
    }
 
    /** GETTER
     * Specifies the HTTP method used to request the required FallbackUrl once call connects.
     */
    @JsonGetter("FallBackMethod")
    public HttpActionEnum getFallBackMethod ( ) { 
        return this.fallBackMethod;
    }
    
    /** SETTER
     * Specifies the HTTP method used to request the required FallbackUrl once call connects.
     */
    @JsonSetter("FallBackMethod")
    public void setFallBackMethod (HttpActionEnum value) { 
        this.fallBackMethod = value;
        notifyObservers(this.fallBackMethod);
    }
 
    /** GETTER
     * URL that can be requested every 60 seconds during the call to notify of elapsed tim
     */
    @JsonGetter("HeartBeatUrl")
    public String getHeartBeatUrl ( ) { 
        return this.heartBeatUrl;
    }
    
    /** SETTER
     * URL that can be requested every 60 seconds during the call to notify of elapsed tim
     */
    @JsonSetter("HeartBeatUrl")
    public void setHeartBeatUrl (String value) { 
        this.heartBeatUrl = value;
        notifyObservers(this.heartBeatUrl);
    }
 
    /** GETTER
     * Specifies the HTTP method used to request HeartbeatUrl.
     */
    @JsonGetter("HeartBeatMethod")
    public HttpActionEnum getHeartBeatMethod ( ) { 
        return this.heartBeatMethod;
    }
    
    /** SETTER
     * Specifies the HTTP method used to request HeartbeatUrl.
     */
    @JsonSetter("HeartBeatMethod")
    public void setHeartBeatMethod (HttpActionEnum value) { 
        this.heartBeatMethod = value;
        notifyObservers(this.heartBeatMethod);
    }
 
    /** GETTER
     * Time (in seconds) Message360 should wait while the call is ringing before canceling the call
     */
    @JsonGetter("Timeout")
    public Integer getTimeout ( ) { 
        return this.timeout;
    }
    
    /** SETTER
     * Time (in seconds) Message360 should wait while the call is ringing before canceling the call
     */
    @JsonSetter("Timeout")
    public void setTimeout (Integer value) { 
        this.timeout = value;
        notifyObservers(this.timeout);
    }
 
    /** GETTER
     * DTMF Digits to play to the call once it connects. 0-9, #, or *
     */
    @JsonGetter("PlayDtmf")
    public String getPlayDtmf ( ) { 
        return this.playDtmf;
    }
    
    /** SETTER
     * DTMF Digits to play to the call once it connects. 0-9, #, or *
     */
    @JsonSetter("PlayDtmf")
    public void setPlayDtmf (String value) { 
        this.playDtmf = value;
        notifyObservers(this.playDtmf);
    }
 
    /** GETTER
     * Specifies if the caller id will be hidden
     */
    @JsonGetter("HideCallerId")
    public String getHideCallerId ( ) { 
        return this.hideCallerId;
    }
    
    /** SETTER
     * Specifies if the caller id will be hidden
     */
    @JsonSetter("HideCallerId")
    public void setHideCallerId (String value) { 
        this.hideCallerId = value;
        notifyObservers(this.hideCallerId);
    }
 
    /** GETTER
     * Specifies if the call should be recorded
     */
    @JsonGetter("Record")
    public Boolean getRecord ( ) { 
        return this.record;
    }
    
    /** SETTER
     * Specifies if the call should be recorded
     */
    @JsonSetter("Record")
    public void setRecord (Boolean value) { 
        this.record = value;
        notifyObservers(this.record);
    }
 
    /** GETTER
     * Recording parameters will be sent here upon completion
     */
    @JsonGetter("RecordCallBackUrl")
    public String getRecordCallBackUrl ( ) { 
        return this.recordCallBackUrl;
    }
    
    /** SETTER
     * Recording parameters will be sent here upon completion
     */
    @JsonSetter("RecordCallBackUrl")
    public void setRecordCallBackUrl (String value) { 
        this.recordCallBackUrl = value;
        notifyObservers(this.recordCallBackUrl);
    }
 
    /** GETTER
     * Method used to request the RecordCallback URL.
     */
    @JsonGetter("RecordCallBackMethod")
    public HttpActionEnum getRecordCallBackMethod ( ) { 
        return this.recordCallBackMethod;
    }
    
    /** SETTER
     * Method used to request the RecordCallback URL.
     */
    @JsonSetter("RecordCallBackMethod")
    public void setRecordCallBackMethod (HttpActionEnum value) { 
        this.recordCallBackMethod = value;
        notifyObservers(this.recordCallBackMethod);
    }
 
    /** GETTER
     * Specifies if the call recording should be transcribed
     */
    @JsonGetter("Transcribe")
    public Boolean getTranscribe ( ) { 
        return this.transcribe;
    }
    
    /** SETTER
     * Specifies if the call recording should be transcribed
     */
    @JsonSetter("Transcribe")
    public void setTranscribe (Boolean value) { 
        this.transcribe = value;
        notifyObservers(this.transcribe);
    }
 
    /** GETTER
     * Transcription parameters will be sent here upon completion
     */
    @JsonGetter("TranscribeCallBackUrl")
    public String getTranscribeCallBackUrl ( ) { 
        return this.transcribeCallBackUrl;
    }
    
    /** SETTER
     * Transcription parameters will be sent here upon completion
     */
    @JsonSetter("TranscribeCallBackUrl")
    public void setTranscribeCallBackUrl (String value) { 
        this.transcribeCallBackUrl = value;
        notifyObservers(this.transcribeCallBackUrl);
    }
 
}
 
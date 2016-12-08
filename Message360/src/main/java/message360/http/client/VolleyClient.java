/*
 * Message360
 *
 * This file was automatically generated for message360 by APIMATIC v2.0 ( https://apimatic.io ) on 12/08/2016
 */
package message360.http.client;

import android.util.Base64;

import message360.Configuration;
import message360.http.request.HttpBodyRequest;
import message360.http.request.HttpMethod;
import message360.http.request.HttpRequest;
import message360.http.response.HttpResponse;
import message360.http.response.HttpStringResponse;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class VolleyClient implements HttpClient {
    /**
     * Private variables to implement singleton pattern
     */
    private static Object synRoot = new Object();
    private static HttpClient sharedInstance = null;
    private long timeout = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS;

    /**
     * Singleton access to the shared instance
     * @return A shared instance of VolleyClient
     */
    public static HttpClient getSharedInstance() {
        synchronized (synRoot) {
            if(sharedInstance == null) {
                sharedInstance = new VolleyClient();
            }
            return sharedInstance;
        }
    }

     /**
     * Sets a timeout for HTTP requests globally
     * @param   timeout    The timeout in seconds
     */
    public void setTimeout(long timeout)
    {
        this.timeout = timeout;
    }

    /**
     * Sets a timeout for specific HTTP request and enqueues the request
     * @param   volleyRequest    The volley request object
     */
    private void enqueueRequest(VolleyHttpRequest volleyRequest)
    {
        //sets timeout for request
        volleyRequest.setRetryPolicy(new DefaultRetryPolicy((int)timeout,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));  
        // Retrieve the RequestQueue.
        com.android.volley.RequestQueue queue = Configuration.getRequestQueue();
        //enque request
        queue.add(volleyRequest);
    }

    /**
     * Execute a given HttpRequest to get string response back
     * @param   request     The given HttpRequest to execute
     * @param   callBack    Async callback for events
     */
    public void executeAsStringAsync(final HttpRequest request, final APICallBack<HttpResponse> callBack) {
        //prepare request
        VolleyHttpRequest<String> volleyRequest = new VolleyHttpRequest<String>(request, callBack, String.class,
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(com.android.volley.VolleyError error) {
                        HttpResponse response = null;
                        // Build response from error
                        if(error.networkResponse!=null)
                        {
                            response = new HttpResponse(
                                error.networkResponse.statusCode,
                                error.networkResponse.headers,
                                new ByteArrayInputStream(error.networkResponse.data));
                        }

                        callBack.onFailure(new HttpContext(request, response), error);
                    }
                });
        enqueueRequest(volleyRequest);
    }

    /**
     * Execute a given HttpRequest to get binary response back
     * @param   request     The given HttpRequest to execute
     * @param   callBack    Async callback for events
     */
    public void executeAsBinaryAsync(final HttpRequest request, final APICallBack<HttpResponse> callBack) {
        //prepare request
        VolleyHttpRequest<InputStream> volleyRequest = new VolleyHttpRequest<InputStream>(request, callBack, InputStream.class,
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(com.android.volley.VolleyError error) {
                        // Handle error
                        callBack.onFailure(new HttpContext(request, null), error);
                    }
                });
        enqueueRequest(volleyRequest);
    }

    /**
     * Converts a given internal http method enumeration into unirest http method unirest
     * @param   method      The given http method enum in internal format
     * @return              The converted unirest http method enum
     */
    protected static int convertHttpMetod(HttpMethod  method)
    {
        switch (method) {
            case POST:
                return com.android.volley.Request.Method.POST;

            case PATCH:
                return com.android.volley.Request.Method.PATCH;

            case PUT:
                return com.android.volley.Request.Method.PUT;

            case DELETE:
                return com.android.volley.Request.Method.DELETE;

            default:
                return com.android.volley.Request.Method.GET;
        }
    }

    /**
     * Create a simple HTTP GET request with basic authentication
     */
    public HttpRequest get(String _queryUrl,
                           Map<String, String> _headers, Map<String, Object> _parameters,
                           String _username, String _password) {
        return new HttpRequest(HttpMethod.GET, _queryUrl, _headers, _parameters, _username, _password);
    }

    /**
     * Create a simple HTTP GET request
     */
    public HttpRequest get(String _queryUrl,
                           Map<String, String> _headers, Map<String, Object> _parameters) {
        return new HttpRequest(HttpMethod.GET, _queryUrl, _headers, _parameters);
    }

    /**
     * Create an HTTP POST request with parameters
     */
    public HttpRequest post(String _queryUrl,
                            Map<String, String> _headers, Map<String, Object> _parameters) {
        return new HttpRequest(HttpMethod.POST, _queryUrl, _headers, _parameters);
    }

    /**
     * Create an HTTP POST request with parameters and with basic authentication
     */
    public HttpRequest post(String _queryUrl,
                            Map<String, String> _headers, Map<String, Object> _parameters,
                            String _username, String _password) {
        return new HttpRequest(HttpMethod.POST, _queryUrl, _headers, _parameters, _username, _password);
    }

    /**
     * Create an HTTP POST request with body
     */
    public HttpBodyRequest postBody(String _queryUrl,
                                    Map<String, String> _headers, String _body) {
        return new HttpBodyRequest(HttpMethod.POST, _queryUrl, _headers, _body);
    }

    /**
     * Create an HTTP POST request with body and with basic authentication
     */
    public HttpBodyRequest postBody(String _queryUrl,
                                    Map<String, String> _headers, String _body,
                                    String _username, String _password) {
        return new HttpBodyRequest(HttpMethod.POST, _queryUrl, _headers, _body, _username, _password);
    }

    /**
     * Create an HTTP PUT request with parameters
     */
    public HttpRequest put(String _queryUrl,
                           Map<String, String> _headers, Map<String, Object> _parameters) {
        return new HttpRequest(HttpMethod.PUT, _queryUrl, _headers, _parameters);
    }

    /**
     * Create an HTTP PUT request with parameters and with basic authentication
     */
    public HttpRequest put(String _queryUrl,
                           Map<String, String> _headers, Map<String, Object> _parameters,
                           String _username, String _password) {
        return new HttpRequest(HttpMethod.PUT, _queryUrl, _headers, _parameters, _username, _password);
    }

    /**
     * Create an HTTP PUT request with body
     */
    public HttpBodyRequest putBody(String _queryUrl,
                                   Map<String, String> _headers, String _body) {
        return new HttpBodyRequest(HttpMethod.PUT, _queryUrl, _headers, _body);
    }

    /**
     * Create an HTTP PUT request with body and with basic authentication
     */
    public HttpBodyRequest putBody(String _queryUrl,
                                   Map<String, String> _headers, String _body,
                                   String _username, String _password) {
        return new HttpBodyRequest(HttpMethod.PUT, _queryUrl, _headers, _body, _username, _password);
    }

    /**
     * Create an HTTP PATCH request with parameters
     */
    public HttpRequest patch(String _queryUrl,
                             Map<String, String> _headers, Map<String, Object> _parameters) {
        return new HttpRequest(HttpMethod.PATCH, _queryUrl, _headers, _parameters);
    }

    /**
     * Create an HTTP PATCH request with parameters and with basic authentication
     */
    public HttpRequest patch(String _queryUrl,
                             Map<String, String> _headers, Map<String, Object> _parameters,
                             String _username, String _password) {
        return new HttpRequest(HttpMethod.PATCH, _queryUrl, _headers, _parameters, _username, _password);
    }

    /**
     * Create an HTTP PATCH request with body
     */
    public HttpBodyRequest patchBody(String _queryUrl,
                                     Map<String, String> _headers, String _body) {
        return new HttpBodyRequest(HttpMethod.PATCH, _queryUrl, _headers, _body);
    }

    /**
     * Create an HTTP PATCH request with body and with basic authentication
     */
    public HttpBodyRequest patchBody(String _queryUrl,
                                     Map<String, String> _headers, String _body,
                                     String _username, String _password) {
        return new HttpBodyRequest(HttpMethod.PATCH, _queryUrl, _headers, _body, _username, _password);
    }

    /**
     * Create an HTTP DELETE request with parameters
     */
    public HttpRequest delete(String _queryUrl,
                              Map<String, String> _headers, Map<String, Object> _parameters) {
        return new HttpRequest(HttpMethod.DELETE, _queryUrl, _headers, _parameters);
    }

    /**
     * Create an HTTP DELETE request with parameters and with basic authentication
     */
    public HttpRequest delete(String _queryUrl,
                              Map<String, String> _headers, Map<String, Object> _parameters,
                              String _username, String _password) {
        return new HttpRequest(HttpMethod.DELETE, _queryUrl, _headers, _parameters, _username, _password);
    }

    /**
     * Create an HTTP DELETE request with body
     */
    public HttpBodyRequest deleteBody(String _queryUrl,
                                      Map<String, String> _headers, String _body) {
        return new HttpBodyRequest(HttpMethod.DELETE, _queryUrl, _headers, _body);
    }

    /**
     * Create an HTTP DELETE request with body and with basic authentication
     */
    public HttpBodyRequest deleteBody(String _queryUrl,
                                      Map<String, String> _headers, String _body,
                                      String _username, String _password) {
        return new HttpBodyRequest(HttpMethod.DELETE, _queryUrl, _headers, _body, _username, _password);
    }

    public class VolleyHttpRequest<T> extends com.android.volley.Request<T> {
        private HttpRequest _request;
        private HttpResponse _response;
        private APICallBack<HttpResponse> _callBack;
        private com.android.volley.Response.ErrorListener _errorListener;
        private Class<T> _responseClass;
        private boolean _isMultipart = false;
        private HttpEntity _multipartEntity = null;

        /**
         *
         * @param request
         * @param callBack
         * @param responseClass
         * @param errorListener
         */
        public VolleyHttpRequest(HttpRequest request,
                                 APICallBack<HttpResponse> callBack,
                                 Class<T> responseClass,
                                 com.android.volley.Response.ErrorListener errorListener) {
            super(convertHttpMetod(request.getHttpMethod()),
                    request.getQueryUrl(),
                    errorListener);
            _request = request;
            _callBack = callBack;
            _errorListener = errorListener;

            //the class type reference for deserialization
            _responseClass = responseClass;
            _isMultipart = isMultipart();
        }

        /**
         * Returns request headers
         * @return
         * @throws AuthFailureError
         */
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            HashMap<String, String> headers = (HashMap<String, String>) _request.getHeaders();

            // Add basic auth header if username,password is provided in request
            if(_request.getUsername() != null && _request.getPassword() != null) {
                String credentials = _request.getUsername() + ":" + _request.getPassword();
                String auth = "Basic "
                        + Base64.encodeToString(credentials.getBytes(),
                        Base64.NO_WRAP);
                headers.put("Authorization", auth);
            }

            return headers;
        }

        /**
         * Returns the raw POST or PUT body to be sent.
         *
         * @throws AuthFailureError in the event of auth failure
         */
        @Override
        public byte[] getBody() throws AuthFailureError {
            if(_request instanceof HttpBodyRequest) {
                String body = ((HttpBodyRequest) _request).getBody();
                if((body == null) || (body.isEmpty())){
                    return "".getBytes();
                }
                return body.getBytes();
            } else {
                Map<String, Object> params = _request.getParameters();
                if (params != null && params.size() > 0) {
                    if (_isMultipart) {
                        return encodeMultipartData(params);
                    } else {
                        return encodeParameters(params, getParamsEncoding());
                    }
                }
            }
            return null;
        }

        /**
         * Inform the server about out content type
         * @return
         */
        @Override
        public String getBodyContentType() {
            if(_request instanceof HttpBodyRequest) {
                return "application/json; charset=UTF-8";
            } else if(_isMultipart) {
                return _multipartEntity.getContentType().getValue();
            } else {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }
        }

        /**
         * Encodes given parameters and files as a multipart file request
         * @param params
         * @return
         */
        private byte[] encodeMultipartData(Map<String, Object> params) {
            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
            //iterate and prepare multipart body
            for (Map.Entry<String, Object> pair : params.entrySet()) {
                String key = pair.getKey();
                Object value = pair.getValue();
                if(pair.getValue() instanceof File) {
                    File file = (File) value;
                    //skip file if not foud
                    if(file.exists()) {
                        entityBuilder.addBinaryBody(key, (File) value);
                    }
                } else {
                    entityBuilder.addTextBody(key, value.toString());
                }
            }
            //build entity
            _multipartEntity = entityBuilder.build();

            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream((int)_multipartEntity.getContentLength());
                _multipartEntity.writeTo(out);
                return out.toByteArray();
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException("Could not create multipart request: " + ex.getMessage());
            }
        }

        /**
         * Check if any of the parameters is a file. If yes, this is a multipart request
         * @return
         */
        private boolean isMultipart() {
            Map<String, Object> params = _request.getParameters();
            if(params != null) {
                for (Map.Entry<String, Object> pair : params.entrySet()) {
                    if (pair.getValue() instanceof File) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Converts <code>params</code> into an application/x-www-form-urlencoded encoded string.
         */
        private byte[] encodeParameters(Map<String, Object> params, String paramsEncoding) {
            StringBuilder encodedParams = new StringBuilder();
            try {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    encodedParams.append(URLEncoder.encode(entry.getKey(), paramsEncoding));
                    encodedParams.append('=');
                    encodedParams.append(URLEncoder.encode(entry.getValue().toString(), paramsEncoding));
                    encodedParams.append('&');
                }
                return encodedParams.toString().getBytes(paramsEncoding);
            } catch (UnsupportedEncodingException uee) {
                throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
            }
        }

        /**
         * Parse the response
         * @param response
         * @return
         */
        @Override
        protected com.android.volley.Response<T> parseNetworkResponse(com.android.volley.NetworkResponse response) {
            InputStream memStream = new java.io.ByteArrayInputStream(response.data);

            com.android.volley.Response<T> parsedResponse;

            if (String.class.equals(_responseClass)) {
                try {
                    String data = new String(response.data, com.android.volley.toolbox.HttpHeaderParser.parseCharset(response.headers));
                    _response = new HttpStringResponse(response.statusCode, response.headers, memStream, data);
                    parsedResponse = (com.android.volley.Response<T>) com.android.volley.Response.success(data, null);
                }
                catch (UnsupportedEncodingException e) {
                    parsedResponse = (com.android.volley.Response<T>) com.android.volley.Response.error(
                            new com.android.volley.VolleyError("Error parsing string from the given data and encoding"));
                }

            } else if (InputStream.class.equals(_responseClass)) {
                _response = new HttpResponse(response.statusCode, response.headers, memStream);
                parsedResponse = (com.android.volley.Response<T>) com.android.volley.Response.success(memStream, null);
            } else {
                parsedResponse = (com.android.volley.Response<T>) com.android.volley.Response.error(
                        new com.android.volley.VolleyError("Unknown result type. Only String and InputStream are supported."));
            }

            return  parsedResponse;
        }

        /**
         *
         * @param response
         */
        @Override
        protected void deliverResponse(T response) {
            _callBack.onSuccess(new HttpContext(_request, _response), _response);
        }
    }
}

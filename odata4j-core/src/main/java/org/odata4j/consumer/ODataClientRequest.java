package org.odata4j.consumer;

import java.util.HashMap;
import org.odata4j.core.OClientBehavior;
import java.util.Map;

import org.odata4j.format.Entry;

/**
 * Generic OData http request builder.  Only interesting for developers of custom {@link OClientBehavior} implementations.
 */
public class ODataClientRequest {

  private final String method;
  private final String url;
  private final Map<String, String> headers;
  private final Map<String, String> queryParams;
  private final Entry entry;

  private ODataClientRequest(String method, String url, Map<String, String> headers, Map<String, String> queryParams, Entry entry) {
    this.method = method;
    this.url = url;
    this.headers = headers == null ? new HashMap<String, String>() : headers;
    this.queryParams = queryParams == null ? new HashMap<String, String>() : queryParams;
    this.entry = entry;
  }

  /**
   * Gets the request http method.
   * 
   * @return the http method
   */
  public String getMethod() {
    return method;
  }

  /**
   * Gets the request url.
   * 
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the request http headers.
   * 
   * @return the headers
   */
  public Map<String, String> getHeaders() {
    return headers;
  }

  /**
   * Gets the request query parameters.
   * 
   * @return the query parameters
   */
  public Map<String, String> getQueryParams() {
    return queryParams;
  }

  /**
   * Gets the normalized OData payload.
   * 
   * @return the normalized OData payload
   */
  public Entry getEntry() {
    return entry;
  }

  /**
   * Creates a new GET request.
   * 
   * @param url  the request url
   * @return a new request builder
   */
  public static ODataClientRequest get(String url) {
    return new ODataClientRequest("GET", url, null, null, null);
  }

  /**
   * Creates a new POST request.
   * 
   * @param url  the request url
   * @param entry  the normalized OData payload
   * @return a new request builder
   */
  public static ODataClientRequest post(String url, Entry entry) {
    return new ODataClientRequest("POST", url, null, null, entry);
  }

  /**
   * Creates a new PUT request.
   * 
   * @param url  the request url
   * @param entry  the normalized OData payload
   * @return a new request builder
   */
  public static ODataClientRequest put(String url, Entry entry) {
    return new ODataClientRequest("PUT", url, null, null, entry);
  }

  /**
   * Creates a new MERGE request.
   * 
   * @param url  the request url
   * @param entry  the normalized OData payload
   * @return a new request builder
   */
  public static ODataClientRequest merge(String url, Entry entry) {
    return new ODataClientRequest("MERGE", url, null, null, entry);
  }

  /**
   * Creates a new DELETE request.
   * 
   * @param url  the request url
   * @return a new request builder
   */
  public static ODataClientRequest delete(String url) {
    return new ODataClientRequest("DELETE", url, null, null, null);
  }

  /**
   * Sets an http request header.
   * 
   * @param name  the header name
   * @param value  the header value
   * @return the request builder
   */
  public ODataClientRequest header(String name, String value) {
    headers.put(name, value);
    return new ODataClientRequest(method, url, headers, queryParams, entry);
  }

  /**
   * Sets a request query parameter.
   * 
   * @param name  the query parameter name
   * @param value  the query parameter value
   * @return the request builder
   */
  public ODataClientRequest queryParam(String name, String value) {
    queryParams.put(name, value);
    return new ODataClientRequest(method, url, headers, queryParams, entry);
  }

  /**
   * Sets the request url.
   * 
   * @param url  the request url
   * @return the request builder
   */
  public ODataClientRequest url(String url) {
    return new ODataClientRequest(method, url, headers, queryParams, entry);
  }

  /**
   * Sets the http request method.
   * 
   * @param method  the method
   * @return the request builder
   */
  public ODataClientRequest method(String method) {
    return new ODataClientRequest(method, url, headers, queryParams, entry);
  }

  /**
   * Sets the normalized OData payload.
   * 
   * @param entry  the payload
   * @return the request builder
   */
  public ODataClientRequest entry(Entry entry) {
    return new ODataClientRequest(method, url, headers, queryParams, entry);
  }

}

/*
 * Kripo API
 * API to interact with Kripo fragment, fingerprint and similarity data files.
 *
 * OpenAPI spec version: 2.2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package nl.esciencecenter.e3dchem.kripodb.ws.client;

import nl.esciencecenter.e3dchem.kripodb.ws.client.ApiCallback;
import nl.esciencecenter.e3dchem.kripodb.ws.client.ApiClient;
import nl.esciencecenter.e3dchem.kripodb.ws.client.ApiException;
import nl.esciencecenter.e3dchem.kripodb.ws.client.ApiResponse;
import nl.esciencecenter.e3dchem.kripodb.ws.client.Configuration;
import nl.esciencecenter.e3dchem.kripodb.ws.client.Pair;
import nl.esciencecenter.e3dchem.kripodb.ws.client.ProgressRequestBody;
import nl.esciencecenter.e3dchem.kripodb.ws.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import nl.esciencecenter.e3dchem.kripodb.ws.client.model.Error;
import nl.esciencecenter.e3dchem.kripodb.ws.client.model.Version;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VersionApi {
    private ApiClient apiClient;

    public VersionApi() {
        this(Configuration.getDefaultApiClient());
    }

    public VersionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for getVersion */
    private com.squareup.okhttp.Call getVersionCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/version".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/problem+json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getVersionValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = getVersionCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Version of webservice
     * 
     * @return Version
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Version getVersion() throws ApiException {
        ApiResponse<Version> resp = getVersionWithHttpInfo();
        return resp.getData();
    }

    /**
     * Version of webservice
     * 
     * @return ApiResponse&lt;Version&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Version> getVersionWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = getVersionValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<Version>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Version of webservice (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getVersionAsync(final ApiCallback<Version> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getVersionValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Version>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}

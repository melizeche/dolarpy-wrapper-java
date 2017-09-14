/*
 * Copyright 2017 Marcelo Elizeche Landó [melizeche@gmail.com].
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.melizeche.dolarpy.services;

import com.melizeche.dolarpy.settings.Settings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.UnknownHostException;
import java.net.URL;

/**
 *
 * @author Marcelo Elizeche Landó [melizeche@gmail.com]
 */
public class FetchService {

    private URL url;
    private HttpURLConnection connection;

    private final int connectionTimeout = Settings.CONNECTION_TIMEOUT;
    
 
    
    public String executeGetRequest() {
        String response = null;

        try {
            response = sendGetRequest();
        } catch (IOException | BadResponseCodeException e) {
            e.printStackTrace();
        }
        return response;
    }

    private String sendGetRequest() throws IOException, BadResponseCodeException {
        prepareURL(Settings.URL);
        prepareAndOpenConnection();
        setRequestProperties();

        return processResponse();
    }

    private void prepareURL(final String urlString) throws MalformedURLException {
        url = new URL(urlString);
    }

    private void prepareAndOpenConnection() throws IOException {
        connection = (HttpURLConnection) url.openConnection();
    }

    private void setRequestProperties() throws ProtocolException {
        connection.setConnectTimeout(connectionTimeout);
        connection.setRequestMethod(Settings.REQUEST_TYPE);
        connection.setRequestProperty(Settings.REQUEST_HEADER_USER_AGENT, Settings.USER_AGENT);
    }

    private String processResponse() throws IOException, BadResponseCodeException {
        int responseCode = connection.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new BadResponseCodeException(String.valueOf(responseCode));
        }

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String output;
        StringBuilder response = new StringBuilder();

        while ((output = bufferedReader.readLine()) != null) {
            response.append(output);
        }

        bufferedReader.close();

        return response.toString();
    }
}

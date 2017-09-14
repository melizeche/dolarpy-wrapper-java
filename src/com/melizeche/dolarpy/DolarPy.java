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
package com.melizeche.dolarpy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.melizeche.dolarpy.core.Provider;
import com.melizeche.dolarpy.services.FetchService;
import com.melizeche.dolarpy.settings.Settings;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Marcelo Elizeche Landó [melizeche@gmail.com]
 */
public class DolarPy {

    private final FetchService httpservice = new FetchService();

    /**
     * Returns the raw content of the DolarPy API
     *
     * @return String
     */
    public String getRaw() {
        return httpservice.executeGetRequest();
    }

    private HashMap prepareObject() {
        String dump = getRaw();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Type type = new TypeToken<HashMap<String, Object>>() {
        }.getType();
        HashMap<String, Object> myMap = gson.fromJson(dump, type);
        return myMap;

    }

    /**
     * Get list of available providers in a ArrayList of String
     *
     * @return ArrayList
     */
    public ArrayList<String> getProvidersList() {
        HashMap map = buildProviders();
        ArrayList<String> providers = new ArrayList<>();
        map.forEach((k, v) -> providers.add(k.toString()));
        return providers;
    }

    private Provider buildProvider(String provider) {
        HashMap map = buildProviders();

        return (Provider) map.get(provider);
    }

    private HashMap buildProviders() {
        HashMap map = prepareObject();
        HashMap<String, Object> providers = new HashMap<>();
        Map all = (Map) map.get("dolarpy");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime updated = LocalDateTime.parse((CharSequence) map.get("updated"), fmt);
        Iterator it = all.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            providers.put(entry.getKey().toString(), entry.getValue());

        }
        List<Provider> providerList = new ArrayList<>();
        Map<String, Provider> pmap = new HashMap<>();
        providers.forEach((k, v) -> {
            String name = k;
            Map single = (Map) v;
            BigDecimal compra = BigDecimal.valueOf((Double) single.get("compra"));
            BigDecimal venta = BigDecimal.valueOf((Double) single.get("venta"));
            Provider providerResponse = new Provider();
            providerResponse.setName(name);
            providerResponse.setCompra(compra);
            providerResponse.setVenta(venta);
            providerResponse.setUpdated(updated);
            providerList.add(providerResponse);
            pmap.put(k, providerResponse);
        });

        return (HashMap) pmap;

    }

    /**
     * Returns a Provider object
     *
     * @param provider Name of the provider to get, if none is given it will use
     * the default provider
     * @return Provider Object
     */
    public Provider get(String provider) {
        return buildProvider(provider);
    }

    public Provider get() {
        return buildProvider(Settings.DEFAULT_PROVIDER);
    }

    /**
     * Returns Hashmap of all providers
     *
     * @return HashMap
     */
    public HashMap<String, Provider> getAll() {
        return buildProviders();
    }

    /**
     * Returns the buy value of selected provider, if none is given it will use
     * the default provider
     *
     * @param provider
     * @return BigDecimal
     */
    public BigDecimal getCompra(String provider) {
        Provider p = get(provider);
        return p.getCompra();
    }

    public BigDecimal getCompra() {
        Provider p = get(Settings.DEFAULT_PROVIDER);
        return p.getCompra();
    }

    /**
     * Returns the sell value of selected provider, if none is given it will use
     * the default provider
     *
     * @param provider
     * @return BigDecimal
     */
    public BigDecimal getVenta(String provider) {
        Provider p = get(provider);
        return p.getVenta();
    }

    public BigDecimal getVenta() {
        Provider p = get(Settings.DEFAULT_PROVIDER);
        return p.getVenta();
    }
}

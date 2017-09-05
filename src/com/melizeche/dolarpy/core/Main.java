/*
 * Copyright 2017 Marcelo Elizeche Landó <melizeche@gmail.com>.
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
package com.melizeche.dolarpy.core;

import com.melizeche.dolarpy.services.FetchService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Marcelo Elizeche Landó <melizeche@gmail.com>
 */
public class Main {

    private FetchService httpservice = new FetchService();

    //private Gson gson = new GsonB
    public String getRaw() {
        return httpservice.executeGetRequest();
    }

    public HashMap prepareObject() {
        String dump = getRaw();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Type type = new TypeToken<HashMap<String, Object>>() {
        }.getType();
        HashMap<String, Object> myMap = gson.fromJson(dump, type);
        System.out.println(myMap);
        System.out.println(myMap.keySet());
        System.out.println(myMap.values());
        System.out.println(myMap.get("updated"));
        System.out.println(myMap.get("dolarpy"));
        Map t = (Map) myMap.get("dolarpy");
        Map tt = (Map) t.get("amambay");
        System.out.println((Map) t.get("amambay"));
        System.out.println(t.keySet());
        System.out.println(tt.get("compra"));
        //ApiRoot root = gson.fromJson(dump, ApiRoot.class);
        //System.out.println(root.getUpdated());
        //System.out.println(root.getDolarpy());
        //Dolarpy d = root.getDolarpy();
        //Provider p = d.getProviders();
        //System.out.println(p.getCompra());
        //Provider p = d.getProviders().get(1);
        //ArrayList si = d.getProviders();
        //System.out.println(String.valueOf(si));
        return myMap;

    }

    public ArrayList<String> getProviders() {
        HashMap map = prepareObject();
        Map t = (Map) map.get("dolarpy");
        System.out.println(Arrays.toString(t.keySet().toArray()));
        ArrayList<String> providers = new ArrayList<>();
        t.forEach((k, v) -> providers.add(k.toString()));
        return providers;
    }

}

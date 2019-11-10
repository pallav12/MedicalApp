package com.alonemusk.medicalapp.classes;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParsing {

    public static ArrayList<JSONObject> parsejson(String str) {
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();

        JSONArray arr = null;
        try {
            arr = new JSONArray(str);


            for (int i = 0; i < arr.length(); i++) {

                JSONObject obj = null;

                obj = arr.getJSONObject(i);


                list.add(obj);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        Gson gson = new Gson();
        Log.d("something", list.get(0).toString());

        MedicineNameId object = gson.fromJson(String.valueOf(list.get(0)), MedicineNameId.class);

        Log.d("something", object.toString());

        return list;
    }
}

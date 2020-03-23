package com.example.timetable.utils;

import android.util.Log;

import com.example.timetable.data.Occupation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONUtils {

    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_PLACE = "place";
    private static final String KEY_TEACHER = "teacher";
    private static final String KEY_START_TIME = "startTime";
    private static final String KEY_END_TIME = "endTime";
    private static final String KEY_WEEK_DAY = "weekDay";

    public static ArrayList<Occupation> getOccupationFromJSON(JSONArray jsonArray){
        ArrayList<Occupation> result = new ArrayList<>();
        if (jsonArray == null)
            return result;
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject objectOccupation = jsonArray.getJSONObject(i);
                String name = objectOccupation.getString(KEY_NAME);
                String description = objectOccupation.getString(KEY_DESCRIPTION);
                String place = objectOccupation.getString(KEY_PLACE);
                String teacher = objectOccupation.getString(KEY_TEACHER);
                String startTime = objectOccupation.getString(KEY_START_TIME);
                String endTime = objectOccupation.getString(KEY_END_TIME);
                int weekDay = objectOccupation.getInt(KEY_WEEK_DAY);
                result.add(new Occupation(name,startTime, endTime, teacher, place, description, weekDay));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

}

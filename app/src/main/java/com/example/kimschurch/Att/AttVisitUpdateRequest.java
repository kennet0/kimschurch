package com.example.kimschurch.Att;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AttVisitUpdateRequest extends StringRequest {

    final static private String URL = "http://112.186.116.16:6011/KimsChurch/AttVisitUpdate.php";
    private Map<String, String>  parameters;

    public AttVisitUpdateRequest(String pnum, String name, String date, String att5a, String att5b, String att5c, String att_etc, Response.Listener<String> listener) {

        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("pnum", pnum);
        parameters.put("name", name);
        parameters.put("date", date);
        parameters.put("att5a", att5a);
        parameters.put("att5b", att5b);
        parameters.put("att5c", att5c);
        parameters.put("att_etc", att_etc);
    }

    @Override
    public Map<String,String> getParams(){
        return parameters;
    }

}
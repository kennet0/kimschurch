package com.example.kimschurch.Register;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.kimschurch.Util.Etc;

import java.util.HashMap;
import java.util.Map;

public class RemoveRequest extends StringRequest {

    final static private String URL = Etc.URL+"/KimsChurch/Remove.php";
    private Map<String, String>  parameters;

    public RemoveRequest(String pnum,  Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("pnum", pnum);

    }

    @Override
    public Map<String,String> getParams(){
        return parameters;
    }
}

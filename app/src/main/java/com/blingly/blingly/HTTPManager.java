package com.blingly.blingly;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class HTTPManager {
    private final MainActivity mainActivity;

    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectRequest;

    public HTTPManager(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    void makeRequest(String url, Context context) {
        // Create Volley's request queue
        requestQueue = Volley.newRequestQueue(context);

        // Instantiate the RequestQueue.

        // Response listener
        Response.Listener<JSONObject> responseListener = (JSONObject response) -> {
            // Display the first 500 characters of the response string.
            String s = "Response is: ";
            String responseString = response.toString();
        };

        // Response error listener
        Response.ErrorListener errorListener = (VolleyError error) -> Toast.makeText(mainActivity.getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

        // Request a string response from the provided URL.
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, responseListener, errorListener);


        requestQueue.add(jsonObjectRequest);
    }
}
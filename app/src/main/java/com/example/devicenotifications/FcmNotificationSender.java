package com.example.devicenotifications;

import static com.android.volley.Request.*;

import android.media.MediaCodec;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class FcmNotificationSender {

    String userFcmToken;
    String title;
    String body;
    String mContext;
    String mActivity;


    private RequestQueue requestQueue;
    private final String postUrl = "https://fcm.googleapis.com/fcm/send";
    private final String fcmServerKey = "AAAAHoI4fKg:APA91bFVL1D7HN6VL1d4GjfgCf9uOxSbGbgF-g92ARMl346UJQ0r88OnZ3eIc-XMG2zW4m7CEHF40MEGi0q9MfFs_s6lwUuo4BO7FTEuGNCcSLZJuiecS9BOQJIt3H89y1vFVSJl23yx";


    public FcmNotificationSender(String userFcmToken, String title, String body, String mContext, String mActivity) {
        this.userFcmToken = userFcmToken;
        this.title = title;
        this.body = body;
        this.mContext = mContext;
        this.mActivity = mActivity;
    }

    public void SendNotifications() {
//        requestQueue = Volley.newRequestQueue(mActivity);
        JSONObject mainObj = new JSONObject();
        try {
            mainObj.put("to", userFcmToken);
            JSONObject notiObject = new JSONObject();
            notiObject.put("title", title);
            notiObject.put("body", body);
            notiObject.put("icon", "icon"); //enter icon that exists in drawable only

            mainObj.put("notification", notiObject);

            JsonObjectRequest request = new JsonObjectRequest(Method.POST, postUrl, mainObj, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) ;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

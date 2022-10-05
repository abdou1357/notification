/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.notification;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

/**
 *
 * @author abderrahmanecheridi
 */
public class Main {

    public static void main(String[] args) throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://fcm.googleapis.com/fcm/send");
        post.setHeader("Content-type", "application/json");
        post.setHeader("Authorization", "key=AIzaSyA33GDLsSd9lJaqAMNDPG0p1sNl_wCjqC4");

        JSONObject message = new JSONObject();
        message.put("to", "evBusQVRTHehkV-5jk3HE9:APA91bGJ4sg9VEFrkUhUhdfFC-K8zL1QUozDjwkhUEJwW6-2_s3fy04HM3cSCimI7J1gJJdbCm-1q-qSCZV71FTFNGJ7QZnQranf_2lM5VZbiOZ8rb8cvtgDILJdSlpVkA9Qr22va78t");
        message.put("priority", "high");
        

            JSONObject notification = new JSONObject();
            notification.put("title", "Json");
            notification.put("body", "org.json.JSONObject");

            message.put("notification", notification);

            post.setEntity(new StringEntity(message.toString(), "UTF-8"));
            HttpResponse response = client.execute(post);
            System.out.println(response);
            System.out.println(message);
    }

}

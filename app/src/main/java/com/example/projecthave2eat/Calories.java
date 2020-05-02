package com.example.projecthave2eat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
//Crashes when pressing the submit button
//Posts to api but returns "E/response: response :{"error_message":"Error: invalid json","message":"Questions? Reference this errors '_id' on the Nutritionix Forum. https://developer.nutritionix.com/forum","recommendations":"Check your Request Details. You may have incorrectly used some params, or the request was malformed.","req_info":{"_parsedUrl":{"protocol":null,"slashes":null,"auth":null,"host":null,"port":null,"hostname":null,"hash":null,"search":null,"query":null,"pathname":"/v1_1/search","path":"/v1_1/search","href":"/v1_1/search"},"method":"POST","query":{},"remoteAddress":"127.0.0.1","headers":{"x-forwarded-port":"443","user-agent":"Apache-HttpClient/UNAVAILABLE (java 1.4)","x-forwarded-proto":"https","host":"api.nutritionix.com","x-forwarded-for":"136.32.64.125, 10.0.1.142","connection":"close","content-length":"126","content-type":"application/json"},"body":{}},"_id":"5eadb4d319f450cc3b10466a"}"
//Error found when using correct content type header with no json or
public class Calories extends AppCompatActivity {

    Button calorieQuery;
    EditText food;

    String responseServer;

    //Retrive string food from edit text
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        final EditText foodText = (EditText) findViewById(R.id.foodText);
        calorieQuery = (Button) findViewById(R.id.calorieQuery);
        calorieQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food = foodText.getText().toString();
                AsyncT asynct = new AsyncT();
                Toast.makeText(getApplicationContext(), food, Toast.LENGTH_LONG).show();
                asynct.execute(); //crashes on call


            }
        });
    }


    class AsyncT extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("https://api.nutritionix.com/v1_1/search");
            httppost.addHeader("Content-Type","application/json");

            try{
                JSONObject jsonobj = new JSONObject();

                jsonobj.put("appId", "9eaad593");
                jsonobj.put("appKey","ea4972acfa80fdad3f8753efc655b8f5");
                jsonobj.put("query","chocolate");

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("req",jsonobj.toString()));

                Log.e("mainToPost", "mainToPost" + nameValuePairs.toString());

                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                HttpResponse response = httpclient.execute(httppost);
                InputStream inputStream = response.getEntity().getContent();
                InputStreamToStringExample str = new InputStreamToStringExample();
                responseServer = str.getStringFromInputStream(inputStream);

                Log.e("response", "response:" + responseServer);

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            food.setText(responseServer);
        }
    }
    public static class InputStreamToStringExample{
        public static void main(String[] args) throws IOException{

            InputStream is = new ByteArrayInputStream("file".getBytes());
            String result = getStringFromInputStream(is);

            System.out.println(result);
            System.out.println("Done");

        }
        private static String getStringFromInputStream(InputStream is){

            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();

            String line;

            try{
                br = new BufferedReader(new InputStreamReader(is));
                while ((line = br.readLine()) != null){
                    sb.append(line);
                }
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                if (br != null){
                    try{
                        br.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }

            }
            return sb.toString();
        }

    }
}






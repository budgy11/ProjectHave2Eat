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

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


public class Calories extends AppCompatActivity {

    Button calorieQuery;


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
                asynct.execute();
                Toast.makeText(getApplicationContext(), food, Toast.LENGTH_LONG).show();

            }
        });
    }


    class AsyncT extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("https://api.nutritionix.com/v1_1/search");

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

                StringWriter writer = new StringWriter();
                IOUtils.copy(inputStream,writer, encoding);



            }catch (Exception e){
                e.printStackTrace();
            }


            return null;
        }
    }
}





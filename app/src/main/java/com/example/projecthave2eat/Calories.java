package com.example.projecthave2eat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
//Crashes when pressing the submit button
//Posts to api but returns "E/response: response :{"error_message":"Error: invalid json","message":"Questions? Reference this errors '_id' on the Nutritionix Forum. https://developer.nutritionix.com/forum","recommendations":"Check your Request Details. You may have incorrectly used some params, or the request was malformed.","req_info":{"_parsedUrl":{"protocol":null,"slashes":null,"auth":null,"host":null,"port":null,"hostname":null,"hash":null,"search":null,"query":null,"pathname":"/v1_1/search","path":"/v1_1/search","href":"/v1_1/search"},"method":"POST","query":{},"remoteAddress":"127.0.0.1","headers":{"x-forwarded-port":"443","user-agent":"Apache-HttpClient/UNAVAILABLE (java 1.4)","x-forwarded-proto":"https","host":"api.nutritionix.com","x-forwarded-for":"136.32.64.125, 10.0.1.142","connection":"close","content-length":"126","content-type":"application/json"},"body":{}},"_id":"5eadb4d319f450cc3b10466a"}"
//Error found when using correct content type header with no json or


//switching to database method
public class Calories extends AppCompatActivity {

    Button calorieQuery;
    Button addFood;
    EditText food;

    String responseServer;

    //Retrieve string food from edit text
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        final HashMap<String, String> caloriesMap = new HashMap<String, String>();
        caloriesMap.put("Apple","81");
        caloriesMap.put("Apples","81");
        caloriesMap.put("Orange","65");
        caloriesMap.put("Oranges","65");
        caloriesMap.put("Grapes","114");
        caloriesMap.put("Grapes","114");

        final TextView textView = (TextView)findViewById(R.id.calorieView);

        final EditText foodText = (EditText) findViewById(R.id.foodText);
        final EditText foodAdd = (EditText) findViewById(R.id.foodAdd);
        final EditText calorieAdd = (EditText) findViewById(R.id.calorieAdd);

        calorieQuery = (Button) findViewById(R.id.calorieQuery);
        calorieQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food = foodText.getText().toString();
                //AsyncT asynct = new AsyncT();
                //Toast.makeText(getApplicationContext(), caloriesMap.get(food).toString(), Toast.LENGTH_LONG).show();
                textView.setText("One serving of " + food + " has " + caloriesMap.get(food) + " calories");
                //asynct.execute(); //crashes on call



            }
        });
        addFood = (Button)findViewById(R.id.AddFoodFrag);
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AddCalories fragment1 = new AddCalories();
                //getSupportFragmentManager().beginTransaction().add(R.id.container,fragment1).commit();

                String FoodAdd = foodAdd.getText().toString();
                String calAdd = calorieAdd.getText().toString();
                Toast.makeText(getApplicationContext(), FoodAdd + "has been added with " + calAdd + "calories", Toast.LENGTH_LONG).show();

                caloriesMap.put(FoodAdd,calAdd);
            }
        });
    }

/*
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
*/
}







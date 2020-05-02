package com.example.projecthave2eat;
//Using google due to API's for finding resteraunts cost
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        final EditText searchText = (EditText) findViewById(R.id.restSearch);
         Button searchButton= (Button) findViewById(R.id.submitSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchQuery = searchText.getText().toString();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/#q=" + searchQuery +"+\"restaurants\"+near+me")));
                Toast.makeText(getApplicationContext(), searchQuery, Toast.LENGTH_LONG).show();

            }
        });
    }


}


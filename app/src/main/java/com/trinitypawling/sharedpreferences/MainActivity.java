package com.trinitypawling.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    TextView tv;
    TextView hw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.editField);
        hw = findViewById(R.id.hw);
        //get the shared preferences
        sp = this.getPreferences(Context.MODE_PRIVATE);
        Log.i("info",sp.toString());
        //get the value associated with key1
        Log.i("info",sp.getString("key1","test"));

        tv.setText(sp.getString("key1","test"));
        hw.setText(""+sp.getInt("key2",0));
    }
    public void buttonPressed(View v){
        Log.i("info",tv.getText().toString());
        //open the editor
        SharedPreferences.Editor spe = sp.edit();
        //put the string with the key1 key into the editor
        spe.putString("key1",tv.getText().toString());
        int val = Integer.parseInt(hw.getText().toString());
        spe.putInt("key2",++val);
        spe.commit(); //close the editor
    }
}
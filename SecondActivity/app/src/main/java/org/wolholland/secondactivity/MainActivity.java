package org.wolholland.secondactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startSec(View view)
    {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("hello", "This First Activity FROM Hello World");
        startActivity(intent);
    }
}

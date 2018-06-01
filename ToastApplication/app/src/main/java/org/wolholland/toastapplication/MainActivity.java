package org.wolholland.toastapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public  void onClick(View view){
        Toast toast = Toast.makeText(this, "Hello Android 7",Toast.LENGTH_LONG);
        toast.show();
    }
}
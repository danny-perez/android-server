package co.wolholland.secondactivitygetserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void fromFragmentData(String data) {
        //Log.d("Str=",data);
        TextView textView = (TextView)findViewById(R.id.textView5);
        textView.setText(data);
    }
}

package org.wolholland.secondactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("hello").toString();
        setContentView(R.layout.activity_main2);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(""+name);
}
}

package org.wolholland.flowersapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        float textSize = getResources().getDimension(R.dimen.text_size);
        int leftPadding = (int)getResources().getDimension(R.dimen.activity_horizontal_margin);
        int topPadding = (int)getResources().getDimension(R.dimen.activity_vertical_margin);

        TextView textView = new TextView(this);

        textView.setText("Hello Android Nougat!");
        textView.setTextSize(textSize);
        textView.setPadding(leftPadding, topPadding, leftPadding, topPadding);

        setContentView(textView);
    }
}
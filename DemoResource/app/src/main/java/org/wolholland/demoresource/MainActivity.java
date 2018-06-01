package org.wolholland.demoresource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // получение ресурсов из файла values/strings.xml
        String app_name = getResources().getString(R.string.app_name);

        TextView textView = new TextView(this);
        textView.setText(app_name);
        setContentView(R.layout.activity_main);
        //setContentView(textView);
    }
}

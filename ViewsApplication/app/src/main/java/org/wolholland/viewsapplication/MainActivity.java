package org.wolholland.viewsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // устанавливаем в качестве интерфейса файл second_layout.xml
        setContentView(R.layout.second_layout);

        // получаем элемент textView
        TextView textView = (TextView) findViewById(R.id.header);
        // переустанавливаем у него текст
        textView.setText("Hello Android 7!");
    }
}

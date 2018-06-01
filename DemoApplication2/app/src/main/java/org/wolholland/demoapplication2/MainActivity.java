package org.wolholland.demoapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // устанавливаем в качестве интерфейса файл second_layout.xml
        setContentView(R.layout.activity_main);

        // получаем элемент textView
        TextView textView = (TextView) findViewById(R.id.welcome);
        // получаем ресурс
        String message = getResources().getString(R.string.message);
        // переустанавливаем у него текст
        textView.setText(message);
    }
}

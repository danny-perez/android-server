package co.wolholland.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView = (TextView)findViewById(R.id.TextView1);
        System.out.println("Метод запроса: ");
        System.out.println("Метод запроса2: ");
    }
}

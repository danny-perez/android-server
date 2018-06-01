package co.wolholland.innovationkabbi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView browser=(WebView)findViewById(R.id.webBrowser);
        browser.loadUrl("https://www.google.ru/maps");
    }
}

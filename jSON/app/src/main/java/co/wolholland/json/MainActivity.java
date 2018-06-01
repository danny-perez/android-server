package co.wolholland.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void jsonButton(View view) throws IOException {
        TextView textView = (TextView) findViewById(R.id.textView2);
        HttpURLConnection conn = null;
        try {
            Log.i("chat",
                    "+ FoneService --------------- ОТКРОЕМ СОЕДИНЕНИЕ");
            URL url = new URL("http://sys64.pw/index.php");
            conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setDoInput(true);
            conn.connect();
        } catch (Exception e) {
            Log.i("chat", "+ FoneService ошибка: " + e.getMessage());
        } finally {
            conn.disconnect();
            Log.i("chat",
                    "+ FoneService --------------- ЗАКРОЕМ СОЕДИНЕНИЕ");
        }
        /*
        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            //Если запрос выполнен удачно, читаем полученные данные и далее, делаем что-то
            textView.setText("Welcome All Right");
        } else {
            //Если запрос выполнен не удачно, делаем что-то другое
            textView.setText("Fuck in Go");
        }
*/

        //textView.setText("Welcome");
    }
}

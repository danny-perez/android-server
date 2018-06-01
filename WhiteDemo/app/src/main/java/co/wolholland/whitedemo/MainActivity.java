package co.wolholland.whitedemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.BreakIterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

    public class MainActivity  extends AppCompatActivity {
        TextView contentView;
        String contentText = null;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        private class ProgressTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... path) {

                String content;
                try {
                    content = getContent(path[0]);
                } catch (IOException ex) {
                    content = ex.getMessage();
                }

                return content;
            }

            @Override
            protected void onPostExecute(String content) {

                contentText = content;
                contentView.setText(content);
                //Toast.makeText(getActivity(), "Данные загружены", Toast.LENGTH_SHORT)
                //        .show();
            }

            public String getContent(String path) throws IOException {
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://sys64.pw/index.php");
                    HttpURLConnection c = (HttpURLConnection) url.openConnection();
                    c.setRequestMethod("GET");
                    c.setReadTimeout(10000);
                    c.connect();
                    reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder buf = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        buf.append(line + "\n");
                    }
                    return (buf.toString());
                } finally {
                    if (reader != null) {
                        reader.close();
                    }
                }
            }
        }
    }


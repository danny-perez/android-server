package co.wolholland.httpretrofitsamples;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProgressFragment extends Fragment {
    TextView contentView;
    String contentText = null;
    WebView webView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress, container, false);
        contentView = (TextView) view.findViewById(R.id.content);
        webView = (WebView) view.findViewById(R.id.webView);

        // если данные ранее были загружены
        if(contentText!=null){
            contentView.setText(contentText);
            webView.loadData(contentText, "text/html; charset=utf-8", "utf-8");
        }

        Button btnFetch = (Button)view.findViewById(R.id.downloadBtn);
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(contentText==null){
                    contentView.setText("Загрузка...");
                    new ProgressTask().execute("http://sys64.pw/index.php");
                    //new ProgressTask().execute("https://maps.googleapis.com/maps/api/directions/json?origin=55.573721,%2037.566561&destination=55.574037,%2037.590637&key=AIzaSyBe23DtCnNlwWxEvl1K1Z_DF8DL2jy48Pg");
                }
            }
        });
        return view;
    }

    private class ProgressTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... path) {

            String content;
            try{
                content = getContent(path[0]);
            }
            catch (IOException ex){
                content = ex.getMessage();
            }

            return content;
        }
        @Override
        protected void onPostExecute(String content) {

            contentText=content;
            contentView.setText(content);
            webView.loadData(content, "text/html; charset=utf-8", "utf-8");
            Toast.makeText(getActivity(), "Данные загружены", Toast.LENGTH_SHORT)
                    .show();
        }

        private String getContent(String path) throws IOException {
            BufferedReader reader=null;
            try {
                URL url=new URL(path);
                HttpURLConnection c=(HttpURLConnection)url.openConnection();
                c.setRequestMethod("GET");
                c.setReadTimeout(10000);
                c.connect();
                reader= new BufferedReader(new InputStreamReader(c.getInputStream()));
                StringBuilder buf=new StringBuilder();
                String line=null;
                while ((line=reader.readLine()) != null) {
                    buf.append(line + "\n");
                }
                return(buf.toString());
            }
            finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }
    }
}
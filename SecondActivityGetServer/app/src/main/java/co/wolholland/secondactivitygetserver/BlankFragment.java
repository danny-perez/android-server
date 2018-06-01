package co.wolholland.secondactivitygetserver;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class BlankFragment extends Fragment {

    String contentText = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        if(contentText==null){
            //new ProgressTask().execute("https://maps.googleapis.com/maps/api/directions/json?origin=55.573721,%2037.566561&destination=55.574037,%2037.590637&key=AIzaSyBe23DtCnNlwWxEvl1K1Z_DF8DL2jy48Pg");
            new ProgressTask().execute("http://sys64.pw/index99.php");
        }
        return view;
    }
    private class ProgressTask extends AsyncTask<String, Void, String> {
        private String result;
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

            Activity activity = getActivity();
            if (activity != null && !activity.isFinishing() && activity instanceof MainActivity) {
                ((MainActivity) activity).fromFragmentData(content);
            }
        }

        private String getContent(String path) throws IOException {
            BufferedReader reader=null;
            try {
                URL url=new URL(path);
//                HttpsURLConnection c=(HttpsURLConnection)url.openConnection();
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

package co.wolholland.sendhttp;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
public class JsonTask extends AsyncTask<String,String,String>
{
    private final String URL = "google.com";
    private ArrayList<NameValuePair> postParams = new ArrayList<>();
    private JSONObject jsonObject = new JSONObject();

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params)
    {
        postParams.add(new BasicNameValuePair("ParamKey", "ParamValue"));
        jsonObject = JSONParser.makeHttpRequest(URL, "GET", postParams);
        return jsonObject.toString();
    }
}
}
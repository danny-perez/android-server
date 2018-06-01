package co.wolholland.myhttpfrag;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.AsyncTask;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class ProgressFragment extends Fragment {
    TextView contentView;
    String contentText = null;
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
        if(contentText!=null){
            contentView.setText(contentText);
        }
                if(contentText==null){
                    new ProgressTask().execute("https://maps.googleapis.com/maps/api/directions/json?origin=55.573721,%2037.566561&destination=55.574037,%2037.590637&key=AIzaSyBe23DtCnNlwWxEvl1K1Z_DF8DL2jy48Pg");
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
            /*************************************************************/
            try{
                JSONObject jsonObject = new JSONObject(content);
                JSONArray geocoded = jsonObject.getJSONArray("geocoded_waypoints");
                for (int i = 0; i < geocoded.length(); i++) {
                    JSONObject jsonobject = geocoded.getJSONObject(i);
                    String gname = jsonobject.getString("geocoder_status");
                    String gplace = jsonobject.getString("place_id");
                    result = gname + "\n" + gplace;
                    //contentView.setText(result);
                }
            } catch (JSONException e){}
            /*************************************************************/
            result = result + "\n**************************************************\n";
            result = result + content;
            contentView.setText(result);

            Activity activity = getActivity();
            if (activity != null && !activity.isFinishing() && activity instanceof MainActivity) {
                ((MainActivity) activity).fromFragmentData(content);
            }
        }

        private String getContent(String path) throws IOException {
            BufferedReader reader=null;
            try {
                URL url=new URL(path);
                HttpsURLConnection c=(HttpsURLConnection)url.openConnection();
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

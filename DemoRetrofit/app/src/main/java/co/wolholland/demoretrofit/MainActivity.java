package co.wolholland.demoretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startFit(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        String demo_str = getResources().getString(R.string.demo_str);
        textView.setText(demo_str);
    }
    public interface YourUsersApi {

        //You can use rx.java for sophisticated composition of requests
        @GET("/users/{user}")
        public Observable<SomeUserModel> fetchUser(@Path("user") String user);

        //or you can just get your model if you use json api
        @GET("/users/{user}")
        public SomeUserModel fetchUser(@Path("user") String user);

        //or if there are some special cases you can process your response manually
        @GET("/users/{user}")
        public Response fetchUser(@Path("user") String user);

    }
    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("https://yourserveraddress.com")
            .build();

    YourUsersApi yourUsersApi = restAdapter.create(YourUsersApi.class);
}

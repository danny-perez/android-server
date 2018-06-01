package co.wolholland.getse;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;


public class MainActivity extends AppCompatActivity {

    public class Book {
        public int id;
        public String title;
        public String author;
        public int released;
    }

    public interface IBookSetRestAPI {

        @GET("/v1/books/{book_id}")
        Book getBook(@Path("book_id") String book_id);

    }
    public void getterClick(View view)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sys64.pw")
                .build();

        IBookSetRestAPI service = retrofit.create(IBookSetRestAPI.class);
    }
}

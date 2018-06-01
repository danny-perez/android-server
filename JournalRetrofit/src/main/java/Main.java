import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class Main {
    public static void main(String...args) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setServer(Url.BASE_URL)
                .build();

        Api api = restAdapter.create(Api.class);

        try {
            for(Url url : Url.values()) {
                Journal journal = api.getJournalInfo(url.getUrl());
                System.out.println("journal : " + journal.getTitle());
            }
        } catch (RetrofitError error) {
            if (error.getResponse() != null) {
                int code = error.getResponse().getStatus();
                System.out.println("Http error, status : " + code);
            } else {
                System.out.println("Unknown error");
                error.printStackTrace();
            }
        }
    }
}

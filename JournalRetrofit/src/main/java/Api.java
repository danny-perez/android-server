import retrofit.http.POST;
import retrofit.http.Path;

public interface Api {
    @POST("/{url}")
    public Journal getJournalInfo(@Path("url") String urlJournal);
}

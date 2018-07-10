package in.karan.suman.foodka.Remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Suman on 13-Feb-18.
 */

public interface IGoogleService {

    @GET
    Call<String> getAddressName(@Url String url);
}

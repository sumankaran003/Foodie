package in.karan.suman.foodka.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Suman on 19-Dec-17.
 */

public class RetrofitClient {


    private static Retrofit retrofit=null;

    public static Retrofit getClient(String baseUrl)
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public static Retrofit getGoogleClient(String baseURL)
    {
        if(retrofit==null)
        {


            retrofit=new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }


        return retrofit;
    }
}

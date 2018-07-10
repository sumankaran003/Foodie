package in.karan.suman.foodka.Remote;

import in.karan.suman.foodka.Model.DataMessage;
import in.karan.suman.foodka.Model.MyResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Suman on 19-Dec-17.
 */



public interface APIService {

    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAmPt-FfQ:APA91bEEJowCUuaMDbFOrBt_TC-O77eX4K__tumfC1J7rTY_jTm3MG7I1YV8yba2rqO4FaQgZBJ2AzrMfGpqKtXTw4hW8gp9VONKVx2yFOEWGzy5mYFb6qtAHlHr2IK6mDJ4VSNjOzg4"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body DataMessage body);
}

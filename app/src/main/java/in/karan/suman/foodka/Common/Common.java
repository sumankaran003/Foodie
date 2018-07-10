package in.karan.suman.foodka.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import in.karan.suman.foodka.Model.Request;
import in.karan.suman.foodka.Model.User;
import in.karan.suman.foodka.Remote.APIService;
import in.karan.suman.foodka.Remote.FCMRetrofitClient;
import in.karan.suman.foodka.Remote.IGoogleService;
import in.karan.suman.foodka.Remote.RetrofitClient;

/**
 * Created by Suman on 12-Dec-17.
 */

public class Common {

    public static String topicNews="News";
    public static User currentUser;

    public static Request currentRequest;
    public static String DELETE="Delete";
    public static String USER_KEY="User";
    public static String PWD_KEY="Password";

    public static String PHONE_TEXT="userPhone";

    public static final String INTENT_FOOD_ID="FoodId";

    private static final String GOOGLE_API_URL="https://maps.googleapis.com/";

    private static final String BASE_URL="https://fcm.googleapis.com/";
    public static APIService getFCMService()
    {
        return FCMRetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

    public static IGoogleService getGoogleMapAPI()
    {
        return RetrofitClient.getGoogleClient(GOOGLE_API_URL).create(IGoogleService.class);
    }
    public static  String convertCodeToStatus(String status) {

        if(status.equals("0"))
        {
            return "Placed";
        }
        else if(status.equals("1"))
        {
            return "On my way";
        }
        else
        {
            return "Shipped";
        }

    }


    public static boolean isConnetionToInternet(Context context)
    {
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager!=null)
        {
            NetworkInfo[] info=connectivityManager.getAllNetworkInfo();
            if(info!=null)
            {
                for(int i=0;i<info.length;i++)
                {
                    if(info[i].getState()==NetworkInfo.State.CONNECTED)
                        return  true;
                }
            }
        }
    return false;

    }

}

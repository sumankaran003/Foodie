package in.karan.suman.foodka.Model;

/**
 * Created by Suman on 18-Dec-17.
 */

public class Rating {

    private String userPhone,foodId,rateValue,comment;


    public Rating() {
    }



    public Rating(String userPhone, String foodId, String rateValue, String cooment) {
        this.userPhone = userPhone;
        this.foodId = foodId;
        this.rateValue = rateValue;
        this.comment = cooment;
    }


    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getRateValue() {
        return rateValue;
    }

    public void setRateValue(String rateValue) {
        this.rateValue = rateValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String cooment) {
        this.comment = cooment;
    }
}

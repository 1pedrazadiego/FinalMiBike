package com.example.finalmibike.bikes;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class UserBooking {
    public String userId;
    public String userEmail;
    public String bikeEmail;
    public String bikeCity;
    public String bookDate;

    public UserBooking(String userId, String userEmail, String bikeEmail, String bikeCity, String bookDate) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.bikeEmail = bikeEmail;
        this.bikeCity = bikeCity;
        this.bookDate = bookDate;
    }

    public UserBooking(){

    }

    public void addToDatabase(){
        DatabaseReference database= FirebaseDatabase.getInstance().getReference();
        String key= database.child("bikes_list").push().getKey();
        Map<String, Object> childUpdates = new HashMap<>();
        database.child("user_booking/"+key).setValue(this);
    }
}

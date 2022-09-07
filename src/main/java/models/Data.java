package models;

import com.google.gson.annotations.SerializedName;

@lombok.Data
public class Data {
    @SerializedName(value = "last_name")
    private String lastName;
    private int id;
    private String avatar;
    @SerializedName(value = "first_name")
    private String firstName;
    private String email;
}


package ru.a799000.alexander.fandroidvk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Views {

    @SerializedName("count")
    @Expose
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}

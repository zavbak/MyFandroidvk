package ru.a799000.alexander.fandroidvk.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.a799000.alexander.fandroidvk.model.attachment.video.Video;

public class VideosResponse {
    public int count;
    @SerializedName("items")
    @Expose
    public List<Video> items;
}

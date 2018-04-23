package ru.a799000.alexander.fandroidvk.consts;

import com.vk.sdk.VKScope;

public class ApiConstants {

    public static final Double DEFAULT_VERSION = 5.67;
    public static final int DEFAULT_COUNT = 10;
    public static final String DEFAULT_USER_FIELDS = "photo_100";

    public static final String[] DEFAULT_LOGIN_SCOPE = {VKScope.AUDIO, VKScope.DIRECT, VKScope.VIDEO,
            VKScope.WALL, VKScope.MESSAGES, VKScope.PHOTOS, VKScope.PAGES, VKScope.GROUPS, VKScope.EMAIL,
            VKScope.STATS, VKScope.DOCS};

    public static final String DEFAULT_MEMBER_FIELDS = "name,photo_100";

    public static final int MY_GROUP_ID = -86529522;

    public static final String DEFAULT_GROUP_FIELDS = "status,description,site,links,contacts";

    public static final String VIDEOS = "videos";
    public static final String POSTS = "posts";
    public static final String EXTENDED = "extended";

    public static final String OWNER_ID = "owner_id";
    public static final String POST_ID = "post_id";
    public static final String COUNT = "count";
    public static final String OFFSET = "offset";
    public static final String NEED_LIKES = "need_likes";
}

package com.gaofei.annotation;

/**
 * Created by GaoQingming on 2018/10/15 0015.
 */
public class MyEntity {
    private String _id;
    @ShardingKey(shardingColumn = "uId", shardingCount = 128)
    private String userId;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

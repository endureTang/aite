package com.nj.mongoModel;

import com.alibaba.fastjson.annotation.JSONField;
import com.sun.corba.se.spi.ior.ObjectId;

public class MongoEntity {
    @JSONField(name = "_id", ordinal = 0, serialize = false)
    protected String id;

    public ObjectId getObjectId() {
        return null;

    }

    public String getId() {
        return this.id;
    }
    @JSONField(name = "id", ordinal = 0, serialize = false)
    public void setId(String id) {
        this.id = id;
    }
}
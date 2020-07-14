package com.nj.mongoModel;

import com.alibaba.fastjson.annotation.JSONField;

import org.bson.types.ObjectId;
public class MongoEntity {
    @JSONField(name = "_id", ordinal = 0, serialize = false)
    protected String id;

    public ObjectId getObjectId() {
        if (this.id == null) {
            return null;
        }
        return new ObjectId(this.id);
    }

    public String getId() {
        return this.id;
    }
    @JSONField(name = "id", ordinal = 0, serialize = false)
    public void setId(String id) {
        this.id = id;
    }
}
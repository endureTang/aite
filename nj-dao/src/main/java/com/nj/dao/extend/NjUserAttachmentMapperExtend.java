package com.nj.dao.extend;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjUserAttachment;

public interface NjUserAttachmentMapperExtend {
    public String getFaceIdImageUrl(@Param("orderId") String orderId);

    public String getHeadImageUrl(@Param("userId") String userId);

    public String getEmblemImageUrl(@Param("userId") String userId);

    public String getHandCertImageUrl(@Param("userId") String userId);

    public NjUserAttachment getHeadImage(@Param("userId") String userId);

    public NjUserAttachment getEmblemImage(@Param("userId") String userId);

    public NjUserAttachment getHandCertImage(@Param("userId") String userId);

    NjUserAttachment getAttachByOrderId(@Param("businessType") String businessType, @Param("orderId") String orderId);
}

package com.xhlim.elasticsearch;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.util.Date;

/**
 * 采集信息
 */
@Data
@Document(indexName = "collection", type = "collection_data")
public class CollectionData {
    public static final String DEGREE_MINUTE = "1m";
    public static final String DEGREE_QUAETER = "15m";
    public static final String DEGREE_HOUR = "1h";
    public static final String DEGREE_DAY = "1d";

    @Field(store = true, type = FieldType.text, index = false)
    @Id
    private String id;
    /**
     * 服务器ID
     */
    @Field(store = true, type = FieldType.text, index = false)
    private String serverId;
    /**
     * 采集指标
     */
    @Field(store = true, type = FieldType.text, index = false)
    private String key;

    /**
     * 采集指标的值
     */
    @Field(store = true, type = FieldType.Object, index = false)
    private Object value;

    /**
     * 采集的第二维度（用来表示任务task等属性）
     */
    @Field(store = true, type = FieldType.text, index = false)
    private String secondKey;

    /**
     * 采集时间
     */
    @Field(store = true, type = FieldType.Date, format = DateFormat.date_time, index = false)
    private Date collectionTime;
}

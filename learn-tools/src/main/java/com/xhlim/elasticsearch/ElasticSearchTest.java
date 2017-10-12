package com.xhlim.elasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author xhlim@outlook.com
 * @create 2017-10-10
 */
public class ElasticSearchTest {

    private TransportClient client;
    private ElasticsearchTemplate template;

    @Before
    public void before() {
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
        client = new PreBuiltTransportClient(settings);
        try {
            client = client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("122.114.226.115"), 9300));
        } catch (UnknownHostException e) {
            System.out.println("elasticsearch 地址找不到");
        }

        template = new ElasticsearchTemplate(client);
        System.out.println("success connect");
    }

    /**
     * 查看集群信息
     */
    @Test
    public void testInfo() {
        List<DiscoveryNode> nodes = client.connectedNodes();
        for (DiscoveryNode node : nodes) {
            System.out.println(node.getHostAddress());
        }
    }

    private IndexQuery indexQuery(CollectionData collectionData) {
        IndexQuery query = new IndexQuery();
        query.setId(collectionData.getId());
        query.setObject(collectionData);
        return query;
    }

    @Test
    public void insert() {
        CollectionData collectionData = new CollectionData();
        collectionData.setId(UUID.randomUUID().toString().replace("-", ""));
        collectionData.setId("11111");
        collectionData.setServerId("broker-01-01");
        collectionData.setKey("USER_ONLINE");
        collectionData.setValue("100");
        collectionData.setSecondKey("第二");
        collectionData.setCollectionTime(new Date());
        template.index(indexQuery(collectionData));
    }

    // 删除文档中的具体数据
    @Test
    public void delete() {
        String index = "collection";
        String type = "collection_data";
        String id = "11111";
        template.delete(index, type, id);
    }

    // 删除文档
    @Test
    public void deleteIndex() {
        String index = "twitter"; // 文档名称
        template.deleteIndex(index);
    }

    /**
     * get API 获取指定文档信息
     */
    @Test
    public void testGet() {
        Criteria criteria = new Criteria();
        criteria = criteria.and("id").is(11111);

        CriteriaQuery criteriaQuery = new CriteriaQuery(criteria);
        criteriaQuery.setPageable(new PageRequest(0, 10, new Sort(new Sort.Order(Sort.Direction.DESC, "pushTime"))));
        Page<CollectionData> list = template.queryForPage(criteriaQuery, CollectionData.class);
        System.out.println(list);
    }

}

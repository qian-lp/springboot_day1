package com.baizhi.test;

import com.baizhi.Application;
import com.baizhi.service.ProductionService;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetAddress;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MyTest {
    @Autowired
    private ProductionService productionService;

    @Test
    public void test1() throws Exception {
        //创建es客户端对象
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).
                addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.113.136"), 9300));
        //创建索引
        //CreateIndexResponse index01 = transportClient.admin().indices().prepareCreate("index01").execute().get();
        //创建指定索引类型的映射
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject()
                .startObject("properties")
                .startObject("name")
                .field("type", "text")
                .field("analyzer", "ik_max_word")
                .field("search_analyzer", "ik_max_word")
                .endObject()
                .startObject("age")
                .field("type", "integer")
                .endObject()
                .endObject()
                .endObject();


    }

}

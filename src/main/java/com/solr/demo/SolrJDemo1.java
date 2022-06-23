package com.solr.demo;

import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.StrUtils;

import java.math.BigDecimal;

/**
 * @Description: SolrJ
 * @Author: islaiyp islaiyp@163.com
 * @Date: 2022/6/22 23:43
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@Slf4j
public class SolrJDemo1 {
    /**
     * 使用 order，需要在本地先创建core
     */
    private static final String URL = "http://localhost:8983/solr/order";

    @SneakyThrows
    public static void main(String[] args) {
        SolrClient client = new HttpSolrClient.Builder(URL).withConnectionTimeout(10000).build();
        // add
        SolrInputDocument input = new SolrInputDocument();
        input.addField("id", 2);
        input.addField("order_no", RandomUtil.randomString(10));
        input.addField("user_name", "islaiyp");
        input.addField("user_id", 1);
        input.addField("total_amount", BigDecimal.TEN);

        log.info("solr add data: {}", JSON.toJSONString(input));
        client.add(input);
        UpdateResponse response = client.commit();
        log.info("solr commit response: {}", response.getResponse());

        client.close();
    }
}

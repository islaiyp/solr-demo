package com.solr.solrJ;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

/**
 * @Description: SolrJ
 * @Author: islaiyp yongpeng.lai@abite.com
 * @Date: 2022/6/22 23:43
 */
public class SolrJDemo1 {
    private static final String solrUrl = "";

    public static void main(String[] args) {
        SolrClient client = new HttpSolrClient.Builder(solrUrl).build();
        // todo
    }
}

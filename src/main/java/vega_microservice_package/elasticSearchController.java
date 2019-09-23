package vega_microservice_package;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.Map;


public class elasticSearchController {
    private String elasticSearchHostname;
    private int elasticSearchPort;
    private RestHighLevelClient client;

    public elasticSearchController(){
        this.elasticSearchHostname = elasticSearchConfig.Hostname;
        this.elasticSearchPort = elasticSearchConfig.port;


        client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(elasticSearchHostname, elasticSearchPort, "http")
                       ));


//        client = new RestHighLevelClient(
//                RestClient.builder(
//                        new HttpHost("localhost", 9200, "http"),
//                        new HttpHost("localhost", 9201, "http")));

    }
    public void get_document() throws IOException {
        GetRequest getRequest = new GetRequest(
                "posts",
                "1");
//         This is only usefull if we need to collect meta data
//         Example
//        {"_index":"posts","_type":"_doc","_id":"1","_version":1,"_seq_no":0,"_primary_term":1,"found":true}
//        getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE);

        GetResponse getResponse = client.get(getRequest,RequestOptions.DEFAULT);

        System.out.println(getResponse);
        Map<String,Object> sourceAsMap = getResponse.getSourceAsMap();
        System.out.println(sourceAsMap);
        System.out.println(sourceAsMap.get("id"));
    }

    public static void main(String args[]) throws IOException {
        elasticSearchController esc = new elasticSearchController();
        esc.get_document();

    }
    }




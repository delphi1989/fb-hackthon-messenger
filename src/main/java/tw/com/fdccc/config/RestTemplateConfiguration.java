package tw.com.fdccc.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {

        PoolingHttpClientConnectionManager connectionManager
                = new PoolingHttpClientConnectionManager();
        // default to 10
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultMaxPerRoute(50);

        return connectionManager;
    }

    @Bean
    public RequestConfig requestConfig() {

        RequestConfig requestConfig = RequestConfig.custom()
                // the timeout when requesting a connection from the connection manager
                .setConnectionRequestTimeout(50000)
                // the timeout until a connection is established
                .setConnectTimeout(50000)
                //  the timeout for waiting for data
                .setSocketTimeout(120000)
                .build();

        return requestConfig;
    }

    @Bean
    public CloseableHttpClient httpClient(
            PoolingHttpClientConnectionManager poolingHttpClientConnectionManager,
            RequestConfig requestConfig) {

        CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build();

        return httpClient;
    }

    @Bean
    public RestTemplateCustomizer restTemplateCustomizer(
            HttpClient httpClient) {

        return restTemplate -> {

            HttpComponentsClientHttpRequestFactory httpRequestFactory
                    = new HttpComponentsClientHttpRequestFactory();
            httpRequestFactory.setHttpClient(httpClient);

            restTemplate.setRequestFactory(httpRequestFactory);

            DefaultResponseErrorHandler responseErrorHandler
                    = new DefaultResponseErrorHandler();
            restTemplate.setErrorHandler(responseErrorHandler);
        };
    }
}

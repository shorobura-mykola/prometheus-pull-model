package com.prometheus.pull.model.demo;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.PushGateway;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * PrometheusPushModelApplication.
 *
 * @author mshorobura
 * @since 12/4/19.
 */
@Slf4j
public class PrometheusPushModelApplication {
    public static void main(String[] args) {
        CollectorRegistry registry = new CollectorRegistry();

        Gauge counter = Gauge
                        .build()
                        .name("pushgateway_counter_test_name")
                        .help("pushgateway_counter_test_HELP")
                        .labelNames("test_label1", "test_label2", "test_label3")
                        .create();

        counter.register(registry);

        counter.labels("test.label1.value", "test.label2.value", "test.label3.value").inc(10);

        try {
            PushGateway pg = new PushGateway("localhost:9091");
            pg.push(registry, "pushgateway_counter_test");
        } catch (IOException e) {
            log.error("Error while pushing metrics to PushGateway", e);
        }
    }
}

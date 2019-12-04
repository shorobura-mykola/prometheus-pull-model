package com.prometheus.pull.model.demo.web.rest;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

/**
 * TestEndpoint.
 *
 * @author mshorobura
 * @since 11/27/19.
 */
@WebEndpoint(id = "test-endpoint")
@Component
public class TestEndpoint {

    @Timed
    @PostConstruct
    @ReadOperation(produces = "text/plain; version=0.0.4; charset=utf-8")
    public String scrape() {
        return
        "# HELP test_random_value \n" +
        "# TYPE test_random_value counter\n" +
        "test_random_value{test_custom_endpoint_tag=\"test_custom_endpoint_value\",} " + new Random().nextInt(42);
    }

}

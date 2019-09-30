package com.richur.venus.biz.aspect.metric;



import io.micrometer.core.instrument.distribution.Histogram;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author richur
 * @Date 2019/9/29 6:04 PM
 */
@Slf4j
public class PrometheusMetrics {
    private static final double[] les = new double[]{5, 50, 200, 500, 1000, 5000, 10000};
    /**
     * http请求监控统计，计数统计+请求时间统计
     */
    private static final String[] HTTP_SERVER_LABELS = new String[]{"caller", "path", "method", "code"};
//    private static final Histogram HTTP_SERVER_HISTOGRAM = Histogram.name("venus_http_server_requests_duration_ms")
//            .help("http server request histogram")
//            .labelNames(HTTP_SERVER_LABELS).buckets(les).register();
//
//
//    public static void http(String caller, String url, String method, int code, long costTime) {
//        http(caller, url, method, code, costTime, 1);
//    }
//
//    public static void http(String caller, String url, String method, int code, long costTime, int inc) {
//        try {
//            HTTP_SERVER_HISTOGRAM.labels(caller, url, method, String.valueOf(code)).observe(costTime);
//        } catch (Exception e) {
//            log.error("PrometheusMetrics http error, caller: {}, url: {}, method: {}, code: {}, costTime: {}, inc: {}",
//                    caller, url, method, code, costTime, inc, e);
//        }
//    }
}

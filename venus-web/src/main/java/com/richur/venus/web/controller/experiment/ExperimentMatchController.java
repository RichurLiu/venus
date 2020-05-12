package com.richur.venus.web.controller.experiment;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author richur
 * @since v0.0.1
 */
@RestController
@RequestMapping("/ab/experiment/")
public class ExperimentMatchController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExperimentMatchController.class);

    @RequestMapping("/match")
    public String expMatch(HttpServletRequest request){

        return "OK";
    }


    private MatchParams parseParam(String queryString, String platform) {
        Map<String, String> params = new HashMap<>();
        MatchParams matchParams = new MatchParams();
        if (platform != null) {
            matchParams.put(MatchParams.PLATFORM, platform);
        }
        if(StringUtils.isBlank(queryString)){
            LOGGER.error("queryString is null,platform:{}", platform);
            return matchParams;
        }
        for (String pairStr : queryString.split("&")) {
            String[] pair = pairStr.split("=");
            if (pair.length < 2) {
                continue;
            }
            params.put(pair[0], pair[1]);
        }

        matchParams.put(params);

        return matchParams;
    }

}

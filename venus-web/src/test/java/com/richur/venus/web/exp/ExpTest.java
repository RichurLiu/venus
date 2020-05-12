package com.richur.venus.web.exp;

import com.bilibili.exp.ExpContext;
import com.bilibili.exp.ExpRegistry;
import com.bilibili.exp.bean.VarHolder;
import com.bilibili.exp.flag.IntFlag;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author richur
 * @since v0.0.1
 */
public class ExpTest {
    private static final IntFlag ratio = new IntFlag("ratio", 3);
    @Test
    public void testDiversion(){
        ExpRegistry.REGISTRY.registerEnv(new HashMap<String, Class>() {{
            put("mid", Integer.class);
            put("region", String.class);
            put("referer_url", String.class);
        }});
        //ExpRegistry.REGISTRY.refresh(exampleDomain());

        Map<String, Integer> result = new HashMap<>();
        int times = 1000000;

        Map<String, VarHolder> varMap = new HashMap<String, VarHolder>() {{
            put("region", VarHolder.stringVar("sh"));
            put("referer_url", VarHolder.stringVar("www.baidu.com"));
        }};
        StopWatch timer = new StopWatch();
        long cost = 0;
        for (int i = 0; i < times; i++) {
            varMap.put("mid", VarHolder.longVar(i));
            ExpContext ctx = new ExpContext(varMap);
            timer.start();
            ratio.get(ctx);
            timer.stop();
            cost += timer.getNanoTime();
            //collectResults(result, ctx.extract());

            timer.reset();
        }

        System.out.println(String.format("Average cost: %f", ((double) cost) / times));
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(String.format("%s: %d, ratio: %f", entry.getKey(), entry.getValue(),
                    ((double) entry.getValue()) / times));
        }
    }
}

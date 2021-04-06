package com.richur.venus.biz.util.shell;

import java.io.IOException;
import java.util.*;

/**
 * @author richur
 */
public class ProcessTest {
    public static void main(String[] args) {
        List<String> cmd = new ArrayList<>();
        cmd.add("");
        Map<String, String> environment = new HashMap<>();
        environment.put("KRB5CCNAME","/tmp/krb5_liulei01");
        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.environment().putAll(environment);
        Process start = null;
        try {
            start = processBuilder.start();
            try(Scanner input = new Scanner(start.getInputStream())){
                while (input.hasNextLine()){
                    System.out.println(input.nextLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

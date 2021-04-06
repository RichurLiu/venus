package com.richur.venus.biz.util.shell;

import java.io.IOException;
import java.util.*;

/**
 * @author richur
 */
public class ShellTest {

    public static void main(String[] args) throws IOException {
        List<String> cmd = new ArrayList<>();
//        cmd.add("bash");
//        cmd.add("KRB5CCNAME=\"/tmp/krb5_liulei\"");
        cmd.add("bash");
//        cmd.add("$KRB5CCNAME");
        cmd.add("/Users/richur/ideaProject/venus/bin/test.sh");
//        cmd.add("bash");
//        cmd.add("$PATH");
        Map<String, String> environment = new HashMap<>();
        environment.put("KRB5CCNAME","/tmp/krb5_liuleiqqq");
        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
//        processBuilder.environment().put("KRB5CCNAME", "/tmp/krb5_liulei222");
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

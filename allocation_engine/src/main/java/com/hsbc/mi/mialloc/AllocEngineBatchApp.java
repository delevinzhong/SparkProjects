package com.hsbc.mi.mialloc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;

public class AllocEngineBatchApp {

    private static Logger LOGGER = LoggerFactory.getLogger(AllocEngineBatchApp.class);

    static HashMap<String, String> buildArgsMap(String[] args) {
        HashMap<String, String> argsInMap = new HashMap<>();

        Arrays.stream(args).filter(str -> str.startsWith("--") && str.contains("=")).forEach(str -> {
            String[] kvp = str.substring(2).split("=");
            argsInMap.put(kvp[0], kvp[1]);
        });

        return argsInMap;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            LOGGER.error("Not enough job parameter is provided.");
            System.exit(1);
        }

        LOGGER.info("test");
        HashMap<String, String> argsInMap = buildArgsMap(args);

    }
}

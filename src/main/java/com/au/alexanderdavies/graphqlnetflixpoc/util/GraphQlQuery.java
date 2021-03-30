package com.au.alexanderdavies.graphqlnetflixpoc.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public enum GraphQlQuery {
    GET_ACCOUNT_DETAILS("getAccountDetails");

    private String query;

    GraphQlQuery(String query) {
        this.query = query;
    }

    public String fetchQuery() throws RuntimeException {
        String filePath = "queries/" + query + ".query";
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(filePath).getFile());
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException("Query not found at: " + filePath);
        }
    }

}

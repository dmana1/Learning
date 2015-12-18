/*
 * This class is used for relevance of documents
 */
package com.info.search;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deepthi
 */
public class Relevance {
    
    List<String> queryTerms;
    double rank;
    
    public Relevance(){
        queryTerms = new ArrayList<String>();
    }

    public List<String> getQueryTerms() {
        return queryTerms;
    }

    public void setQueryTerms(List<String> queryTerms) {
        this.queryTerms = queryTerms;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
    
}

/*
 * This class is used for arranging documents based on the cosine angle/rank in descending order
 */
package com.info.search;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Deepthi
 */
public class RankComparator implements Comparator {

    Map<String, Double> map = new TreeMap<String, Double>();

    public RankComparator(TreeMap map) {
        this.map = map;
    }

    public RankComparator() {
        super();
    }

    @Override
    public int compare(Object t1, Object t2) {

        String s1 = (String) t1;
        String s2 = (String) t2;

        if (map.get(s1) >= map.get(s2)) {
            return -1;
        } else {
            return 1;
        }
    }

}

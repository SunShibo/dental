package com.jrtc.base.util;

import java.util.HashSet;
import java.util.Set;

public class SetUtil {

    public static Set<String> newSet(String... str){
        Set<String>  hashSet=new HashSet<String>();
        for(String s:str){
            hashSet.add(s);
        }
        return hashSet;
    }
}

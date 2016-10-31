package com.algorithm;

/**
 * Created by chuck7 on 16/10/31.
 */
public class KMP {
    public static int kmpFindIndex(String haystack, String needle) {
        //用kmp来实现查找子串出现的index
        if(haystack.length() < needle.length()){
            return -1;
        }
        if(needle.length() < 1){
            return 0;
        }
        int[] next = initNext(needle);
        int i,j;
        for(i=0,j=0;i < haystack.length() && j < needle.length() ;i++,j++){
            if(haystack.charAt(i) == needle.charAt(j)) continue;
            j = next[j];
            while(j != -1){
                if(haystack.charAt(i) == needle.charAt(j)){
                    break;
                }
                j = next[j];
            }
        }
        return j == needle.length() ? i - needle.length(): -1;

    }
    private static int[] initNext(String needle){
        //next记录下一次应该查找的坐标;
        int[] next = new int[needle.length()];
        next[0] = -1;
        if(needle.length() > 1){
            next[1] = 0;
            int last = 0;
            for(int i = 2;i < needle.length(); i++){
                while(last != -1 && needle.charAt(i-1) != needle.charAt(last) ){
                    last = next[last];
                }
                next[i] = last+1;
                last = next[i];
            }
        }
        return next;
    }
    public static void main(String args[]){
        System.out.println(kmpFindIndex("needsdflneedleeeneedlee","needle"));
    }
}

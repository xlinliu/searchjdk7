package mycollections;

import java.util.Map;

public class ConcurrentHashMap {
    private static Map<String, Integer> concurrentHashMap;
    public static void main(String[] args){
        concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>(8,
                0.75f, 2);
        testput();

    }


    public static void testput(){
        int n =20;
        for(int i=0;i<n;i++){
            concurrentHashMap.put("key_" + i, i);
        }
    }
}

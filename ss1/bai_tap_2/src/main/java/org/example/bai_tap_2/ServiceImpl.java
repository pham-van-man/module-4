package org.example.bai_tap_2;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    public static Map<String, String> list = new HashMap<String, String>();

    static {
        list.put("chuối", "banana");
    }

    @Override
    public String getString(String key) {
        return list.getOrDefault(key, "không có từ này");
    }
}

package org.example.bai_tap_2.Service;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    public static Map<String, String> list = new HashMap<>();

    static {
        list.put("chuối", "banana");
    }

    @Override
    public String getString(String keyword) {
        return list.getOrDefault(keyword, "không có từ này");
    }
}

package org.example.bai_tap_1.Converter;

import org.example.bai_tap_1.model.CompositeKey;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCompositeKeyConverter implements Converter<String, CompositeKey> {
    @Override
    public CompositeKey convert(String source) {
        if (source.isEmpty()) {
            return null;
        }
        source = source.replace("CompositeKey(", "").replace(")", "");
        String[] parts = source.split(", ");
        CompositeKey key = new CompositeKey();
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                if ("blogId".equals(keyValue[0])) {
                    key.setBlogId(Long.valueOf(keyValue[1]));
                } else if ("categoryId".equals(keyValue[0])) {
                    key.setCategoryId(Long.valueOf(keyValue[1]));
                }
            }
        }
        return key;
    }
}


package com.example.dumplingscloud.core.converter;

import com.example.dumplingscloud.core.model.Dumplings;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DumplingsSizeByNameConverter implements Converter<String, Dumplings.Size> {

    @Override
    public Dumplings.Size convert(String sizeName) {
        return Dumplings.Size.valueOf(sizeName);
    }
}

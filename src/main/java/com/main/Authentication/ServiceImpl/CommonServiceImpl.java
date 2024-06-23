package com.main.Authentication.ServiceImpl;

import com.main.Authentication.Service.CommonService;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class CommonServiceImpl implements CommonService {
    @Override
    public String encodeData(String value) {
        String encoded = Base64.getEncoder().encodeToString(value.getBytes());
        return encoded;
    }

    @Override
    public String decodeData(String value) {
        byte[] decodedBytes = Base64.getDecoder().decode(value);
        String decodedData = new String(decodedBytes);
        return decodedData;
    }
}

package com.main.Authentication.Service;

import java.util.Map;
import com.main.Authentication.Entities.AuthRequestDto;


public interface AuthService {
     Map<String, String> authRequest(AuthRequestDto authRequestDto);

}

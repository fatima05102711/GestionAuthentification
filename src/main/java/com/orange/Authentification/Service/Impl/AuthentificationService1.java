package com.orange.Authentification.Service.Impl;

import com.orange.Authentification.AuthentificationResponse;
import com.orange.Authentification.user.User;

public interface AuthentificationService1 {
    User register (User user );
    AuthentificationResponse authenticate (User user );
}

package com.jg4lves.auth_service.store;

import com.jg4lves.auth_service.model.User;

import java.util.concurrent.ConcurrentHashMap;

public class UserStore {

    public static ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

}

//simula um banco de dados
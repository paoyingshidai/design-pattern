package com.michael.proxy.cglib.instance;

import lombok.Data;

@Data
public class GameRoomBean {

    private String roomId = "1";

    public String getRoomId() {
        return roomId;
    }
}


package com.michael.proxy.cglib.instance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
abstract public class AbstractGameStateContext implements IGameStateContext {

    abstract public GameRoomBean getGameRooBean();

}

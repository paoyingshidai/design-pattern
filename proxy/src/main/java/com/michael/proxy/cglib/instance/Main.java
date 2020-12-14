package com.michael.proxy.cglib.instance;

public class Main {

    public static void main(String[] args) {

        Facade facade = new Facade();
        GameRoomBean gameRoomBean = new GameRoomBean();

        GbbbGameStateContext context = new GbbbGameStateContext(facade, gameRoomBean);

        GbbbGameStateContext.GbbbGameStateContextCglib cglib = new GbbbGameStateContext.GbbbGameStateContextCglib();
        // Cglib 有参数构造函数
        AbstractGameStateContext instance = cglib.getInstance(context,
                new Class[]{facade.getClass(), gameRoomBean.getClass()}, new Object[]{facade, gameRoomBean});

        System.out.println(instance.getGameRooBean().getRoomId());

    }

}

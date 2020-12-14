package com.michael.proxy.cglib.instance;

import lombok.NoArgsConstructor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@NoArgsConstructor
public class GbbbGameStateContext extends AbstractGameStateContext {

    private Facade facade;

    private GameRoomBean gameRoomBean = new GameRoomBean();

    public GbbbGameStateContext(Facade facade, GameRoomBean gameRoomBean) {
        this.facade = facade;
        this.gameRoomBean = gameRoomBean;
    }

    @Override
    public GameRoomBean getGameRooBean() {
        return this.gameRoomBean;
    }

    public String getName() {
        System.out.println("getName");
        return "this.getClass().getSimpleName()";
    }

    public static class GbbbGameStateContextCglib extends GameStateContextCglib {


        @Override
        protected Object doIntercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

            System.out.println("调用前操作——————");

            System.out.println(target.getGameRooBean().getRoomId());

            Object result = proxy.invokeSuper(obj, args); //调用业务类（父类中）的方法

            System.out.println("调用后操作——————");

            return result;
        }
    }
}

package com.chz.myBeanMain.bean;

public class MainBean4Proxy implements IMainBean4{

    private MainBean4 mainBean4;

    public MainBean4Proxy(MainBean4 mainBean4)
    {
        this.mainBean4 = mainBean4;
    }

    @Override
    public String getName() {
        return "[我被代理了："+ mainBean4.getName()+"]";
    }
}

package com.leaning;

/** 静态代理的实现
 * Created by sqy on 2018/8/24.
 */
public class InvokeTest {

    public static void main(String[] args) {
        NikeFactory nike = new NikeFactory();
        ProxyFactory proxy = new ProxyFactory(nike);
        proxy.buildershoe();
    }
}

 interface ShoeFactory{
    void buildershoe();
}

class NikeFactory implements ShoeFactory{

    @Override
    public void buildershoe() {
        System.out.println("开始生产nike鞋。。。");
    }
}

class ProxyFactory implements ShoeFactory{
    ShoeFactory shoeFactory;

    public ProxyFactory(ShoeFactory shoeFactory){
        this.shoeFactory = shoeFactory;
    }

    @Override
    public void buildershoe() {
        System.out.println("使用代理类生产鞋了。。。");
        shoeFactory.buildershoe();
    }
}

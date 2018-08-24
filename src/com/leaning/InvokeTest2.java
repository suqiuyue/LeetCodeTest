package com.leaning;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 动态代理
 * Created by sqy on 2018/8/24.
 */
public class InvokeTest2 {
    public static void main(String[] args) {

        RealSubject real = new RealSubject();
        MyInvocationHandler handler = new MyInvocationHandler();
        Object obj = handler.blind(real); //返回实现了real实现接口的代理类的对象
        Subjct sub = (Subjct)obj;
        sub.action();

        NikeFactory nike = new NikeFactory();
        ShoeFactory shoe=(ShoeFactory)handler.blind(nike);
        shoe.buildershoe();
    }
}
 interface Subjct{
    void action();

 }

class RealSubject implements Subjct{

     @Override
     public void action() {
         System.out.println("真实类即被代理类开始执行了。。。");
     }
}

//通用的代理类
class MyInvocationHandler implements InvocationHandler{
    Object obj; //实现了接口的真实类的对象的声明

    //给被代理类的对象实例化,并返回一个代理类的对象
    public Object blind(Object obj){
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    //当通过代理类的对象发起对真实类方法的调用时，都会转换为如下invoke方法的调用。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始调用invoke方法了。。。");
        Object val = method.invoke(obj,args);
        return val;
    }
}
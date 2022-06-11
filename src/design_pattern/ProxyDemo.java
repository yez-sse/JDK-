package design_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
}

//业务接口
interface DateService {
    void add();
    void del();
}

class DateServiceImplA implements DateService {
    @Override
    public void add() {
        System.out.println("成功添加！");
    }

    @Override
    public void del() {
        System.out.println("成功删除！");
    }
}

class ProxyInvocationHandler implements InvocationHandler {
    private DateService service;

    public ProxyInvocationHandler(DateService service) {
        this.service = service;
    }

    public Object getDateServiceProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), service.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //invoke方法用到了反射
        Object result = method.invoke(service, args); // 让service调用方法，方法返回值
        System.out.println(proxy.getClass().getName() + "代理类执行" + method.getName() + "方法，返回" + result +  "，记录日志！");
        return result;
    }
}

//客户端
class Test {
    public static void main(String[] args) {
        DateService serviceA = new DateServiceImplA();
        //得到代理类的对象
        DateService serviceProxy = (DateService) new ProxyInvocationHandler(serviceA).getDateServiceProxy();
        serviceProxy.add();
        serviceProxy.del();
    }
}
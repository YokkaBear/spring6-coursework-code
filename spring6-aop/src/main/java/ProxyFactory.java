import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

// 生成动态代理对象的工厂类（通用抽象类）
public class ProxyFactory {
    private Object target;
    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            // 代理类对于target类附加逻辑 写在invocationHandler
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("[动态代理][日志] " + method.getName() + " 参数：" + Arrays.toString(args) );
                    result = method.invoke(target, args);
                    System.out.println("[动态代理][日志] " + method.getName() + " 结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[动态代理][日志] " + method.getName() + " 异常" + e.getMessage());
                } finally {
                    System.out.println("[动态代理][日志] " + method.getName() + " 方法执行完毕");
                }
                return result;
            }
        };


        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }

}

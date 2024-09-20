package Unit3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
interface MyInterface {
    void doSomething();
}
class MyTarget implements MyInterface {
    @Override
    public void doSomething() {
        System.out.println("Doing something in the target object.");
    }
}
// Invocation handler that handles method invocations on the proxy object

class MyInvocationHandler implements InvocationHandler {
    private MyInterface target; // Reference to the target object
    public MyInvocationHandler(MyInterface target) {
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoking method: " + method.getName());
        Object result = method.invoke(target,args); // Invoke method on the target object
        System.out.println("After invoking method: " + method.getName());
        return result;
    }
}
public class ProxyExample {
    public static void main(String[] args) {
        // Create the target object
        MyInterface target = new MyTarget();
        // Create the proxy object using Proxy.newProxyInstance()
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class},
                new MyInvocationHandler(target));
        // Call a method on the proxy object, which will be intercepted by the invocation handler
        proxy.doSomething();
    }
}

package reflectLearning;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Client {

    public void TestMethod(){

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        HttpUtil httpUtil = new HttpUtil();
        IHttp proxy = new HttpProxy().getInstance(httpUtil);
        proxy.request("request data");
        proxy.onSuccess("received result");
        proxy.sayHello("hello");


        Client a = new Client();


    }
}


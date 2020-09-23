package reflectLearning;

public interface IHttp {
    void request(String sendData);

    void onSuccess(String receivedData);

    void sayHello(String helloMsg);

}
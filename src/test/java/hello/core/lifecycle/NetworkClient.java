package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// implements InitializingBean, DisposableBean
// 지금은 잘 사용하지 않는 방법.
// 스프링 전용 인터페이스에 의존.
// 메소드 이름 변경 불가.
// 외부 라이브러리에 적용 불가.


public class NetworkClient  {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
//        connect();
//        call("초기화 연결 메시지");
    }

    public void setUrl(String url){
        System.out.println("NetworkClient.setUrl");
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message){
        System.out.println("call = " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close = " + url);
    }

    public void init() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    public void close() throws Exception {
//        System.out.println("NetworkClient.destroy");
        System.out.println("NetworkClient.close");
        disconnect();
    }
}

package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {

    // 1. static 영역에 객체를 1개만 생성
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 열어서 객체 인스턴스가 필요하면 해당 메소드를 통해 조회
    public static SingletonService getInstance(){
        return instance;
    }

    // 3. 객체 생성을 못하게 막음
    private SingletonService() {

    }
    
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


}

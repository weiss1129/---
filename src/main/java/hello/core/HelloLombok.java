package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok hl = new HelloLombok();
        hl.setAge(30);
        hl.setName("이름");
        System.out.println(hl.getName());
        System.out.println("hl = " + hl);
    }
}

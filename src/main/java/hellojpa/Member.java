package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

//JPA가 관리할 객체 라고 선언해주는것. 이게 있어야 인식할 수 있음.
@Entity
public class Member {

    @Id
    private Long id; // 데이터베이스 PK와 매핑
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

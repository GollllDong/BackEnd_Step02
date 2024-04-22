package org.zerock.b01.domain;

import lombok.*;

import javax.persistence.*;

/*
*
* */

// 이 클래스의 정보를 가지고 자동으로 Board Table을 생성할거야
@Entity     // JPA를 사용하여 데이터베이스와 연동하겠다.
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity {

    /* @Id는 pk(Primary Key)로 정의하는 의미
    @G2neratedBalue(strategy = GenerationType.IDENTITY)
    는 Mysql/MariaDB에서 auto_increment 속성부여
    * */

    @Id     // 해당 필드가 엔티티의 주키(primary key)이다.

    // auto_increment 속성을 부여한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 500, nullable = false)     // 데이터베이스의 컬럼의 길이와 null 허용 여부 설정
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }
}

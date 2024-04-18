package org.zerock.b01.domain;

import lombok.*;

import javax.persistence.*;

/*
*
* */

// 이 클래스의 정보를 가지고 자동으로 Board Table을 생성할거야
@Entity
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 500, nullable = false)
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

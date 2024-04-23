package org.zerock.b01.domain;

import lombok.*;

import javax.persistence.*;

@Entity     // JPA에 의해 코드를 확인해서 Table로 생성된다.
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")    // board 필드만 제외하고 나머지 정보만 출력
public class Reply extends BaseEntity{

    // PK, 주키, 식별자, auto_increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    /* Reply - Board
       (Many)  (One)

       Reply 테이블로부터 정보를 읽어들일 때
       FetchType.LAZY  : 일단은 객체로 채워놓고, 나중에 조회하는 함수가 호출되면(필요할 때) 그 때 읽는다.
       FetchType.EAGER : Board도 테이블에서 즉시 읽어들인다.

       DBMS 에서는 Board가 부모, Reply가 자식인 제약조건이 생성된다.
       (Board테이블의 pk가 Reply테이블의 fk로 전이된다.)

       단방향 연결방식에서는 @OneToMany를 권장하지 않고, @ManyToOne을 권장한다.
       왜냐하면 @OneToMany를 사용하면(Board클래스에 Reply reply를 추가하고 @OneToMany설정)
       Reply에 새로운 데이터를 넣을 때 불필요한 Update과정이 추가로 필요하기 때문에 아무래도 좀 더 부하가 걸린다.
       그러므로 자식 테이블의 클래스에 부모 클래스 변수를 포함하고 @ManyToOne을 설정한다.


    * */
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    private String replyText;

    private String replayer;
}

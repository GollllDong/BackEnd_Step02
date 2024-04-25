package org.zerock.b01.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
*
* */

// 이 클래스의 정보를 가지고 자동으로 Board Table을 생성할거야
@Entity     // JPA를 사용하여 데이터베이스와 연동하겠다.
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "imageSet")
public class Board extends BaseEntity {

    /* @Id는 pk(Primary Key)로 정의하는 의미
    @G2neratedBalue(strategy = GenerationType.IDENTITY)
    는 Mysql/MariaDB에서 auto_increment 속성부여
    * */

    @Id     // 해당 필드가 엔티티의 주키(primary key)이다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // auto_increment 속성을 부여한다.
    private Long bno;

    @Column(length = 500, nullable = false)     // 데이터베이스의 컬럼의 길이와 null 허용 여부 설정
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;


    /*
    * Board     -       BoardImage
    *  부모       -          자식
    *  one(1)   -          Many(다)
    *
    * @ 아래 설정을 하면 OneToMany의 (불필요한) 복합연결테이블이 생성되지 않는다.
    *
    *   mappedBy = "board"는
    *   BoardImage의 private Board board; 필드를 FK로 지정한 것
    *
    *
    *   CascadeType.ALL
    *   게시판의 부모 글이 삭제되면, 소속된 자식 이미지도 삭제되도록 한다.
    * */
    @OneToMany(mappedBy = "board",
                cascade = {CascadeType.ALL},
                fetch = FetchType.LAZY)
    @Builder.Default

    private Set<BoardImage> imageSet = new HashSet<>();

    public void addImage(String uuid, String fileName){

        BoardImage boardImage = BoardImage.builder()
                .uuid(uuid)
                .fileName(fileName)
                .board(this)
                .ord(imageSet.size())
                .build();
        imageSet.add(boardImage);
    }

    public void clearImages() {
        imageSet.forEach(boardImage -> boardImage.changeBoard(null));
        this.imageSet.clear();
    }

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }
}

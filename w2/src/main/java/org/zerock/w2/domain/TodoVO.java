package org.zerock.w2.domain;

import lombok.*;

import java.time.LocalDate;

/* Vo는 처음 객체가 생성될 때 생성자를 통해서 1번 초기화하면
더 이상 값을 변경하도록 만드는 의도

왜냐하면 이 Vo는 DB의 Table에서 값을 꺼내거나 저장 시에 사용하기 떄문에
혹시라더 모를 Table 데이터의 변경을 막기 위한 표현이다.

뒤에서 Vo는 다시 Dto로 변환시켜서 Service - Controller - View 계층으로 전달된다.
* */
@Getter         //getter 메서드
@Builder        //빌더 패턴, 생성자 초기화이지만 마치 필드 초기화
@ToString       //필드 정보 보기
@AllArgsConstructor
@NoArgsConstructor

public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}

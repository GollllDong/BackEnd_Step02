package org.zerock.springex.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder                // Lombok 어노테이션으로, 빌더 패턴을 구현 -> 객체 생성 시 유연 및 가독성 향상
@AllArgsConstructor     // 모든 필드를 인자로 받는 생성자들을 자동으로 생성
@NoArgsConstructor      // 파라미터가 없는 기본 생성자들을 자동으로 생성
public class TodoDTO {

    private Long tno;

    @NotEmpty               // 해당 필드가 null 이거나 empty 문자열이 아닌지를 검증
    private String title;

    @Future                 // 해당 필드가 현재 시간보다 미래의 시간인지 확인(미래 시간만 허용)
    private LocalDate dueDate;

    private boolean finished;

    @NotEmpty
    private String writer;  // 새로 추가됨
}

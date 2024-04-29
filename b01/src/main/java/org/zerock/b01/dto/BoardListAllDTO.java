package org.zerock.b01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardListAllDTO {

    // Board 테이블
    private Long bno;
    private String title;
    private String writer;
    private LocalDateTime regDate;

    // Reply 테이블
    private Long replyCount;

    // BoardImage 테이블
    private List<BoardImageDTO> boardImages;
}
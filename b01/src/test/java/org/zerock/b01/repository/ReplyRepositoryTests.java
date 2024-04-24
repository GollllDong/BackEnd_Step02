package org.zerock.b01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b01.domain.Board;
import org.zerock.b01.domain.Reply;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testInsert() {

        // 실제 DB에 있는 bno
        Long bno = 100L;

        Board board = Board.builder().bno(bno).build();

        Reply reply = Reply.builder()   // 부모꺼를 insert로 자동으로 가져옴
                .board(board)
                .replyText("댓글...")
                .replyText("replyer1")
                .build();
        replyRepository.save(reply);
    }
    // 실행시 Build and run 설정이 인텔리제이로 되있으면 오류가 발생할 수 있다.
    @Transactional      // 밑의 로직이 종료될 때까지 커넥션이 유지된다.    -> 롤백 특성? 존재?
    @Test
    public void testBoardReplies() {

        Long bno = 100L;

        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());

        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);

        result.getContent().forEach(reply -> {
            log.info(reply);
        });
    }
}

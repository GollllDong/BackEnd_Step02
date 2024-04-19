package org.zerock.b01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.domain.Board;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1,100).forEach(i -> {
            Board board = Board.builder()
                    .title("title..."+i)
                    .content("content..."+i)
                    .writer("user" + (i%10))
                    .build();

            Board result = boardRepository.save(board); // save에서 sql의 insert, update문을 자동으로 생성해서 실행해준다.
            log.info("BNO : " + result.getBno());
        });
    }

    @Test
    public void testSelect() {
        Long bno = 100L;

        Optional<Board> result = boardRepository.findById(bno); // Optional : 안정적으로 처리하고 싶을 때

        Board board = result.orElseThrow();     // orElseThrow() : 예외처리를 할때

        log.info(board);
    }

    @Test
    public void testUpdate() {

        Long bno = 100L;

        Optional<Board> result = boardRepository.findById(bno); // Optional은 도와주는 역할

        Board board = result.orElseThrow(); // 정상일 경우 board에 값을 넘겨주고 아닐경우에 대한 로직추가 가능

        board.change("--update..title 100--", "--update content 100--");

        /*
        * save : pk가 테이블에 존재하지 않으면 => 삽입 => insert문
        *        pk 기존 데이터에 존재하면 => 수정 => update문
        * */
        boardRepository.save(board);
    }

    @Test
    public void testDelete() {
        Long bno = 1L;

        boardRepository.deleteById(bno);
    }
}

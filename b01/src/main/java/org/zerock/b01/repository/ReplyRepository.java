package org.zerock.b01.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.b01.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    /* JPQL의 : bno에는 아래 listOfBoard의 매개변수값인 Long bno값이 전달된다. */
    @Query(" select r from Reply r where r.board.bno = :bno ")
    Page<Reply> listOfBoard(@Param("bno") Long bno, Pageable pageable); // @param("bno"), Long bno는 쿼리문의 bno를 가리킨다.

}

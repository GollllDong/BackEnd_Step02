package org.zerock.springex.mapper;

import com.sun.tools.javac.comp.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex.domain.TodoVO;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;
    // 정상적으로 실행이 성공적으로 완료되면 Mybatis가 TodoMapper의 자식 객체가 빈에 등록했다는 것을 말한다.

    @Test
    public void testGetTime() {
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert() {

        TodoVO todoVO = TodoVO.builder()
                .title("스프링 테스트")
                .dueDate(LocalDate.of(2000,10,10).atStartOfDay())
                .writer("user00")
                .build();

        todoMapper.insert(todoVO);
    }
}

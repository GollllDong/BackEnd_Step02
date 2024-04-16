package org.zerock.springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.mapper.TodoMapper;

@Service
@Log4j2
@RequiredArgsConstructor        // 롬복에서 지원해주는 기능으로 final로 만들려고 사용

public class TodoServiceImpl implements TodoService {

    /*
    * 롬복이 제공하는 @RequiredArgsConstructor에 의해
    * 생성자가 생성되고 Spring Container에 의해서
    * final로 된 타입과 일치하는 bean을 찾아서 주입한다.
     * */

    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);

        // DTO -> VO
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        log.info(todoVO);

        // Dao에 해당하는 todoMapper를 사용하여 DBMS와 통신한다.
        todoMapper.insert(todoVO);
    }
}

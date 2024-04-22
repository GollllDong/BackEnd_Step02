package org.zerock.b01.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    private int page = 1;   // 시작 페이지

    @Builder.Default
    private int size = 10;  // 1개 페이지의 갯수

    private  String type;   // 검색의 종류 t, c, w, tc, tw, twc

    private  String keyword;
    /* type이 "tcw"일 경우
    *  getTypes()는 ["t","c","w"]를 리턴한다.
    * */
    public String[] getTypes() {
        if(type==null || type.isEmpty())
            return null;

        return type.split("");
    }

    public Pageable getPageable(String...props) {
        return PageRequest.of(this.page -1, this.size, Sort.by(props).descending());
    }
    private String link;        // 다른 경로로 움직일 때 원래 페이지의 정보(4번 페이지 -> 수정 -> 4번 페이지)

    public String getLink() {

        if(link == null) {
            StringBuilder builder = new StringBuilder();

            builder.append("page = " + this.page);

            builder.append("$size = " + this.size);

            if(type != null && type.length() > 0) {
                builder.append("$type = " + type);
            }
            if(keyword != null) {
                try {
                    builder.append("$keyword = " + URLEncoder.encode(keyword, "UTF-8"));
                }catch (UnsupportedEncodingException e) {}
            }
            link = builder().toString();
        }
        return link;
    }
}

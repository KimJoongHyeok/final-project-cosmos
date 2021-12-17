package org.kosta.finalproject.studylist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kosta.finalproject.model.domain.CategoryTypeDTO;
import org.kosta.finalproject.model.domain.StudyMemberDTO;
import org.kosta.finalproject.model.mapper.StudyMapper;
import org.kosta.finalproject.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class StudyListTest {

    @Autowired
    private StudyMapper studyMapper;

    @Test
    @DisplayName("스터디 리스트 가져오기")
    void 스터디리스트가저오기(){
        List<StudyMemberDTO> result = studyMapper.getAllStudyList();
        // 3개를 잘 받아 오는지
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).getMemberDTO().getName()).isEqualTo("test3");
        assertThat(result.get(0).getMemberDTO().getPicture()).isEqualTo("test3");
    }


    @Test
    void 검색결과리스트(){
        List<StudyMemberDTO> list = studyMapper.getStudyListByStudyNameAndDesc("d");
        for(int i=0;i<list.size();i++){
            System.out.println("list.get(i) = " + list.get(i));
        }
    }

    
    @Test
    @DisplayName("카테고리버튼검색")
    void 카테고리버튼으로검색(){
        List<Map<String, Object>> result = studyMapper.getStudyListByCategory("언어");
        assertThat(result.size()).isEqualTo(3);
    }
}

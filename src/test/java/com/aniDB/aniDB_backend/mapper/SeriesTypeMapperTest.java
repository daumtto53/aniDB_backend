package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.SeriesType;
import org.apache.ibatis.annotations.Mapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
@ActiveProfiles("test_local")
class SeriesTypeMapperTest {
    @Autowired
    SeriesTypeMapper mapper;

    SeriesType test;

    @BeforeEach
    public void setup() {
        test = SeriesType.builder()
                .typeName("test")
                .build();
        mapper.insertSeriesType(test);
    }

    @Test
    void getSeriesTypeById() {
        SeriesType test1 = mapper.getSeriesTypeById(test.getTypeId());
        Assertions.assertThat(test1.getTypeId()).isEqualTo(test.getTypeId());
    }

    @Test
    void getAllSeriesTypes() {
        List<SeriesType> testList = mapper.getAllSeriesTypes();
        Assertions.assertThat(testList.size()).isEqualTo(4);
    }

    @Test
    void insertSeriesType() {
        SeriesType test1 = SeriesType.builder()
                .typeName("test1")
                .build();
        int cnt = mapper.insertSeriesType(test1);
        Assertions.assertThat(cnt).isEqualTo(1);
        Assertions.assertThat(test1.getTypeName()).isEqualTo("test1");
    }

    @Test
    void updateSeriesType() {
        //TODO
    }

    @Test
    void deleteSeriesType() {
        int cnt = mapper.deleteSeriesType(test.getTypeId());
        Assertions.assertThat(cnt).isEqualTo(1);
        int delCnt = mapper.deleteSeriesType(test.getTypeId());
        Assertions.assertThat(delCnt).isEqualTo(0);

    }
}
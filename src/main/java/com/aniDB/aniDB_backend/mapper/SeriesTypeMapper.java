package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.SeriesType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeriesTypeMapper {
    SeriesType getSeriesTypeById(Long typeId);
    List<SeriesType> getAllSeriesTypes();
    int insertSeriesType(SeriesType seriesType);
    int updateSeriesType(SeriesType seriesType);
    int deleteSeriesType(Long typeId);
}
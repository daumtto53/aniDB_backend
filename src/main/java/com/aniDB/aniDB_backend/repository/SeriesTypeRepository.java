package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.SeriesType;
import com.aniDB.aniDB_backend.mapper.SeriesTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SeriesTypeRepository {

    private final SeriesTypeMapper seriesTypeMapper;

    public SeriesType getSeriesTypeById(Long typeId) {
        return seriesTypeMapper.getSeriesTypeById(typeId);
    }

    public List<SeriesType> getAllSeriesTypes() {
        return seriesTypeMapper.getAllSeriesTypes();
    }

    public int createSeriesType(SeriesType seriesType) {
        return seriesTypeMapper.insertSeriesType(seriesType);
    }

    public int updateSeriesType(SeriesType seriesType) {
        return seriesTypeMapper.updateSeriesType(seriesType);
    }

    public int deleteSeriesType(Long typeId) {
        return seriesTypeMapper.deleteSeriesType(typeId);
    }
}
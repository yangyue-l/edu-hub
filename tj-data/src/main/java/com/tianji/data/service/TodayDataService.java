package com.tianji.data.service;


import com.tianji.data.model.dto.TodayDataDTO;
import com.tianji.data.model.vo.TodayDataVO;

/**
 **/
public interface TodayDataService {

    /**
     * 获取今日数据
     * @return
     */
    TodayDataVO get();

    /**
     * 设置今日数据
     * @param todayDataDTO
     */
    void set(TodayDataDTO todayDataDTO);
}
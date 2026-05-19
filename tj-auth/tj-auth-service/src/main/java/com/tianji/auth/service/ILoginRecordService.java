package com.tianji.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianji.auth.domain.po.LoginRecord;

/**
 * <p>
 * 登录信息记录表 服务类
 * </p>
 **/
public interface ILoginRecordService extends IService<LoginRecord> {

    void saveAsync(LoginRecord record);

    void loginSuccess(String cellphone, Long userId);
}
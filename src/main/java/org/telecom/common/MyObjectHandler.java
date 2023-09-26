package org.telecom.common;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自定义元数据对象处理器 需实现两个方法 分别在insert与update执行
 */
@Component
@Slf4j
public class MyObjectHandler implements MetaObjectHandler
{
    @Override
    public void insertFill(MetaObject metaObject)
    {
        log.info("公共insert字段填充--未使用");
        log.info(metaObject.toString());
    }

    @Override
    public void updateFill(MetaObject metaObject)
    {
        log.info("公共update字段填充--未使用");
        log.info(metaObject.toString());
    }
}

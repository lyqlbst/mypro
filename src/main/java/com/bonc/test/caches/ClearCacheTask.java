package com.bonc.test.caches;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by LinYuQiang on 2018/1/3 0003.
 */
@Component
@EnableScheduling
public class ClearCacheTask {

    private static final Logger logger = Logger.getLogger(ClearCacheTask.class);

    /**
     * 定时清空缓存
     */
    @Scheduled(fixedRate = 5 * 60 * 1000L)
    @CacheEvict(value = {CacheNames.TEST}, allEntries = true)
    public void clearCaches() {
        logger.debug("\n------------ clear " + CacheNames.TEST + " caches ------------\n");
    }
}

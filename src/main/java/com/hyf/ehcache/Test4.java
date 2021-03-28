package com.hyf.ehcache;


import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.*;
import org.ehcache.config.units.MemoryUnit;

import java.io.File;
import java.net.URL;
import java.time.Duration;

/**
 * @author baB_hyf
 * @date 2021/03/24
 */
public class Test4 {

    public static void main(String[] args) throws InterruptedException {
        String path = Test4.class.getResource("/").getPath();
        System.out.println(path);
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence(new File(path)))
                .build(true);

        Cache<String, String> cache = cacheManager.createCache("t", CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, String.class, ResourcePoolsBuilder.newResourcePoolsBuilder().disk(100, MemoryUnit.KB, true))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(5))));

        cache.put("a", "a");
        System.out.println(cache.get("a"));

        Thread.sleep(5000);

        System.out.println(cache.get("a"));

        cacheManager.close();

    }
}

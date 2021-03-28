package com.hyf.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * 官方文档：https://www.ehcache.org/documentation/3.8
 * <p>
 * 2.x -> net.sf.ehcache
 * 3.x -> org.ehcache
 *
 * @author baB_hyf
 * @date 2021/03/23
 */
public class Test {

    public static void main(String[] args) {

        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured", CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class,
                        String.class, ResourcePoolsBuilder.heap(100) /* off heap 堆外内存 */).build())
                .build(true); // 自动初始化

        Cache<Long, String> preConfigured = cacheManager.getCache("preConfigured", Long.class, String.class);

        Cache<Long, String> myCache = cacheManager.createCache("myCache", CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(100)).build());

        System.out.println(preConfigured.get(1L));

        myCache.put(1L, "da one!");
        String value = myCache.get(1L);
        System.out.println(value);

        // null
        // Cache<String, String> cache = cacheManager.getCache("111", String.class, String.class);
        // System.out.println(cache);

        cacheManager.close();

    }

}

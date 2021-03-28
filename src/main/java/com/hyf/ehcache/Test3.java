package com.hyf.ehcache;

import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

import java.net.URL;

/**
 * @author baB_hyf
 * @date 2021/03/24
 */
public class Test3 {

    public static void main(String[] args) {
        URL myUrl = Test3.class.getResource("/ehcache.xml");
        Configuration xmlConfig = new XmlConfiguration(myUrl);
        CacheManager myCacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        myCacheManager.init();
        // myCacheManager.init();
        System.out.println(myCacheManager);

    }
}

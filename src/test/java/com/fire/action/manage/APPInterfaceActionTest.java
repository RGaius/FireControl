package com.fire.action.manage;

import com.fire.po.CacheData;
import com.fire.po.TableData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by BZhao on 2017/3/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class APPInterfaceActionTest {
    @Autowired
    APPInterfaceAction action;
    @Test
    public void uploadCacheData() throws Exception {



    }

}
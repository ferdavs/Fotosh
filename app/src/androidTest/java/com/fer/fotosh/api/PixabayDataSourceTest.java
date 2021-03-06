package com.fer.fotosh.api;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.fer.fotosh.data.DataSource;
import com.fer.fotosh.util.Helper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by f on 7/22/17.
 */
@RunWith(AndroidJUnit4.class)
public class PixabayDataSourceTest {

    Context context = InstrumentationRegistry.getTargetContext();

    @Inject
    DataSource dataSource;

    @Test
    public void searchEmpty() throws Exception {
        if (Helper.isNetworkAvailable(context)) {
//            dataSource.searchImage("").doOnComplete(i->);
//            Assert.assertTrue(res.size() > 0);
        } else
            Assert.fail("No Network");

    }

    @Test
    public void searchCat() throws Exception {
        if (Helper.isNetworkAvailable(context)) {
//            List<ImageItem> res = dataSource.search("cat");
//            Assert.assertTrue(res.size() > 0);
        } else
            Assert.fail("No Network");
    }

}
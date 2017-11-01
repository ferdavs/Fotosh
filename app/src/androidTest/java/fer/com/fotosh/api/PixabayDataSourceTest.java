package fer.com.fotosh.api;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import fer.com.fotosh.Helper;

/**
 * Created by f on 7/22/17.
 */
@RunWith(AndroidJUnit4.class)
public class PixabayDataSourceTest {

    Context context = InstrumentationRegistry.getTargetContext();
    DataSource dataSource = new PixabayDataSource();

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
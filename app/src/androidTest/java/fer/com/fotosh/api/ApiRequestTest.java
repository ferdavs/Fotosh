package fer.com.fotosh.api;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import fer.com.fotosh.Helper;
import fer.com.fotosh.data.model.ImageItemList;

/**
 * Created by f on 7/22/17.
 */
@RunWith(AndroidJUnit4.class)
public class ApiRequestTest {
    Context context = InstrumentationRegistry.getTargetContext();


    @Test
    public void executeEmptyUrl() throws Exception {
        if (Helper.isNetworkAvailable(context)) {
            String url = "";
            ImageItemList imageItemList = ApiRequest.run().execute(url).get();
            Assert.assertTrue(imageItemList.hits().size() == 0);

        } else
            Assert.fail("No Network");

    }

    @Test
    public void executeQueryCat() throws Exception {
        if (Helper.isNetworkAvailable(context)) {
            String url = "https://pixabay.com/api/?" +
                    "key=5932369-98914f23226be434a04032bff" +
                    "&image_type=photo" +
                    "&per_page=50" +
                    "&q=cat";
            ImageItemList imageItemList = ApiRequest.run().execute(url).get();
            Assert.assertTrue(imageItemList.hits().size() > 0);
        } else
            Assert.fail("No Network");
    }

    @Test
    public void executeEmtyQuery() throws Exception {
        if (Helper.isNetworkAvailable(context)) {
            String url = "https://pixabay.com/api/?" +
                    "key=5932369-98914f23226be434a04032bff" +
                    "&image_type=photo" +
                    "&per_page=50";
            ImageItemList imageItemList = ApiRequest.run().execute(url).get();
            Assert.assertTrue(imageItemList.hits().size() > 0);
        } else
            Assert.fail("No Network");
    }
}
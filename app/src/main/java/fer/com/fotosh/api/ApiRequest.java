package fer.com.fotosh.api;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import fer.com.fotosh.data.json.EntityTypeAdapterFactory;
import fer.com.fotosh.data.model.ImageItemList;
import timber.log.Timber;

/**
 * Created by f on 7/18/17.
 */
@Deprecated
public class ApiRequest extends AsyncTask<String, Void, ImageItemList> {

    //TODO use DI
    Gson gson = new GsonBuilder()
            .setLenient()
            .registerTypeAdapterFactory(EntityTypeAdapterFactory.create())
            .create();

    private ApiRequest() {
    }

    static ApiRequest run() {
        return new ApiRequest();
    }

    protected ImageItemList doInBackground(String... urls) {
        String urldisplay = urls[0];
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new java.net.URL(urldisplay).openStream()))) {


            return ImageItemList.typeAdapter(gson).fromJson(reader);
        } catch (Exception e) {
            Timber.e(e);
        }
        return null;
    }
}

package fer.com.fotosh.api;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import fer.com.fotosh.model.ImageItemList;

/**
 * Created by f on 7/18/17.
 */
class ApiRequest extends AsyncTask<String, Void, ImageItemList> {

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
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            return new Gson().fromJson(sb.toString(), ImageItemList.class);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
//            e.printStackTrace();
//                    Toast.makeText(view.getContext(),
//                "Clicked Position = " + getAdapterPosition(), Toast.LENGTH_SHORT)
//                         .show();

        }
        return new ImageItemList();
    }
}

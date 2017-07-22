package fer.com.fotosh.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import fer.com.fotosh.model.ImageItem;

/**
 * Created by f on 7/19/17.
 */

public class MockDataSource implements DataSource {
    @Override
    public List<ImageItem> search(String term) throws ExecutionException, InterruptedException {
        return getListItemData();
    }

    private List<ImageItem> getListItemData() {
        List<ImageItem> listViewItems = new ArrayList<>();
        listViewItems.add(new ImageItem("1984", "George Orwell"));
        listViewItems.add(new ImageItem("Pride and Prejudice", "Jane Austen"));
        listViewItems.add(new ImageItem("One Hundred Years of Solitude", "Gabriel Garcia Marquez"));
        listViewItems.add(new ImageItem("The Book Thief", "Markus Zusak"));
        listViewItems.add(new ImageItem("The Hunger Games", "Suzanne Collins"));
        listViewItems.add(new ImageItem("The Hitchhiker's Guide to the Galaxy", "Douglas Adams"));
        listViewItems.add(new ImageItem("The Theory Of Everything", "Dr Stephen Hawking"));

        return listViewItems;
    }
}

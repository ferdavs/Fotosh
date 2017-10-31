package fer.com.fotosh.model.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by f on 10/31/17.
 */

public abstract class BaseItemList<V> {
    protected int total;
    protected int totalHits;

    protected List<V> hits = new ArrayList<>();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<V> getHits() {
        return hits;
    }

    public void setHits(List<V> hits) {
        this.hits = hits;
    }
}

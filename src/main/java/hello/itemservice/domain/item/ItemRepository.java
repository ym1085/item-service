package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // 실제로는 HashMap 사용하면 안됨
    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L; // static

    /**
     * 상품 저장
     * @param item
     * @return
     */
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    /**
     * 단일 상품 조회
     * @param id
     * @return
     */
    public Item findById(Long id) {
        return store.get(id);
    }

    /**
     * 전체 상품 조회
     * @return
     */
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * 상품 정보 갱신
     * @param itemId
     * @param updateParam
     */
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    /**
     * 상품 정보 제거
     */
    public void clearStore() {
        store.clear();
    }
}

package myBlog.mvc.domain;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TextRepository {

    private final Map<Long, Text> store = new HashMap<>();
    public static long sequence = 0L;

    public Text save(Text text) {
        text.setId(++sequence);
        store.put(text.getId(), text);

        return text;
    }

    public Text findById(Long textId) {
        Text text = store.get(textId);
        return text;
    }

    public List<Text> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long textId, Text updateParam) {
        Text text = store.get(textId);
        text.setTitle(updateParam.getTitle());
        text.setDetail(updateParam.getDetail());
    }

    public void remove(Long textId) {
        store.remove(textId);
    }

    public void clear() {
        store.clear();
    }
}

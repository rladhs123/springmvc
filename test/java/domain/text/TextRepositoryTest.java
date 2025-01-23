package domain.text;

import myBlog.mvc.domain.Text;
import myBlog.mvc.domain.TextRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TextRepositoryTest {

    TextRepository textRepository = new TextRepository();

    @AfterEach
    void afterEach() {
        textRepository.clear();
    }

    @Test
    void save() {
        //given
        Text text = new Text("A", "a");
        //when
        textRepository.save(text);
        //then
        assertThat(text.getTitle()).isEqualTo("A");
    }

    @Test
    void findAll() {
        //given
        Text text1 = new Text("A", "a");
        Text text2 = new Text("B", "b");
        textRepository.save(text1);
        textRepository.save(text2);
        //when
        List<Text> texts = textRepository.findAll();
        //then
        assertThat(texts).contains(text1, text2);
    }

    @Test
    void update() {
        //given
        Text text1 = new Text("A", "a");
        Text text2 = new Text("B", "b");
        textRepository.save(text1);
        textRepository.save(text2);
        Long textId = text1.getTextId();
        //when
        textRepository.update(textId, text2);
        //then
        assertThat(text1.getTitle()).isEqualTo(text2.getTitle());
    }

    @Test
    void remove() {
        //given
        Text text = new Text("A", "a");
        textRepository.save(text);
        Long textId = text.getTextId();
        //when
        textRepository.remove(textId);
        //then
        assertThat(textRepository.findById(textId)).isNotSameAs(text);
    }
}

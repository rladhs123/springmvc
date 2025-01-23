package myBlog.mvc.domain;

import lombok.Data;

@Data
public class Text {

    private Long id;
    private String title;
    private String detail;

    public Text() {
    }

    public Text(String title, String text) {
        this.title = title;
        this.detail = text;
    }
}

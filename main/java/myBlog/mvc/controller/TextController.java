package myBlog.mvc.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import myBlog.mvc.domain.Text;
import myBlog.mvc.domain.TextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basic/texts")
public class TextController {

    private final TextRepository textRepository;

    //글 목록 조회
    @GetMapping()
    public String texts(Model model) {
        List<Text> texts = textRepository.findAll();
        model.addAttribute("texts", texts);

        return "basic/texts";
    }

    //글 정보 조회
    @GetMapping("{textId}")
    public String text(@PathVariable("textId") Long textId, Model model) {
        Text text = textRepository.findById(textId);
        model.addAttribute("text", text);

        return "basic/text";
    }

    //글 등록 폼 조회
    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    //글 등록 처리
    @PostMapping("/add")
    public String addText(@ModelAttribute("text") Text text) {
        textRepository.save(text);
        return "redirect:/basic/texts/" + text.getId();
    }

    @PostConstruct
    public void init() {
        textRepository.save(new Text("A", "a"));
        textRepository.save(new Text("B", "b"));
    }
}

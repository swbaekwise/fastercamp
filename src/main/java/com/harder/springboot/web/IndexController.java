package com.harder.springboot.web;

import com.harder.springboot.service.posts.PostsService;
import com.harder.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        // Model 라이브러리를 통해, postsService.findAllDesc()의 결과를 posts로 index.mustache에 전달해준다
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
        // mustache 템플릿 엔진에 의해 String 값의 뒤에 .mustache 확장자가 붙어서
        // src > main > resources > templates 경로에 파일로 전환 및 저장되고, 이것을 View Resolver가 처리
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
        // 마찬가지로, "/posts/save"를 호출 시 posts-save.mustache를 호출하도록 메서드 구성
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}

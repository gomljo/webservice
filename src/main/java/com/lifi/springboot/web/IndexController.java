package com.lifi.springboot.web;

import com.lifi.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        // postsService.findAllDesc()로 가져온 결과를 index.mustache 내의 '#posts'로 전달하는 역할
        // index.mustache를 살펴보면 반복문으로 모든 게시글을 조회하는 부분이 있으며 그곳에 #posts 변수가 있다.
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

}

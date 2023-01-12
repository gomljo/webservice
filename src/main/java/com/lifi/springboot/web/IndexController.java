package com.lifi.springboot.web;

import com.lifi.springboot.config.auth.LoginUser;
import com.lifi.springboot.config.auth.dto.SessionUser;
import com.lifi.springboot.service.posts.PostsService;
import com.lifi.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());
        // postsService.findAllDesc()로 가져온 결과를 index.mustache 내의 '#posts'로 전달하는 역할
        // index.mustache를 살펴보면 반복문으로 모든 게시글을 조회하는 부분이 있으며 그곳에 #posts 변수가 있다.
        if (user!= null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}

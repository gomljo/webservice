package com.lifi.springboot.service.posts;

import com.lifi.springboot.domain.posts.Posts;
import com.lifi.springboot.domain.posts.PostsRepository;
import com.lifi.springboot.web.dto.PostsResponseDto;
import com.lifi.springboot.web.dto.PostsSaveRequestDto;
import com.lifi.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){

        Posts posts = postsRepository.findById(id)
                        .orElseThrow(()->new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)

    // @Transactional(readOnly = true)
    // 트랜잭션의 범위는 유지하되, 조회 기능만 남겨두어 조회속도가 개선되기 때문에 등록, 수정, 삭제 기능이
    // 전혀 없는 서비스 메소드에서 사용할 수 있다고 한다. - 스프링부트와 AWS로 혼자 구현하는 웹 서비스 책에서 인용 -

    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    public  PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}

package com.harder.springboot.web.dto;

import com.harder.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
    // Entity의 필드 중 일부(id, title, content, author)만 사용할 것이므로 생성자로 Entity를 받아 필드에 값을 넣는다.
}

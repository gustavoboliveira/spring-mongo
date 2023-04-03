package com.gustavoboliveira.springmongo.entities;

import com.gustavoboliveira.springmongo.dtos.AuthorDto;
import com.gustavoboliveira.springmongo.dtos.CommentDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "post")
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NonNull
    private Date date;

    @NonNull
    private String title;

    @NonNull
    private String body;

    @NonNull
    private AuthorDto author;

    private List<CommentDto> comments = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getId().equals(post.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

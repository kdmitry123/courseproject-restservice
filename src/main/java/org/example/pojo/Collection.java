package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Indexed
public class Collection implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    private String image;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL)
    private List<Comment> comment;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL)
    private List<Tag> tag;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL)
    private List<Book> book;

    public Collection(String name, String description, String image, User user) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.user = user;
    }
}

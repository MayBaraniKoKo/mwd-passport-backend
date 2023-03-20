package com.example.mwdpassportbe.entity;

import com.example.blogproject.constant.Tag;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author maybaranikoko
 * @since 20-Mar-23
 * Purpose:
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REGISTRATION")
public class Registration {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Column(name = "TITLE")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "TAG")
    private Tag tag;

    @Lob
    @Column(name = "CONTENT", length = 5000)
    private String content;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "CATEGORY_MENU_ID")
    private String categoryMenuId;

    @Column(name = "CREATED_AT")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Rangoon")
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Rangoon")
    private Timestamp updatedAt;

}

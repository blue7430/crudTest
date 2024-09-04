package com.example.crudTest;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CrudDTO {
    private Integer post_id;
    private Integer user_id;
    private String title;
    private String content;
    private Timestamp create_at;
    private Timestamp updated_at;
}

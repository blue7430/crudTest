package com.example.crudTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CrudService {

    private final CrudRepository crudRepository;

    public void addpost(Integer user_id, String title, String content){
        Crud crud = new Crud();
        crud.setUser_id(user_id);
        crud.setTitle(title);
        crud.setContent(content);
        crudRepository.save(crud);
    }
}

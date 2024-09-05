package com.example.crudTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

    public void updatepost(Integer post_id, Integer user_id, String title, String content) {
        Optional<Crud> result = crudRepository.findById(post_id);
        if (result.isPresent()) {
            Crud crud = result.get();   //기존 객체 호출
            crud.setTitle(title);
            crud.setContent(content);
            crudRepository.save(crud);
        }
    }
}

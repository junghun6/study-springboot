package com.study.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    // DB 레포지토리 설정
    private final ItemRepository itemRepository;
    private final ItemService itemService;


    @GetMapping("/list")
    String list (Model model) {

        List<Item> result = itemRepository.findAll();


        model.addAttribute("items", result);
        return "list.html";
    }

    @GetMapping("/write")
    String write () {


        return "write.html";
    }

    @PostMapping("/add")
    String addPost (String title, Integer price) {

        itemService.saveItem(title, price);

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail (@PathVariable Integer id, Model model) {
        
        // Optional = item이 있거나 비어 있을 수 있을떄
       Optional<Item> result =  itemRepository.findById(id.longValue());

       // Optional은 데이터 체크하고 가져와야함
       if ( result.isPresent()) {
           System.out.println(result.get());
           model.addAttribute("item", result.get());
       }



        return "detail.html";
    }

    @GetMapping("/edit/{id}")
    String edit (@PathVariable Integer id, Model model) {

        // Optional = item이 있거나 비어 있을 수 있을떄
        Optional<Item> result =  itemRepository.findById(id.longValue());

        // Optional은 데이터 체크하고 가져와야함
        if ( result.isPresent()) {
            System.out.println(result.get());
            model.addAttribute("item", result.get());
        }

        return "edit.html";
    }

    @PostMapping("/edit/{id}")
    String updateItem (@PathVariable Integer id, String title, Integer price) {

        Optional<Item> optionalItem = itemRepository.findById(id.longValue());

        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();  // 기존 아이템 가져오기
            item.setTitle(title);           // 제목 업데이트
            item.setPrice(price);            // 가격 업데이트
            itemRepository.save(item);        // 수정된 아이템 저장
        }

        return "redirect:/list";
    }



}

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.EmployeeService;

/**
 * 従業員のコントローラークラス
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 従業員一覧をブラウザに表示するメソッド
     * @param model htmlとのバインド用の変数
     * @return  リスト画面に遷移
     */
    @GetMapping("/showList")
    public String showList(Model model){
        model.addAttribute("employeeList", employeeService.showList());
        return "employee/list";

    }
    
    
}

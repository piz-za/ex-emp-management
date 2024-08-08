package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;

import jakarta.servlet.http.HttpSession;



/**
 * 管理者関連のコントローラークラス
 */
@Controller
@RequestMapping("/")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private HttpSession session;
    /**
     * 管理者登録画面にフォワードするメソッド
     * @return administrator/insert.htmlに遷移
     */
    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form,Model model){
        model.addAttribute("insertAdministratorForm",new InsertAdministratorForm());
        return "administrator/insert";
    }

    /**
     * 管理者登録画面の入力内容をDBに登録するために
     * 入力内容をAdministratorクラスのオブジェクトにコピーし、
     * DB登録メソッドを呼び出すメソッド
     * @param form ブラウザで入力された管理者情報
     * @return administrator/login.htmlに遷移
     */
    @PostMapping("/insert")
    public String insert(@ModelAttribute InsertAdministratorForm form){
        Administrator administrator=new Administrator();
        administrator.setName(form.getName());
        administrator.setMailAddress(form.getMailAddress());
        administrator.setPassword(form.getPassword());
        administratorService.insert(administrator);
        return "redirect:/";
    }

     /**
     * ログイン画面にフォワードするメソッド
     * @return administrator/login.htmlに遷移
     */
    @GetMapping("/")
    public String toLogin(LoginForm form){
        return "administrator/login";
    }

    /**
     * ログイン画面にフォワードするメソッド
     * @param form ログイン画面の情報
     * @return administrator/login.htmlかadministrator/employee/showListに遷移
     */
    @PostMapping("/login")
    public String login(LoginForm form,Model model){

        Administrator administrator=administratorService.login(form.getMailAddress(),form.getPassword());

        if(administrator!=null){
            session.setAttribute("administratorName",administrator.getMailAddress());
            return "redirect:/employee/showList";
        }else{
            model.addAttribute("errorMessage", "メールアドレスまたはパスワードが不正です。");
            return "administrator/login";
        }
    }
}

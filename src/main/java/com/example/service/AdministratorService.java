package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;


/**
 * 管理者のサービスクラス
 */
@Service
@Transactional
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;
    /**
     * ブラウザで入力された管理者情報をDBに登録する管理者リポジトリクラスのメソッドを呼び出す
     * メソッド
     * @param administrator
     */
    public void insert(Administrator administrator){
        administratorRepository.insert(administrator);
    }

}

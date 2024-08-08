package com.example.service;

import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *従業員のサービスクラス
 */
@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    /**
     * 従業員リストを作成するメソッド
     * @return 従業員リストを呼び出し元に返す
     */
    public List<Employee> showList(){
        return employeeRepository.findAll();
    }   
}

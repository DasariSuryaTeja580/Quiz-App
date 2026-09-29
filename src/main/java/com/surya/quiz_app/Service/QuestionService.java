package com.surya.quiz_app.Service;

import com.surya.quiz_app.Model.Question;
import com.surya.quiz_app.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<Question>> getByCategory(String keyword) {
        return new ResponseEntity<>(questionDao.findByCategory(keyword),HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(Question question) {
         questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}

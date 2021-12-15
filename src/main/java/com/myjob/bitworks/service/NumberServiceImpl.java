package com.myjob.bitworks.service;

import com.myjob.bitworks.model.Number;
import com.myjob.bitworks.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class NumberServiceImpl implements NumberService {

    @Autowired
    private NumberRepository numberRepository;

    @Override
    public void create(Number number) {
        numberRepository.save(number);
    }

    @Override
    public List<Number> readAll() {
        return numberRepository.findAll();
    }

    @Override
    public Number read(int number) {


        final List<Number> NUMBER_REPOSITORY_LIST = readAll();

        NUMBER_REPOSITORY_LIST.sort(Number::compareTo);
        int maxI = NUMBER_REPOSITORY_LIST.size() > 0 ? NUMBER_REPOSITORY_LIST.get(NUMBER_REPOSITORY_LIST.size() - 1).getPrimeNumber() : 0;
        int answer = maxI;

        if(NUMBER_REPOSITORY_LIST.size() > 0 && maxI > number) {
            for (Number i : NUMBER_REPOSITORY_LIST) {
                if(i.getPrimeNumber() < number) {
                    answer = i.getPrimeNumber();
                } else {
                    break;
                }
            }
        } else {
            boolean[] a = new boolean[number];

            for (int i = 2; i < number; i++) {
                a[i] = true;
            }

            for (int i = 2; i < number; i++) {
                if (a[i] != false) {
                    for (int j = i; new BigDecimal(i).multiply(BigDecimal.valueOf(j)).compareTo(BigDecimal.valueOf(number)) == -1; j++) {
                        a[i * j] = false;
                    }
                }
            }

            for (int i = 2; i < number; i++) {
                if (a[i] && i > maxI) {
                    Number m = new Number();
                    m.setPrimeNumber(i);
                    create(m);
                    answer = i;
                }
            }
        }

        Number numberAnswer = new Number();
        numberAnswer.setPrimeNumber(answer);
        numberAnswer.setRequestedX(number);

        return numberAnswer;
    }
}

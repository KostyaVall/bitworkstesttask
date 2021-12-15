package com.myjob.bitworks.service;

import com.myjob.bitworks.model.Number;

import java.util.List;

public interface NumberService {

    Number read(int number);

    void create(Number number);

    List<Number> readAll();
}

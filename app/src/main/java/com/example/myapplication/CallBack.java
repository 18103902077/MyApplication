package com.example.myapplication;

public interface CallBack<T> {
    void getData(T t);
    void getError(String error);
}

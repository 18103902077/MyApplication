package com.example.myapplication.base;

public abstract class BasePresenter<V extends Baseview,M extends BaseModel> {
    protected V view;
    protected M model;

    public BasePresenter(V view) {
        this.view = view;
        model=initModel();
    }

    protected abstract M initModel();

    public void distroy(){
        view=null;
    }
}

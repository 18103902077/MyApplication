package com.example.myapplication.base;

//此类为抽取Fragment中，初始化p成的方法，得到p层对象
public abstract class BaseMvpInitPreFragment<P extends BasePresenter> extends BaseFragment {
    protected P presenter;

    @Override
    protected void initPresent() {//重写父类中初始化p层方法，传值给成员变量presenter
        presenter=initPresenter();//定义抽象方法获取p对象
    }

    protected abstract P initPresenter();//定义抽象方法获取p对象，由子类返回

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter=null;//p对象置为空
    }
}

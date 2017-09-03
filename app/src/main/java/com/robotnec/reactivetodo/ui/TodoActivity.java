package com.robotnec.reactivetodo.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;

import com.robotnec.reactivetodo.R;
import com.robotnec.reactivetodo.mvp.presenter.TodoPresenter;
import com.robotnec.reactivetodo.mvp.view.TodoView;

import butterknife.BindView;

public class TodoActivity extends BasePresenterActivity<TodoPresenter, TodoView> {

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(view ->
                presenter.onFabClick());
    }

    @Override
    protected TodoPresenter createPresenter() {
        return new TodoPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_todo;
    }
}

package com.robotnec.reactivetodo.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding2.view.RxView;
import com.robotnec.reactivetodo.R;
import com.robotnec.reactivetodo.core.model.TodoModel;
import com.robotnec.reactivetodo.core.model.event.AddTodoEvent;
import com.robotnec.reactivetodo.core.model.event.RemoveTodoEvent;
import com.robotnec.reactivetodo.core.model.event.TodoEvent;
import com.robotnec.reactivetodo.core.mvp.presenter.TodoPresenter;
import com.robotnec.reactivetodo.core.mvp.view.TodoView;
import com.robotnec.reactivetodo.ui.adapter.TodoAdapter;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class TodoActivity extends BasePresenterActivity<TodoPresenter, TodoView> implements TodoView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.addTodoButton)
    Button addTodoButton;

    @BindView(R.id.removeTodoButton)
    Button removeTodoButton;

    @BindView(R.id.todoEditText)
    EditText todoEditText;

    @BindView(R.id.todosRecycler)
    RecyclerView todosRecycler;

    private TodoAdapter todoAdapter;

    private final CompositeDisposable compositeDisposable;

    public TodoActivity() {
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);

        todoAdapter = new TodoAdapter(this);
        todosRecycler.setLayoutManager(new LinearLayoutManager(this));
        todosRecycler.setAdapter(todoAdapter);

        Observable<TodoEvent> events = Observable.merge(
                RxView.clicks(addTodoButton)
                        .map(ignored -> todoEditText.getText().toString())
                        .map(AddTodoEvent::new),
                RxView.clicks(removeTodoButton)
                        .map(ignored -> 0L)
                        .map(RemoveTodoEvent::new)
        );

        compositeDisposable.add(presenter.connect(events).subscribe(this::render));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    @Override
    protected TodoPresenter createPresenter() {
        return new TodoPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_todo;
    }

    private void render(TodoModel todoModel) {
        todoAdapter.setItems(todoModel.getTodos());
    }
}

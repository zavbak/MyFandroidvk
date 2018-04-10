package ru.a799000.alexander.fandroidvk.model.view.counter;

import ru.a799000.alexander.fandroidvk.model.Comments;

public class CommentCounterViewModel extends CounterViewModel{

    private Comments mComments;

    public CommentCounterViewModel(Comments comments) {
        super(comments.getCount());

        this.mComments = comments;
    }

    public Comments getComments() {
        return mComments;
    }
}

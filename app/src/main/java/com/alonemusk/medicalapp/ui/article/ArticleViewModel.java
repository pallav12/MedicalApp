package com.alonemusk.medicalapp.ui.article;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArticleViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ArticleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Article fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

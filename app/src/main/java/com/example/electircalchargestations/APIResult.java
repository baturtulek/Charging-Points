package com.example.electircalchargestations;
import java.util.List;

public class APIResult<T> {

    private T          singleResult;
    private List<T>    listResult;
    private Throwable  throwable;
    private boolean    hasError;

    public APIResult(T singleResult) {
        this.singleResult = singleResult;
    }

    public APIResult(List<T> data) {
        this.listResult   = data;
    }

    public APIResult(Throwable throwable) {
        this.throwable      = throwable;
        this.hasError       = true;
    }

    public T getSingleResult() { return singleResult; }

    public void setSingleResult(T singleResult) { this.singleResult = singleResult; }

    public List<T> getListResult() { return listResult; }

    public void setListResult(List<T> listResult) { this.listResult = listResult; }

    public Throwable getThrowable() { return throwable; }

    public void setThrowable(Throwable throwable) { this.throwable = throwable; }

    public boolean HasError() { return hasError; }

}

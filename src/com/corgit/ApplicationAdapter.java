package com.corgit;

public interface ApplicationAdapter {
    void prepare(Buffer frame);

    int update(Buffer frame);
}

package com.hc.collections;

import java.util.ArrayList;

public class FastRemoveArrayList<E> extends ArrayList<E> {

    public FastRemoveArrayList() {
        super();
    }

    @Override
    public E remove(int index) {
        E item = get(size()-1);
        set(index, item);
        return super.remove(size()-1);
    }
}
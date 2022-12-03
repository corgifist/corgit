package com.corgit.util;

import java.util.ArrayList;

public class LinearMap<K, V> {

    private ArrayList<LinearScope<K, V>> binds;

    public LinearMap() {
        this.binds = new ArrayList<>();
    }

    public V put(K key, V value) {
        ArrayList<LinearScope<K, V>> newBinds = new ArrayList<>();
        for (LinearScope<K, V> bind : binds) {
            if (!bind.getKey().equals(key)) {
                newBinds.add(bind);
            }
        }

        newBinds.add(new LinearScope<K, V>(key, value));
        binds = newBinds;
        return value;
    }

    public V get(K key) {
        for (LinearScope<K, V> bind : binds) {
            if (bind.getKey().equals(key)) return bind.getValue();
        }
        return null;
    }

    public ArrayList<V> getValues() {
        ArrayList<V> result = new ArrayList<>();
        for (LinearScope<K, V> bind : binds) {
            result.add(bind.getValue());
        }
        return result;
    }

    public ArrayList<LinearScope<K, V>> getBinds() {
        return binds;
    }

    public void setBinds(ArrayList<LinearScope<K, V>> binds) {
        this.binds = binds;
    }
}

package com.ntoproject.editables.space;

public class Center implements Owner{
    private Center(){}

    private final static Center instance = new Center();
    public static Center getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return "Культурный центр";
    }
}

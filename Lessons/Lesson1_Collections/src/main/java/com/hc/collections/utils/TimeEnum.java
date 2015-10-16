package com.hc.collections.utils;

public enum TimeEnum {
    SEC("sec", 1_000_000_000),
    MS("ms", 1_000_000),
    NANO("ns", 1);

    private final String name;
    private final long scale;

    TimeEnum(String name, long scale) {
        this.name = name;
        this.scale = scale;
    }

    public long getScale() {
        return scale;
    }

    @Override
    public String toString() {
        return name;
    }
}

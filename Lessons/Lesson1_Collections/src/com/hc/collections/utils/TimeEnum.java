package com.hc.collections.utils;

public enum TimeEnum {
    SEC {
        public long getScale() { return 1_000_000_000; }
    },

    MS {
        public long getScale() { return 1_000_000; }
    },

    NANO {
        public long getScale() { return 1; }
    };

    public abstract long getScale();
}

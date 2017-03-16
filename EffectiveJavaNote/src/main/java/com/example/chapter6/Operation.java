package com.example.chapter6;

/**
 * auther: baiiu
 * time: 17/3/16 16 07:11
 * description:
 */

// @formatter:off
public enum Operation {
    PLUS {
        @Override double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override double apply(double x, double y) {
            return x / y;
        }
    };

    abstract double apply(double x, double y);

    @Override public String toString() {
        return super.toString();
    }}
// @formatter:on

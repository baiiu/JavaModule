package com.example.chapter6;

/**
 * auther: baiiu
 * time: 17/3/16 16 07:11
 * description:
 */

// @formatter:off
public enum Operation implements IOperation{
    PLUS {
        @Override public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override public double apply(double x, double y) {
            return x / y;
        }
    };

    @Override public String toString() {
        return super.toString();
    }

    private static <T extends Operation> void test(Class<T> tClass,double x,double y){

    }

}
// @formatter:on

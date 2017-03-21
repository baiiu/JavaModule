package com.example.charpter7;

import java.util.Date;

/**
 * author: baiiu
 * date: on 17/3/18 12:44
 * description:
 */
public class Period {
    private final Date mStart;
    private final Date mEnd;

    //复写override
    @Override public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //重载override
    //public boolean equals(Date obj) {
    //    return super.equals(obj);
    //}

    public Period(Date start, Date end) {
        this.mStart = new Date(start.getTime());
        this.mEnd = new Date(end.getTime());

        if (mStart.compareTo(mEnd) > 0) {
            throw new IllegalArgumentException("start must be ahead of end");
        }
    }

    public Date getmStart() {
        return new Date(mStart.getTime());
    }

    public Date getmEnd() {
        return new Date(mEnd.getTime());
    }
}

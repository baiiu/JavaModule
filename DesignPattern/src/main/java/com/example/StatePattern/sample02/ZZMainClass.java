package com.example.StatePattern.sample02;

/**
 * auther: baiiu
 * time: 18/12/21 21 07:47
 * description:
 * https://www.cnblogs.com/java-my-life/archive/2012/06/08/2538146.html
 *
 * 考虑一个在线投票系统的应用，要实现控制同一个用户只能投一票：
 * 如果一个用户反复投票，而且投票次数超过5次，则判定为恶意刷票，要取消该用户投票的资格，当然同时也要取消他所投的票；
 * 如果一个用户的投票次数超过8次，将进入黑名单，禁止再登录和使用系统。
 */
class ZZMainClass {
    public static void main(String[] args) {
        VoteManager vm = new VoteManager();
        for (int i = 0; i < 9; i++) {
            vm.vote("u1", "A");
        }
    }
}

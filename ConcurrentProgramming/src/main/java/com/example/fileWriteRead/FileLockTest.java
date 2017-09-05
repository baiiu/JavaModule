package com.example.fileWriteRead;

import java.io.File;

/**
 * author: baiiu
 * date: on 17/9/5 16:35
 * description: 文件锁
 * <p>
 * 场景：
 * IntentService写文件(下载、解压、写文件)
 * 不是操作的同一个文件、而是一整个目录
 * <p>
 * UI线程读取该文件(确保要读取到完整的文件)
 * <p>
 * demo:
 * FileWriteRunnable将.zip文件解压到asset中
 * FileReadRunnable读取asset
 */
public class FileLockTest {

    public static void main(String[] args) {
        File file = new File("ConcurrentProgramming/asset");
        FileUtil.deleteDir(file);

        new Thread(new FileWriteRunnable()).start();
        new Thread(new FileReadRunnable()).start();
    }


}

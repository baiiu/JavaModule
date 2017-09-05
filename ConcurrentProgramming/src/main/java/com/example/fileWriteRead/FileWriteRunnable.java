package com.example.fileWriteRead;

import java.io.File;
import java.io.IOException;

/**
 * author: baiiu
 * date: on 17/9/5 17:12
 * description:
 */
class FileWriteRunnable implements Runnable {

    private static volatile boolean isDone = false;

    @Override
    public void run() {
        try {
            unzipOld();
            unzipNew();
            deleteOld();

        } catch (Exception e) {
            e.printStackTrace();
        }

        isDone = true;
        System.out.println("FileWriteRunnable: 写完了");
    }

    private void deleteOld() {
        File file = new File("ConcurrentProgramming/asset/old");
        FileUtil.deleteDir(file);
    }

    private void unzipOld() throws IOException {
        File file = new File("ConcurrentProgramming/asset/old");
        File originalFile = new File("ConcurrentProgramming/new.zip");
        FileUtil.UnZipFolder(originalFile.getAbsolutePath(), file.getAbsolutePath());
    }

    private void unzipNew() throws IOException {
        File file = new File("ConcurrentProgramming/asset/new");
        File originalFile = new File("ConcurrentProgramming/new.zip");
        FileUtil.UnZipFolder(originalFile.getAbsolutePath(), file.getAbsolutePath());
    }


    static String getManifestUrl() {
        if (!isDone) {
            System.out.println("写文件中...");
            return null;
        }

        File parent = new File("ConcurrentProgramming/asset/new");
        File file = new File(parent, "src/main/AndroidManifest.xml");

        System.out.println("FileWriteRunnable: " + file.exists());
        if (!file.exists()) {
            return null;
        }

        return file.getAbsolutePath();
    }

}

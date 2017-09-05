package com.example.fileWriteRead;

/**
 * author: baiiu
 * date: on 17/9/5 17:40
 * description:
 */
class FileReadRunnable implements Runnable {

    @Override
    public void run() {

        sleep();

        String manifestUrl = FileWriteRunnable.getManifestUrl();

        if (manifestUrl == null || manifestUrl.length() == 0) {
            System.out.println("FileReadRunnable: 获取为空");
        } else {
            System.out.println("FileReadRunnable: " + manifestUrl);
        }
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

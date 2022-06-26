package com.miniprogram.zhihuicunwu.util;

/**
 * 异步任务类
 *
 * @author YZQ
 */

public class MyAsyncTask {

    /**
     * 处理任务
     *
     * @param myCallback 处理完任务后的回调
     */
    public void task(final MyCallback myCallback) {
        Thread thread = new Thread(() -> {
            myCallback.callback();
        });
        thread.start();
    }
}

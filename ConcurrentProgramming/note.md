## 中断线程
当线程中run方法执行方法体的最后一句，并由return语句返回正常结束；或者在run方法中抛出异常而终止。

还可以调用interrupt方法来终止线程。

当对一个线程调用interrupt时，线程的中断状态将被置位，这是每一个线程都具有的boolean标识。
每个线程都会检查这个标志位，以判断线程是否被中断。

如果线程在阻塞状态时，调用该方法，就会抛出InterruptedException。

## 线程状态
Thread.State枚举类中：可以查看注释
- New 新创建
使用new操作符创建的新线程，还没有调用start()方法，此时的状态是new。

- Runnable 可运行
调用start方法，线程处于runnable状态。
一个可运行的线程可能正在运行也可能没有运行，这取决于操作系统给线程提供运行的时间。
一旦一个线程开始运行，它不必始终保持运行。

- Blocked 被阻塞


- Waiting 等待
- Timed Waiting 计时等待
- Terminated 被终止

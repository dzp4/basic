//package com.study.basic.module.reptile;
//
//import io.webfolder.cdp.Launcher;
//import io.webfolder.cdp.session.Session;
//import io.webfolder.cdp.session.SessionFactory;
//
///**
// * @author dzp 2021/1/26
// */
//public class Demo {
//
//    public static void main(String[] args) {
//        method();
//    }
//
//    private static void ori() {
//        Launcher launcher = new Launcher();
//
//        try (SessionFactory factory = launcher.launch()) {
//            String context = factory.createBrowserContext();
//
//            try (Session session = factory.create(context)) {
//                // 设置要爬的网站链接，必须要有http://或https://
//                session.navigate("https://www.baidu.com");
//                // 默认timeout是10*1000 ms，也可以像下面这样手动设置
//                session.waitDocumentReady(15 * 1000);
//                // 通过session得到渲染后的html内容
//                String html = session.getContent();
//                System.out.println(html);
//            }// session创建结束
//
//            // 处理浏览器上下文，源码：contexts.remove(browserContextId)
//            // 意思应该是将后台浏览器进程关闭
//            // 我曾经尝试将此举注释，只保留下面的launcher.getProcessManager().kill();
//            // 依然可以关闭后台进程，但是官方给的代码有这句，那就带着吧，或许有其他作用。
//            factory.disposeBrowserContext(context);
//        }// factory创建结束
//
//        // 真正的关闭后台进程
//        launcher.kill();
//
//    }
//
//    private static void method() {
//        Launcher launcher = new Launcher();
//        SessionFactory factory = launcher.launch();
//        String context = factory.createBrowserContext();
//        Session session = factory.create(context);
//        // 设置要爬的网站链接，必须要有http://或https://
//        session.navigate("https://www.baidu.com");
//        // 默认timeout是10*1000 ms，也可以像下面这样手动设置
//        session.waitDocumentReady(15 * 1000);
//        // 通过session得到渲染后的html内容
//        String html = session.getContent();
//        System.out.println(html);
//        factory.disposeBrowserContext(context);
//        // 真正的关闭后台进程
//        launcher.kill();
//    }
//
//}

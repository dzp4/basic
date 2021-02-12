package com.study.basic.module.dir;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.NumberUtil;
import com.google.common.collect.Lists;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dzp 2021/2/1
 */
public class DoSearch {

    public static void main(String[] args) {
//        scanDir("C:\\");
//        scanDir("C:\\Users");
//        scanDir("C:\\Users\\84658");
//        scanDir("C:\\Users\\84658\\AppData");
//        scanDir("C:\\Users\\84658\\AppData\\Roaming");
//        scanDir("C:\\Users\\84658\\AppData\\Local");
        scanDir("C:\\Users\\84658\\AppData\\Local\\JetBrains");
    }

    private static void scanDir(String path) {
        System.out.println("扫描中,请稍后...");
        StringBuilder systemMemoryInfo = new StringBuilder();
        File file = FileUtil.file(path);
        handlerChild(systemMemoryInfo, file.listFiles());
        System.out.println(systemMemoryInfo.toString());
    }

    /**
     * 获取硬盘的每个盘符
     */
    public static void driver() {
        StringBuilder systemMemoryInfo = new StringBuilder();
        // 当前文件系统类
        FileSystemView fsv = FileSystemView.getFileSystemView();
        // 列出所有windows 磁盘
        File[] fs = File.listRoots();
        // 显示磁盘卷标
        for (File f : fs) {
            String systemDisplayName = fsv.getSystemDisplayName(f);
            systemMemoryInfo
                    .append(systemDisplayName)
                    .append("\t")
                    .append(formatFileSize(f.getFreeSpace()))
                    .append("/")
                    .append(formatFileSize(f.getTotalSpace()))
                    .append("\n")
                    .append(systemDisplayName)
                    .append("下文件的大小")
                    .append("\n")
            ;
            handlerChild(systemMemoryInfo, f.listFiles());
        }

        String str = systemMemoryInfo.toString();
        System.out.println(str);
    }

    /**
     * 将文件大小换算成对应单位
     *
     * @param space 文件大小
     * @return fileSize
     */
    public static String formatFileSize(long space) {
        FileSizeEnum[] values = FileSizeEnum.values();
        for (FileSizeEnum value : values) {
            if (space < value.size) {
                return NumberUtil.div(space, value.convert, 2) + value.unit;
            }
        }
        return "";
    }

    private static void handlerChild(StringBuilder systemMemoryInfo, File[] files) {
        if (files == null || files.length <= 0) {
            return;
        }
        // name:size
        ArrayList<DirInfo> list = Lists.newArrayListWithExpectedSize(files.length);

        for (File file : files) {
            long size = FileUtil.size(file);
            String name = file.getName();
            DirInfo dirInfo = new DirInfo();
            dirInfo.setFileName(name);
            dirInfo.setFileSize(size);
            list.add(dirInfo);
        }
        List<DirInfo> collect = list.stream().sorted(Comparator.comparing(DirInfo::getFileSize).reversed()).collect(Collectors.toList());
        for (DirInfo dirInfo : collect) {
            systemMemoryInfo
                    .append("\t")
                    .append(formatFileSize(dirInfo.getFileSize()))
                    .append("\t")
                    .append(dirInfo.getFileName())
                    .append("\n");
        }
    }

    private static boolean END = false;

    public static class PrintMsg implements Runnable {
        @Override
        public void run() {
            while (!END) {
                System.out.println("扫描中...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void temp() {
        PrintMsg printMsg = new PrintMsg();
        printMsg.run();
    }



}

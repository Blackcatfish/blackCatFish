package com.blackfish.shiro.config;

import org.csource.fastdfs.*;

public class FastDFSTest {
    public static void main(String[] args) throws Exception {
        // 1、向工程中添加jar包
        // 2、创建一个配置文件。配置tracker服务器地址
        // 3、加载配置文件(绝对路径，工程目录不要有中文)
        ClientGlobal.init(FastDFSTest.class.getResource("/").getPath() + "client.conf");
        // 4、创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        // 5、使用TrackerClient对象获得trackerserver对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 6、创建一个StorageServer的引用null就可以。
        StorageServer storageServer = null;
        // 7、创建一个StorageClient对象。trackerserver、StorageServer两个参数。
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 8、使用StorageClient对象上传文件。
        String[] strings = storageClient.upload_file("D:/鲶鱼.jpg", "jpg", null);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
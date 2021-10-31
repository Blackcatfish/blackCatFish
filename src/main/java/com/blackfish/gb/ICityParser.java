package com.blackfish.gb;


import java.util.List;

public interface ICityParser {

    /**
     * *解析得到省市区数据
     *
     * @param url 请求url
     * @return 城市
     */
    List<Node> parseProvinces(String url);
}
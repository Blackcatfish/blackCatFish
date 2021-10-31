package com.blackfish.gb;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.json.JSONUtil;

import java.util.List;

public class JsonCityParserDecorator extends CityParserDecorator {

    public JsonCityParserDecorator(ICityParser cityParser) {
        super(cityParser);
    }

    @Override
    public List<Node> parseProvinces(String url) {
        List<Node> provinces = super.parseProvinces(url);
        String jsonStr = JSONUtil.toJsonStr(provinces);
        // json数据写入到文件
        FileWriter fileWriter = new FileWriter(FileUtil.touch("E://area.json"));
        fileWriter.write(jsonStr);
        return provinces;
    }
}
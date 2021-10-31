package com.blackfish.gb;

import cn.hutool.log.StaticLog;

import java.util.List;

public class LocationCityParserDecorator extends CityParserDecorator {

    public LocationCityParserDecorator(ICityParser cityParser) {
        super(cityParser);
    }

    @Override
    public List<Node> parseProvinces(String url) {
        List<Node> provinces = super.parseProvinces(url);
        StaticLog.info("查询出经纬度了. . . ");
        return provinces;
    }
}
package com.blackfish.gb;

import java.util.List;

public class CityParserDecorator implements ICityParser {

    private ICityParser cityParser;

    public CityParserDecorator(ICityParser cityParser) {
        this.cityParser = cityParser;
    }

    public List<Node> parseProvinces(String url) {
        return this.cityParser.parseProvinces(url);
    }
}
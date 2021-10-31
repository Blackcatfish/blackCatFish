package com.blackfish.gb;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.text.StrFormatter;
import cn.hutool.log.StaticLog;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * sql打印装饰器
 */
public class SqlCityParserDecorator extends CityParserDecorator {

    private static final String SQL = "insert into area(`name`, `code`, full_spell, easy_spell, initial, parent_code, depth, data_from_url) values ('{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}');";

    public SqlCityParserDecorator(ICityParser cityParser) {
        super(cityParser);
    }

    @Override
    public List<Node> parseProvinces(String url) {
        List<Node> provinces = super.parseProvinces(url);

        List<String> buildSql = buildSql(provinces);
        if (CollUtil.isNotEmpty(buildSql)) {
            // json数据写入到文件
            FileWriter fileWriter = new FileWriter(FileUtil.touch("E://area.sql"));
            fileWriter.writeLines(buildSql);
        }
        return provinces;
    }

    /**
     * *实体转sql数据
     *
     * @param provinces 省市县数据
     */
    private List<String> buildSql(List<Node> provinces) {
        List<String> sqls = null;
        if (CollUtil.isNotEmpty(provinces)) {
            sqls = new ArrayList<>();
            for (Node province : provinces) {
                sqls.add(initSql(province.getName(), province.getCode(), province.getDataFromUrl(), "", 1));
                buildCitySql(sqls, province.getNodes(), province.getCode());
            }
        }
        return sqls;
    }

    private void buildCitySql(List<String> sqls, List<Node> cities, String parentCode) {
        if (CollUtil.isNotEmpty(cities)) {
            for (Node city : cities) {
                sqls.add(initSql(city.getName(), city.getCode(), city.getDataFromUrl(), parentCode, 2));
                buildCountySql(sqls, city.getNodes(), city.getCode());
            }
        }
    }

    private void buildCountySql(List<String> sqls, List<Node> counties, String parentCode) {
        if (CollUtil.isNotEmpty(counties)) {
            for (Node county : counties) {
                sqls.add(initSql(county.getName(), county.getCode(), county.getDataFromUrl(), parentCode, 3));
                buildTowntrSql(sqls, county.getNodes(), county.getCode());
            }
        }
    }

    private void buildTowntrSql(List<String> sqls, List<Node> towies, String parentCode) {
        if (CollUtil.isNotEmpty(towies)) {
            for (Node towntr : towies) {
                sqls.add(initSql(towntr.getName(), towntr.getCode(), towntr.getDataFromUrl(), parentCode, 4));
                buildVillagetrSql(sqls, towntr.getNodes(), towntr.getCode());
            }
        }
    }

    private void buildVillagetrSql(List<String> sqls, List<Node> vilies, String parentCode) {
        if (CollUtil.isNotEmpty(vilies)) {
            for (Node villagetr : vilies) {
                sqls.add(initSql(villagetr.getName(), villagetr.getCode(), villagetr.getDataFromUrl(), parentCode, 5));
            }
        }
    }

    /**
     * * 初始化sql语句
     */
    private String initSql(String name, String code, String dataFromUrl, String parentCode, Integer depth) {
        String insertSql = null;
        try {
            insertSql = StrFormatter.format(SQL, name, code,
                    PinyinHelper.convertToPinyinString(name, "", PinyinFormat.WITHOUT_TONE),
                    PinyinHelper.getShortPinyin(name), PinyinHelper.getShortPinyin(name).substring(0, 1).toString(),
                    parentCode, depth, dataFromUrl);
            StaticLog.info(insertSql);
        } catch (PinyinException e) {
            StaticLog.error("拼音解析失败：{} .", e.getMessage());
        }
        return insertSql;
    }
}
package com.example;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

import java.util.Collections;

/**
 * @desc 代码自动生成器
 * @auth llp
 * @date 2022年06月16日 22:55
 */
public class AutoCodeConfig {
    public static void main(String[] args) {
        // 数据库配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig.
                Builder("jdbc:p6spy:mysql://localhost:3306/mybatis_plus?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                "root",
                "root")
                .build();

        // 需要构建一个 代码自动生成器 对象
        AutoGenerator generator = new AutoGenerator(dataSourceConfig);
        // 全局配置
        String projectPath = System.getProperty("user.dir");
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .outputDir(projectPath + "/src/main/java")
                .disableOpenDir()
                .author("面包")
                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")
                .build();
        generator.global(globalConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.mianbao.mybatisplus.samples.generator")
                .moduleName("test")
                .entity("entity")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .xml("mapper.xml")
                .controller("controller")
                .other("other")
                .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/resources/mapper"))
                .build();
        generator.packageInfo(packageConfig);

        // 模板配置
        TemplateConfig templateConfig = new TemplateConfig.Builder()
                .disable(TemplateType.ENTITY)
                .entity("/templates/entity.java")
                .service("/templates/service.java")
                .serviceImpl("/templates/serviceImpl.java")
                .mapper("/templates/mapper.java")
                .xml("/templates/mapper.xml")
                .controller("/templates/controller.java")
                .build();
        generator.template(templateConfig);

        // 注入配置
//        InjectionConfig injectionConfig = new InjectionConfig.Builder()
//                .beforeOutputFile((tableInfo, objectMap) -> {
//                    System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
//                })
//                .customMap(Collections.singletonMap("test", "mianbao"))
//                .customFile(Collections.singletonMap("test.txt", "/templates/test.vm"))
//                .build();
//        generator.injection(injectionConfig);

        // 策略配置
        new StrategyConfig.Builder()
                .enableCapitalMode()
                .enableSkipView()
                .disableSqlFilter()
//                .likeTable(new LikeTable("USER"))
                .addInclude("user")     // 设置要映射的表
//                .addTablePrefix("t_", "c_")
//                .addFieldSuffix("_flag")
                .build();

        // Entity策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .entityBuilder()
                //.superClass(BaseEntity.class)
                .disableSerialVersionUID()
                .enableChainModel()
                .enableLombok()
                .enableRemoveIsPrefix()
                .enableTableFieldAnnotation()
                .enableActiveRecord()
                .versionColumnName("version")
                .versionPropertyName("version")
                .logicDeleteColumnName("deleted")
                .logicDeletePropertyName("deleteFlag")
                .naming(NamingStrategy.no_change)
                .columnNaming(NamingStrategy.underline_to_camel)
                .addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")
                .addIgnoreColumns("age")
                .addTableFills(new Column("create_time", FieldFill.INSERT))
                .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                .idType(IdType.AUTO)
                .formatFileName("%sEntity")

        // Controller策略配置
                .controllerBuilder()
                // .superClass(BaseController.class)
                .enableHyphenStyle()
                .enableRestStyle()
                .formatFileName("%sAction")

        // Service策略配置
                .serviceBuilder()
                // .superServiceClass(BaseService.class)
                // .superServiceImplClass(BaseServiceImpl.class)
                .formatServiceFileName("%sService")
                .formatServiceImplFileName("%sServiceImp")

        // Mapper策略配置
                .mapperBuilder()
                // .superClass(BaseMapper.class)
                .enableMapperAnnotation()
                .enableBaseResultMap()
                .enableBaseColumnList()
                // .cache(MyMapperCache.class)
                .formatMapperFileName("%sDao")
                .formatXmlFileName("%sXml")
                .build();
        generator.strategy(strategyConfig);

        generator.execute();
    }
}

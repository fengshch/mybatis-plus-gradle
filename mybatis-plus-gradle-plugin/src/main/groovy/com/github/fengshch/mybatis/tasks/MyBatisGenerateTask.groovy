package com.github.fengshch.mybatis.tasks

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.rules.DateType
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import com.baomidou.mybatisplus.generator.fill.Column
import com.github.fengshch.mybatis.config.MyBatisConfig
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import javax.inject.Inject
import javax.sql.DataSource

class MyBatisGenerateTask extends DefaultTask {
    private final String projectDir
    private final MyBatisConfig myBatisConfig


    @Inject
    MyBatisGenerateTask(MyBatisConfig myBatisConfig) {
        this.myBatisConfig = myBatisConfig
        this.projectDir = this.getProject().projectDir.toString()
    }

    private HikariDataSource getDataSource() {

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(myBatisConfig.driverClassName)
        config.setUsername(myBatisConfig.username)
        config.setPassword(myBatisConfig.password)
        config.setJdbcUrl(myBatisConfig.url)
        return new HikariDataSource(config);
    }


    @TaskAction
    void runTask() {
        HikariDataSource dataSource = getDataSource()

        createAndGenerator(dataSource)

        dataSource.close();
    }

    private void createAndGenerator(DataSource dataSource) {
        MyBatisConfig config = myBatisConfig
        /**
         * 数据源配置 Builder
         */
        DataSourceConfig.Builder dataSourceConfigBuilder = new DataSourceConfig.Builder(dataSource)

        String outputDir = projectDir + "/" + config.outputDir
        def folder = new File(outputDir)
        if(!folder.exists()){
            folder.mkdirs()
        }
        /**
         * 全局配置 Builder
         */
        GlobalConfig.Builder globalConfigBuilder = new GlobalConfig.Builder()
                .author(config.author)
                .outputDir(outputDir)
                .dateType(DateType.TIME_PACK)
                .disableOpenDir()

        /**
         * 包配置 Builder
         */
        PackageConfig.Builder packageConfigBuilder = new PackageConfig.Builder()
                .parent(config.parentPackage)
                .moduleName(config.moduleName)
                .entity(config.entityPackage)
                .service(config.servicePackage)
                .serviceImpl(config.serviceImplPackage)
                .mapper(config.mapperPackage)
                .xml(config.xmlPackage)
                .controller(config.controllerPackage)
        /**
         * 策略配置 Builder
         */
        StrategyConfig.Builder strategyConfigBuilder = new StrategyConfig.Builder()
                .enableCapitalMode()
                .enableSkipView()

        strategyConfigBuilder.entityBuilder()
                .disableSerialVersionUID()
                .enableChainModel()
                .enableTableFieldAnnotation()
                .formatFileName(config.entityFileName)
                .enableLombok()
                .versionColumnName(config.versionColumnName)
                .versionPropertyName(config.versionPropertyName)
                .logicDeleteColumnName(config.logicDeleteColumnName)
                .logicDeletePropertyName(config.logicDeletePropertyName)
                .idType(config.idType)
                .addTableFills()

        strategyConfigBuilder.serviceBuilder()
//                            .superServiceClass(BaseService.class)
//                            .superServiceImplClass(ServiceImpl.class)
                .formatServiceFileName(config.serviceFileName)
                .formatServiceImplFileName(config.serviceImplFileName)

        strategyConfigBuilder.mapperBuilder()
                .superClass(BaseMapper.class)
                .enableBaseResultMap()
                .enableBaseColumnList()
                .formatMapperFileName(config.mapperFileName)
                .formatXmlFileName(config.xmlFileName)


        if (config.enableEntityOverride) {
            strategyConfigBuilder.entityBuilder().enableFileOverride()
        }

        if (config.enableServiceOverride) {
            strategyConfigBuilder.serviceBuilder().enableFileOverride()
        }

        if (config.enableMapperOverride) {
            strategyConfigBuilder.mapperBuilder().enableFileOverride()
        }

        if(config.superClass){
            strategyConfigBuilder.mapperBuilder().superClass(config.superClass)
        }

        if (config.include != null) {
            strategyConfigBuilder.addInclude(config.include)
        }

        if (config.exclude != null) {
            strategyConfigBuilder.addExclude(config.exclude)
        }

        if (config.tableFills != null && config.tableFills.size() > 0) {
            List<Column> tableFills = new ArrayList<>()
            config.tableFills.forEach { key, value ->
                switch (value) {
                    case "INSERT":
                        tableFills.add(new Column(key, FieldFill.INSERT))
                        break;
                    case "UPDATE":
                        tableFills.add(new Column(key, FieldFill.UPDATE))
                        break
                    case "INSERT_UPDATE":
                        tableFills.add(new Column(key, FieldFill.INSERT_UPDATE))
                        break
                }
            }
            if (tableFills.size() > 0) {
                strategyConfigBuilder.entityBuilder().addTableFills(tableFills)
            }
        }

        /**
         * 注入配置 Builder
         */
        InjectionConfig.Builder injectionConfigBuilder = new InjectionConfig.Builder()

        /**
         * 模板配置 Builder
         */
        TemplateConfig.Builder templateConfigBuilder = new TemplateConfig.Builder()
                .disable(TemplateType.CONTROLLER)

        /**
         * 模板引擎
         */
        AbstractTemplateEngine templateEngine = new FreemarkerTemplateEngine()

        new AutoGenerator(dataSourceConfigBuilder.build())
                .global(globalConfigBuilder.build())
        // 包配置
                .packageInfo(packageConfigBuilder.build())
        // 策略配置
                .strategy(strategyConfigBuilder.build())
        // 注入配置
                .injection(injectionConfigBuilder.build())
        // 模板配置
                .template(templateConfigBuilder.build())
        // 执行
                .execute(templateEngine);
    }
}

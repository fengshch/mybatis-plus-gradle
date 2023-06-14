package com.github.fengshch.mybatis.config

import com.baomidou.mybatisplus.annotation.IdType

import javax.inject.Inject

class MyBatisConfig {
    final String name
    private String driverClassName
    private String url
    private String username
    private String password

    private String author = "bill"

    private String outputDir = "src/batis/java"


    private String parentPackage
    private String moduleName
    private String entityPackage = "po"
    private String controllerPackage = "controller"
    private String servicePackage = "service"
    private String serviceImplPackage = "service.impl"
    private String mapperPackage = "mapper"
    private String xmlPackage = "mapper.xml"


    private String versionColumnName
    private String versionPropertyName

    private String logicDeleteColumnName
    private String logicDeletePropertyName

    private IdType idType = IdType.ASSIGN_ID
    private List<String> include
    private List<String> exclude

    private Map<String, String> tableFills

    private boolean enableEntityOverride = false
    private boolean enableMapperOverride = false
    private boolean enableServiceOverride = false


    private String superClass

    private String entityFileName = "%sPO"

    private String serviceFileName = "%sService"

    private String serviceImplFileName = "%sServiceImpl"

    private String mapperFileName = "%sMapper"

    private String xmlFileName = "%sMapper"

    @Inject
    MyBatisConfig(String name) {
        this.name = name
    }
    void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName
    }

    void setUrl(String url) {
        this.url = url
    }

    void setUsername(String username) {
        this.username = username
    }

    void setPassword(String password) {
        this.password = password
    }

    void setAuthor(String author) {
        this.author = author
    }

    void setOutputDir(String outputDir) {
        this.outputDir = outputDir
    }

    void setParentPackage(String parentPackage) {
        this.parentPackage = parentPackage
    }

    void setModuleName(String moduleName) {
        this.moduleName = moduleName
    }

    String getEntityPackage() {
        return entityPackage
    }

    void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage
    }

    String getControllerPackage() {
        return controllerPackage
    }

    void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage
    }

    String getServicePackage() {
        return servicePackage
    }

    void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage
    }

    String getServiceImplPackage() {
        return serviceImplPackage
    }

    void setServiceImplPackage(String serviceImplPackage) {
        this.serviceImplPackage = serviceImplPackage
    }

    String getMapperPackage() {
        return mapperPackage
    }

    void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage
    }

    String getXmlPackage() {
        return xmlPackage
    }

    void setXmlPackage(String xmlPackage) {
        this.xmlPackage = xmlPackage
    }

    void setVersionColumnName(String versionColumnName) {
        this.versionColumnName = versionColumnName
    }

    void setVersionPropertyName(String versionPropertyName) {
        this.versionPropertyName = versionPropertyName
    }

    void setLogicDeleteColumnName(String logicDeleteColumnName) {
        this.logicDeleteColumnName = logicDeleteColumnName
    }

    void setLogicDeletePropertyName(String logicDeletePropertyName) {
        this.logicDeletePropertyName = logicDeletePropertyName
    }

    void setIdType(IdType idType) {
        this.idType = idType
    }

    void setInclude(List<String> include) {
        this.include = include
    }

    void setExclude(List<String> exclude) {
        this.exclude = exclude
    }

    void setTableFills(Map<String, String> tableFills) {
        this.tableFills = tableFills
    }

    String getName() {
        return name
    }

    String getDriverClassName() {
        return driverClassName
    }

    String getUrl() {
        return url
    }

    String getUsername() {
        return username
    }

    String getPassword() {
        return password
    }

    String getOutputDir() {
        return outputDir
    }

    String getParentPackage() {
        return parentPackage
    }

    String getModuleName() {
        return moduleName
    }


    String getVersionColumnName() {
        return versionColumnName
    }

    String getLogicDeleteColumnName() {
        return logicDeleteColumnName
    }

    IdType getIdType() {
        return idType
    }

    List<String> getInclude() {
        return include
    }

    List<String> getExclude() {
        return exclude
    }

    String getVersionPropertyName() {
        return versionPropertyName
    }

    String getLogicDeletePropertyName() {
        return logicDeletePropertyName
    }

    String getAuthor() {
        return author
    }

    Map<String, String> getTableFills() {
        return tableFills
    }

    boolean getEnableEntityOverride() {
        return enableEntityOverride
    }

    void setEnableEntityOverride(boolean enableEntityOverride) {
        this.enableEntityOverride = enableEntityOverride
    }

    boolean getEnableMapperOverride() {
        return enableMapperOverride
    }

    void setEnableMapperOverride(boolean enableMapperOverride) {
        this.enableMapperOverride = enableMapperOverride
    }

    boolean getEnableServiceOverride() {
        return enableServiceOverride
    }

    void setEnableServiceOverride(boolean enableServiceOverride) {
        this.enableServiceOverride = enableServiceOverride
    }

    String getSuperClass() {
        return superClass
    }

    void setSuperClass(String superClass) {
        this.superClass = superClass
    }

    String getEntityFileName() {
        return entityFileName
    }

    void setEntityFileName(String entityFileName) {
        this.entityFileName = entityFileName
    }

    String getServiceFileName() {
        return serviceFileName
    }

    void setServiceFileName(String serviceFileName) {
        this.serviceFileName = serviceFileName
    }

    String getServiceImplFileName() {
        return serviceImplFileName
    }

    void setServiceImplFileName(String serviceImplFileName) {
        this.serviceImplFileName = serviceImplFileName
    }

    String getMapperFileName() {
        return mapperFileName
    }

    void setMapperFileName(String mapperFileName) {
        this.mapperFileName = mapperFileName
    }

    String getXmlFileName() {
        return xmlFileName
    }

    void setXmlFileName(String xmlFileName) {
        this.xmlFileName = xmlFileName
    }
}

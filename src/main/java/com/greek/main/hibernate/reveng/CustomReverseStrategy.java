/* AssentSoftware (C)2021 */
package com.greek.main.hibernate.reveng;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;
import org.hibernate.mapping.MetaAttribute;

@Slf4j
public class CustomReverseStrategy extends DelegatingReverseEngineeringStrategy {

    private static final String OWN_TYPES = "own types";

    public CustomReverseStrategy(ReverseEngineeringStrategy delegate) {
        super(delegate);
    }

    @Override
    public String getTableIdentifierStrategyName(TableIdentifier tableIdentifier) {
        return "sequence";
    }

    @Override
    public String columnToHibernateTypeName(
            TableIdentifier table,
            String columnName,
            int sqlType,
            int length,
            int precision,
            int scale,
            boolean nullable,
            boolean generatedIdentifier) {
        String preferredHibernateType =
                super.columnToHibernateTypeName(
                        table,
                        columnName,
                        sqlType,
                        length,
                        precision,
                        scale,
                        nullable,
                        generatedIdentifier);

        if (StringUtils.isNotBlank(preferredHibernateType)) {
            if ("timestamp".equalsIgnoreCase(preferredHibernateType)) {
                return "java.time.LocalDateTime";
            } else if ("date".equalsIgnoreCase(preferredHibernateType)) {
                return "java.time.LocalDate";
            } else if ("time".equalsIgnoreCase(preferredHibernateType)) {
                return "java.time.LocalTime";
            }
        }

        return preferredHibernateType;
    }

    @Override
    public Properties getTableIdentifierProperties(TableIdentifier tableIdentifier) {
        final String tableName = tableIdentifier.getName();

        log.info("Executing getTableIdentifier:" + tableName);

        Properties properties = super.getTableIdentifierProperties(tableIdentifier);

        if (properties == null) {
            properties = new Properties();
        }

        if (tableName != null) {
            // properties.put("sequence", "id_" + tableName.toLowerCase());
            properties.put("sequence", tableName.toLowerCase() + "_id_seq");
            properties.put("generatorName", tableName.toLowerCase() + "_seq_gen");
        }

        return properties;
    }

    @Override
    public Map<String, MetaAttribute> columnToMetaAttributes(
            TableIdentifier tableIdentifier, String column) {
        final String tableName = tableIdentifier.getName();

        log.info("Executing columnToMetaAttributes:" + tableName + " column:" + column);

        Map<String, MetaAttribute> map = new HashMap<>();

        if ("id".equalsIgnoreCase(column) || "version".equalsIgnoreCase(column)) {
            MetaAttribute useInEquals = new MetaAttribute(OWN_TYPES);
            useInEquals.addValue("true");

            map.put("use-in-equals", useInEquals);
        }

        MetaAttribute useInTostring = new MetaAttribute(OWN_TYPES);
        useInTostring.addValue("true");

        map.put("use-in-tostring", useInTostring);

        return map;
    }

    @Override
    public Map<String, MetaAttribute> tableToMetaAttributes(TableIdentifier tableIdentifier) {
        final String tableName = tableIdentifier.getName();

        log.debug("Executing tableToMetaAttributes:" + tableName);

        Map<String, MetaAttribute> map = new HashMap<>();

        MetaAttribute extraImports = new MetaAttribute(OWN_TYPES);
        extraImports.addValue("com.gvt.core.domain.types.Versionable");
        extraImports.addValue("com.gvt.core.domain.types.Seleccionable");
        extraImports.addValue("com.gvt.core.domain.types.Identificable");
        extraImports.addValue("com.gvt.core.domain.types.Fillable");
        extraImports.addValue("com.gvt.core.domain.types.Cleanable");
        extraImports.addValue("com.gvt.core.domain.types.Auditable");

        //		extraImports.addValue("javax.persistence.PrePersist");
        //		extraImports.addValue("javax.persistence.PreUpdate");
        //		extraImports.addValue("java.sql.Timestamp");

        extraImports.addValue("org.springframework.data.annotation.CreatedBy");
        extraImports.addValue("org.springframework.data.annotation.CreatedDate");
        extraImports.addValue("org.springframework.data.annotation.LastModifiedBy");
        extraImports.addValue("org.springframework.data.annotation.LastModifiedDate");
        extraImports.addValue("org.springframework.data.jpa.domain.support.AuditingEntityListener");

        //		extraImports.addValue("javax.xml.bind.annotation.XmlTransient");
        //		extraImports.addValue("com.fasterxml.jackson.annotation.JsonIgnore");
        //
        //	extraImports.addValue("org.springframework.security.core.context.SecurityContextHolder");
        //		extraImports.addValue("org.springframework.security.core.userdetails.User");

        //		extraImports.addValue("java.time.LocalDateTime");
        //		extraImports.addValue("java.time.LocalDate");
        //		extraImports.addValue("java.time.LocalTime");

        MetaAttribute extraImplements = new MetaAttribute(OWN_TYPES);
        extraImplements.addValue("Versionable");
        extraImplements.addValue("Seleccionable");
        extraImplements.addValue("Identificable");
        extraImplements.addValue("Fillable");
        extraImplements.addValue("Cleanable");
        extraImplements.addValue("Auditable");

        MetaAttribute classCode = new MetaAttribute(OWN_TYPES);
        classCode.addValue("// Adding extra-code");

        map.put("implements", extraImplements);
        map.put("extra-import", extraImports);
        map.put("class-code", classCode);

        return map;
    }
}

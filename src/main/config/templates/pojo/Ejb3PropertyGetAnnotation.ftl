<#if ejb3>
<#if pojo.hasIdentifierProperty()>
<#if property.equals(clazz.identifierProperty)> 
  <#if c2j.isComponent(property) >
  @${pojo.importType("javax.persistence.EmbeddedId")}
  <#else>  
  @${pojo.importType("org.hibernate.annotations.GenericGenerator")}(name = "${clazz.identifier.getIdentifierGeneratorProperties().getProperty("generatorName","")}", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @${pojo.importType("org.hibernate.annotations.Parameter")}(name = "sequence_name", value = "${clazz.identifier.getIdentifierGeneratorProperties().getProperty("sequence","")}"),
                    @${pojo.importType("org.hibernate.annotations.Parameter")}(name = "initial_value", value = "1"),
                    @${pojo.importType("org.hibernate.annotations.Parameter")}(name = "increment_size", value = "1")
            })
  @${pojo.importType("javax.persistence.GeneratedValue")}(generator = "${clazz.identifier.getIdentifierGeneratorProperties().getProperty("generatorName","")}")
  @${pojo.importType("javax.persistence.Id")}
  </#if> 
<#-- if this is the id property (getter)-->
<#-- explicitly set the column name for this property-->
</#if>
</#if>
<#if c2h.isManyToOne(property)>
<#--TODO support @OneToOne true and false-->    
${pojo.generateManyToOneAnnotation(property)}
<#--TODO support optional and targetEntity-->    
${pojo.generateJoinColumnsAnnotation(property, cfg)}
<#elseif c2h.isCollection(property)>
${pojo.generateCollectionAnnotation(property, cfg)}
<#else>
${pojo.generateBasicAnnotation(property)}
${pojo.generateAnnColumnAnnotation(property)}
</#if>
</#if>
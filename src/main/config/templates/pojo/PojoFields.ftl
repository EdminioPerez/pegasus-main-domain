<#-- // Fields -->

	private static final long serialVersionUID = 1L;
<#foreach field in pojo.getAllPropertiesIterator()><#if pojo.getMetaAttribAsBool(field, "gen-property", true)> <#if pojo.hasMetaAttribute(field, "field-description")>    /**
     ${pojo.getFieldJavaDoc(field, 0)}
     */
 </#if>	<#if field.name == "usuarioCreacion">@CreatedBy</#if><#if field.name == "fechaCreacion">@CreatedDate</#if><#if field.name == "usuarioModificacion">@LastModifiedBy</#if><#if field.name == "fechaModificacion">@LastModifiedDate</#if>
 	${pojo.getFieldModifiers(field)} ${pojo.getJavaTypeName(field, jdk5)} ${field.name}<#if pojo.hasFieldInitializor(field, jdk5)> = ${pojo.getFieldInitialization(field, jdk5)}</#if>;
</#if>
</#foreach>

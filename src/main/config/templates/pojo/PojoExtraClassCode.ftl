<#if pojo.hasMetaAttribute("class-code")>  // The following is extra code specified in src/main/config/templates
${pojo.getExtraClassCode()}
	private boolean comesFromExternalDataSource = false;
	private boolean selected;
	
	@javax.persistence.Transient
    public boolean isExternalDataSource() {
		return this.comesFromExternalDataSource;
    }

    public void setExternalDataSource(boolean value) {
        this.comesFromExternalDataSource = value;
    }

	@javax.persistence.Transient
	public boolean getSelected() {
		return selected;
	}

    public void setSelected(boolean selected) {
		this.selected = selected;
    }
    
    public void cleanPOJO() {
<#foreach property in pojo.getAllPropertiesIterator()>
	<#if c2h.isManyToOne(property)>
		if(this.${property.name} != null &&
			(${property.name}.getId() == null || this.${property.name}.getId().longValue() == 0)) {
			${property.name} = null;
		}
	</#if>
</#foreach>
    }
    
    public void fillPOJO() {
<#foreach property in pojo.getAllPropertiesIterator()>
	<#if c2h.isManyToOne(property)>
		if(this.${property.name} == null) {
			${property.name} = new ${pojo.getJavaTypeName(property, jdk5)}();
		}
	</#if>
</#foreach>
    }
    
    public ${pojo.getDeclarationName()} createPOJO() {
		fillPOJO();
		
		return this;
	}
	
//	@PrePersist
//	public void onPrePersist() {
//		this.fechaCreacion = new Date();
//		this.usuarioCreacion = getSecurityContextPrincipal();
//	}
//
//	@PreUpdate
//	public void onPreUpdate() {
//		this.fechaModificacion = new Date();
//		this.usuarioModificacion = getSecurityContextPrincipal();
//	}
//
//	@javax.persistence.Transient
//	private String getSecurityContextPrincipal() {
//		String principal;
//		String UNKNOWN_USER = "unknownUser";
//
//		if (SecurityContextHolder.getContext().getAuthentication() == null) {
//			principal = UNKNOWN_USER;
//		} else {
//			try {
//				principal = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
//						.getUsername();
//			} catch (ClassCastException e) {
//				principal = UNKNOWN_USER;
//			}
//		}
//
//		return principal;
//	}
	
  // end of extra code specified in the hbm.xml files
</#if>
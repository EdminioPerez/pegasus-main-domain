<#if pojo.needsEqualsHashCode() && !clazz.superclass?exists>   
	@Override
	public boolean equals(Object other) {
         if (this == other) 
         	return true;
         	
		 if (other == null) 
		 	return false;
		 	
		 if (!(other instanceof ${pojo.getDeclarationName()})) 
		 	return false;
		 	
		 ${pojo.getDeclarationName()} castOther = ( ${pojo.getDeclarationName()} ) other; 
         
		 return ${pojo.generateEquals("this", "castOther", jdk5)};
   }
   
   @Override
   public int hashCode() {
         int result = 17;
         
<#foreach property in pojo.getAllPropertiesIterator()>         ${pojo.generateHashCode(property, "result", "this", jdk5)}
</#foreach>         return result;
   }   
</#if>
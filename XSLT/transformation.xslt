<xsl:stylesheet version="1.0" 
xmlns:alias="http://www.w3.org/1999/XSL/Transform-alias"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
<alias:html>
	<alias:title>
		<alias:head><alias:title>XSL Subquery trial</alias:title></alias:head>
	</alias:title>
	<alias:body>
	<!-- max(xsl:date(/sometimestamps/dataset/timestamp) -->
<!--	xsl:date(/sometimestamps/dataset/timestamp) -->
	
	max(/sometimestamps/dataset[0]/timestamp
		<xsl:value-of select="/sometimestamps/dataset[xsl:date(timestamp)>=xsl:max(xsl:date(/sometimestamps/dataset[0]/timestamp))]" />
	</alias:body>
</alias:html>
</xsl:template>
</xsl:stylesheet>
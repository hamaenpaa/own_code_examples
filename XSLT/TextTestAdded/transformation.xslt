<xsl:stylesheet version="1.0" 
xmlns:alias="http://www.w3.org/1999/XSL/Transform-alias"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
<alias:html>
	<alias:title>
		<alias:head><alias:title>String value comparison test</alias:title></alias:head>
	</alias:title>
	<alias:body>
	<!-- max(xsl:date(/sometimestamps/dataset/timestamp) -->
<!--	xsl:date(/sometimestamps/dataset/timestamp) -->
	
<!--	max(/sometimestamps/dataset[0]/timestamp
	<xsl:value-of select="/sometimestamps/dataset[xsl:date(timestamp)>=xsl:max(xsl:date(/sometimestamps/dataset[0]/timestamp))]" /> -->
	
	<xsl:variable name="data1value" select="/sometimestamps/dataset/data[1]/value" />
	<xsl:variable name="data2value" select="/sometimestamps/dataset/data[2]/value" />		

	<h1>Text setting test</h1>
	
	<table>
	<tr>
	<td>xxx<xsl:text> </xsl:text>yyy <xsl:text> </xsl:text>zzz</td>
	</tr>
	</table>
	

	<h1>Dynamic attribute creation test</h1>

	<xsl:variable name="rowspanvalue" select="3"/>

	<table border="1">
		<tr>	
	<xsl:element name="td">
		<xsl:attribute name="rowspan"><xsl:value-of select="$rowspanvalue"/></xsl:attribute>
		spanned column
	</xsl:element>
		<td>second col</td>
		<td>third col</td>
		</tr>
		<tr><td>sec row, first col</td></tr>
		<tr><td>third row, first col</td></tr>
	</table>	
	
	<h1>String value comparison test</h1>	

	<h2>Values presented</h2>
	
	Data1:
	<xsl:value-of select="$data1value" />
	<br/>
	
	Data2:
	<xsl:value-of select="$data2value" />
	<br/>
	
	<!-- boolean variable test -->
	
	<h2>Boolean variables </h2>
	
	<!-- equality -->

	<h3>Equality (=)</h3>
	
	Compare with a string constant:
	<xsl:value-of select="$data1value='DS1Value1'" />	
	<br/>
	
	Compare variables:
	<xsl:value-of select="$data1value=$data2value" />
	<br/>
	
	Compare one seek with one variable, right side:
	<xsl:value-of select="$data1value=/sometimestamps/dataset/data[2]/value" />
	<br/>	
	
	Compare one seek with one variable, left side:
	<xsl:value-of select="/sometimestamps/dataset/data[1]/value=$data2value" />
	<br/>	
	
	Compare two seek values:
	<xsl:value-of select="/sometimestamps/dataset/data[1]/value=/sometimestamps/dataset/data[2]/value" />
	<br/>		
	
	<!-- not equality -->

	<h3>Not Equality (!=)</h3>

	Compare with a string constant:
	<xsl:value-of select="$data1value!='DS1Value1'" />	
	<br/>
	
	Compare variables:
	<xsl:value-of select="$data1value!=$data2value" />
	<br/>
	
	Compare one seek with one variable, right side:
	<xsl:value-of select="$data1value!=/sometimestamps/dataset/data[2]/value" />
	<br/>	
	
	Compare one seek with one variable, left side:
	<xsl:value-of select="/sometimestamps/dataset/data[1]/value!=$data2value" />
	<br/>	
	
	Compare two seek values:
	<xsl:value-of select="/sometimestamps/dataset/data[1]/value!=/sometimestamps/dataset/data[2]/value" />
	<br/>		

	<h3>Compare using not(=)</h3>

	Compare with a string constant:
	<xsl:value-of select="not($data1value='DS1Value1')" />	
	<br/>
	
	Compare variables:
	<xsl:value-of select="not($data1value=$data2value)" />
	<br/>
	
	Compare one seek with one variable, right side:
	<xsl:value-of select="not($data1value=/sometimestamps/dataset/data[2]/value)" />
	<br/>	
	
	Compare one seek with one variable, left side:
	<xsl:value-of select="not(/sometimestamps/dataset/data[1]/value=$data2value)" />
	<br/>	
	
	Compare two seek values:
	<xsl:value-of select="not(/sometimestamps/dataset/data[1]/value=/sometimestamps/dataset/data[2]/value)" />
	<br/>		


	<h3>Compare using contains and length function</h3>

	Compare with a string constant:
	<xsl:value-of select="contains($data1value,'DS1Value1') and
		string-length($data1value)=string-length('DS1Value1') " />	
	<br/>
	
	Compare variables:
	<xsl:value-of select="contains($data1value,$data2value) and
		string-length($data1value)=string-length($data2value)" />
	<br/>
	
	
	<!-- if test -->
	
	<h2>If test</h2>
	
	<h3>Equality (=)</h3>

	Compare with a string constant:
	<xsl:if test="$data1value='DS1Value1'">
		true
	</xsl:if>
	<br/>
	
	Compare variables:
	<xsl:if test="$data1value=$data2value">
		true
	</xsl:if>
	<br/>
	
	Compare one seek with one variable, right side:	
	<xsl:if test="$data1value=/sometimestamps/dataset/data[2]/value">
		true
	</xsl:if>
	<br/>
	
	Compare one seek with one variable, left side:
	<xsl:if test="/sometimestamps/dataset/data[1]/value=$data2value">
		true
	</xsl:if>
	<br/>
	
	Compare two seek values:
	<xsl:if test="/sometimestamps/dataset/data[1]/value=/sometimestamps/dataset/data[2]/value">
		true
	</xsl:if>
	<br/>
	
	<h3>Not equality (!=)</h3>

	Compare with a string constant:
	<xsl:if test="$data1value!='DS1Value1'">
		true
	</xsl:if>

	Compare variables:
	<xsl:if test="$data1value!=$data2value">
		true
	</xsl:if>
	<br/>
	
	Compare one seek with one variable, right side:	
	<xsl:if test="$data1value!=/sometimestamps/dataset/data[2]/value">
		true
	</xsl:if>
	<br/>
	
	Compare one seek with one variable, left side:
	<xsl:if test="/sometimestamps/dataset/data[1]/value!=$data2value">
		true
	</xsl:if>
	<br/>
	
	Compare two seek values:
	<xsl:if test="/sometimestamps/dataset/data[1]/value!=/sometimestamps/dataset/data[2]/value">
		true
	</xsl:if>
	<br/>
	
	<h3>Compare using not(=)</h3>

	Compare with a string constant:
	<xsl:if test="not($data1value='DS1Value1')">
		true
	</xsl:if>

	Compare variables:
	<xsl:if test="not($data1value=$data2value)">
		true
	</xsl:if>
	<br/>
	
	Compare one seek with one variable, right side:	
	<xsl:if test="not($data1value=/sometimestamps/dataset/data[2]/value)">
		true
	</xsl:if>
	<br/>
	
	Compare one seek with one variable, left side:
	<xsl:if test="not(/sometimestamps/dataset/data[1]/value=$data2value)">
		true
	</xsl:if>
	<br/>
	
	Compare two seek values:
	<xsl:if test="not(/sometimestamps/dataset/data[1]/value=/sometimestamps/dataset/data[2]/value)">
		true
	</xsl:if>
	<br/>
	
	<h3>Compare using contains and string-length functions</h3>



	<h2>Choose test</h2>
	
	<h3>Equality (=)</h3>

	Compare with a string constant:
	<xsl:choose>
		<xsl:when test="$data1value='DS1Value1'">
			true
		</xsl:when>
		<xsl:otherwise>false</xsl:otherwise>
	</xsl:choose>
	<br/>	
	
	Compare variables:
	<xsl:choose>
		<xsl:when test="$data1value=$data2value">
			true
		</xsl:when>
		<xsl:otherwise>false</xsl:otherwise>
	</xsl:choose>
	<br/>

	Compare one seek with one variable, right side:	
	<xsl:choose>
		<xsl:when test="$data1value=/sometimestamps/dataset/data[2]/value">
			true
		</xsl:when>
		<xsl:otherwise>false</xsl:otherwise>
	</xsl:choose>
	<br/>

	Compare one seek with one variable, left side:
	<xsl:choose>
		<xsl:when test="/sometimestamps/dataset/data[1]/value=$data2value">
			true
		</xsl:when>
		<xsl:otherwise>false</xsl:otherwise>
	</xsl:choose>
	<br/>

	Compare two seek values:
	<xsl:choose>
		<xsl:when test="/sometimestamps/dataset/data[1]/value=/sometimestamps/dataset/data[2]/value">
			true
		</xsl:when>
		<xsl:otherwise>false</xsl:otherwise>
	</xsl:choose>
	<br/>

	<h3>Not Equality (!=)</h3>

	Compare with a string constant:
	<xsl:choose>
		<xsl:when test="$data1value!='DS1Value1'">
			true
		</xsl:when>
		<xsl:otherwise>false</xsl:otherwise>
	</xsl:choose>
	<br/>	
	
	Compare variables:
	<xsl:choose>
		<xsl:when test="$data1value!=$data2value">
			true
		</xsl:when>
		<xsl:otherwise>false</xsl:otherwise>
	</xsl:choose>
	<br/>

	Compare one seek with one variable, right side:	
	<xsl:choose>
		<xsl:when test="$data1value!=/sometimestamps/dataset/data[2]/value">
			true
		</xsl:when>
		<xsl:otherwise>false</xsl:otherwise>
	</xsl:choose>
	<br/>

	Compare one seek with one variable, left side:
	<xsl:choose>
		<xsl:when test="/sometimestamps/dataset/data[1]/value!=$data2value">
			true
		</xsl:when>
		<xsl:otherwise>false</xsl:otherwise>
	</xsl:choose>
	<br/>

	Compare two seek values:
	<xsl:choose>
		<xsl:when test="/sometimestamps/dataset/data[1]/value!=/sometimestamps/dataset/data[2]/value">
			true
		</xsl:when>
		<xsl:otherwise>false</xsl:otherwise>
	</xsl:choose>
	<br/>
	
	<h3>Compare using contains function</h3>

	</alias:body>
</alias:html>
</xsl:template>
</xsl:stylesheet>
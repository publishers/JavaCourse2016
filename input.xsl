<?xml version="1.0" encoding="UTF-8"?>
<!-- XSL transformation -->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:st3="http://nure.ua/malahin/SummaryTask3/entity" version="1.0">

	<xsl:template match="/st3:Weapon">
		<html>
			<head>
				<title>Weapon</title>
				<style type="text/css">
					td {border: 1px solid black; padding: 5px;}
					table{
					border: 1px solid black;
					float: left;
					margin-left:50px;
					}
				</style>
			</head>
			<body>
				<title>Knife</title>

				<xsl:apply-templates select="Knife" />

			</body>
		</html>
	</xsl:template>

	<xsl:template match="Knife">
		<table>
			<tr>
				<td>
					Type:
				</td>
				<td>
					<xsl:value-of select="Type" />
				</td>
			</tr>
			<tr>
				<td>
					Handy:
				</td>
				<td>
					<xsl:value-of select="Handy" />
				</td>
			</tr>
			<tr>
				<td>
					Origin:
				</td>
				<td>
					<xsl:value-of select="Origin" />
				</td>
			</tr>
			<tr>
				<td>
					Visual
				</td>
				<td>
					<xsl:apply-templates select="Visual" />
				</td>
			</tr>
			<tr>
				<td>
					Value
				</td>
				<td>
					<xsl:value-of select="Value" />
				</td>
			</tr>
		</table>
	</xsl:template>

	<xsl:template match="Visual">
		<table>
			<tr>
				<td>
					Width:
				</td>
				<td>
					<xsl:value-of select="Width" />
				</td>
			</tr>
			<tr>
				<td>
					Size:
				</td>
				<td>
					<xsl:value-of select="Size" />
				</td>
			</tr>
			<tr>
				<td>
					Material:
				</td>
				<td>
					<xsl:value-of select="Material" />
				</td>
			</tr>
			<tr>
				<td>
					Haft:
				</td>
				<td>
					<xsl:value-of select="Haft" />
				</td>
			</tr>
			<tr>
				<td>
					Krovostok:
				</td>
				<td>
					<xsl:apply-templates select="Krovostok" />
				</td>
			</tr>
		</table>
	</xsl:template>

	<xsl:template match="Krovostok">

		<xsl:if test="@isIt = 'true'">
			+
		</xsl:if>
	</xsl:template>

</xsl:stylesheet>
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" />
    <xsl:template match="/">
        <html>
        <head>
            <style>
                body {
                    font-family: Arial, sans-serif;
                }
                table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-bottom: 20px;
                }
                th, td {
                    border: 1px solid #ddd;
                    padding: 8px;
                    text-align: left;
                }
                th {
                    background-color: #f2f2f2;
                }
                .room-title {
                    background-color: #f0f0f0;
                    padding: 10px;
                    font-weight: bold;
                }
            </style>
        </head>
        <body>
            <h1>Smart Home Dashboard</h1>
            <xsl:for-each select="SmartHome/Room">
                <div>
                    <h2 class="room-title"><xsl:value-of select="@name"/></h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Device Type</th>
                                <th>Device ID</th>
                                <th>Status</th>
                                <th>Brightness</th>
                                <th>Temperature</th>
                                <th>Mode</th>
                            </tr>
                        </thead>
                        <tbody>
                            <xsl:for-each select="Device">
                                <tr>
                                    <td><xsl:value-of select="@type"/></td>
                                    <td><xsl:value-of select="@id"/></td>
                                    <td><xsl:value-of select="Status"/></td>
                                    <td>
                                        <xsl:choose>
                                            <xsl:when test="Brightness">
                                                <xsl:value-of select="Brightness"/>
                                            </xsl:when>
                                            <xsl:otherwise>N/A</xsl:otherwise>
                                        </xsl:choose>
                                    </td>
                                    <td>
                                        <xsl:choose>
                                            <xsl:when test="Temperature">
                                                <xsl:value-of select="Temperature"/>
                                            </xsl:when>
                                            <xsl:otherwise>N/A</xsl:otherwise>
                                        </xsl:choose>
                                    </td>
                                    <td>
                                        <xsl:choose>
                                            <xsl:when test="Mode">
                                                <xsl:value-of select="Mode"/>
                                            </xsl:when>
                                            <xsl:otherwise>N/A</xsl:otherwise>
                                        </xsl:choose>
                                    </td>
                                </tr>
                            </xsl:for-each>
                        </tbody>
                    </table>
                </div>
            </xsl:for-each>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

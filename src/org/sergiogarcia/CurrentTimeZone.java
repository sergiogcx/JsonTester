package org.sergiogarcia;

import java.io.Serializable;
import java.util.HashMap;


/*

        Demo Format:

        {
          "status":"OK",
          "message":"",
          "countryCode":"US",
          "countryName":"United States",
          "zoneName":"America\/Chicago",
          "abbreviation":"CST",
          "gmtOffset":-21600,
          "dst":"0",
          "dstStart":1446361200,
          "dstEnd":1457856000,
          "nextAbbreviation":"CDT",
          "timestamp":1454446991,
          "formatted":"2016-02-02 21:03:11"
        }

*/

public class CurrentTimeZone implements Serializable {
    private String status;
    private String message;
    public String countryCode;
    public String countryName;
    public String zoneName;
    public String abbreviation;
    private int gmtOffset;
    private String dst;
    private int dstStart;
    private int dstEnd;
    private String nextAbbreviation;
    private int timestamp;
    public String formatted;


    public CurrentTimeZone(String status, String message, String countryCode,
                           String countryName, String zoneName, String abbreviation,
                           int gmtOffset, String dst, int dstStart, int dstEnd,
                           String nextAbbreviation, int timestamp, String formatted) {

        this.status = status;
        this.message = message;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.zoneName = zoneName;
        this.abbreviation = abbreviation;
        this.gmtOffset = gmtOffset;
        this.dst = dst;
        this.dstStart = dstStart;
        this.dstEnd = dstEnd;
        this.nextAbbreviation = nextAbbreviation;
        this.timestamp = timestamp;
        this.formatted = formatted;
    }




    public CurrentTimeZone(HashMap aMapRepresentation){
        this.status = (String)aMapRepresentation.get("status");
        this.message = (String)aMapRepresentation.get("message");
        this.countryCode = (String)aMapRepresentation.get("countryCode");
        this.countryName = (String)aMapRepresentation.get("countryName");
        this.zoneName = (String)aMapRepresentation.get("zoneName");
        this.abbreviation = (String)aMapRepresentation.get("abbreviation");
        Long gmtOffset = (Long)aMapRepresentation.get("gmtOffset");
        this.gmtOffset = gmtOffset.intValue();
        this.dst = (String)aMapRepresentation.get("abbreviation");
        Long dstStart = (Long)aMapRepresentation.get("dstStart");
        this.dstStart = dstStart.intValue();
        Long dstEnd = (Long)aMapRepresentation.get("dstEnd");
        this.dstEnd = dstEnd.intValue();
        this.nextAbbreviation = (String)aMapRepresentation.get("nextAbbreviation");
        Long timestamp = (Long)aMapRepresentation.get("timestamp");
        this.timestamp = timestamp.intValue();
        this.formatted = (String)aMapRepresentation.get("formatted");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CurrentTimeZone other = (CurrentTimeZone) obj;


        // Test Each Field
        return true;
    }

}

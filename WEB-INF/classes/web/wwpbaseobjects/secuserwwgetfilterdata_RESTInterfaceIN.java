package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "wwpbaseobjects.secuserwwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class secuserwwgetfilterdata_RESTInterfaceIN
{
   String AV19DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV19DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV19DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV19DDOName = "" ;
      }
      else
      {
         AV19DDOName= Value;
      }
   }


   String AV17SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV17SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV17SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV17SearchTxt = "" ;
      }
      else
      {
         AV17SearchTxt= Value;
      }
   }


   String AV18SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV18SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV18SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV18SearchTxtTo = "" ;
      }
      else
      {
         AV18SearchTxtTo= Value;
      }
   }


}


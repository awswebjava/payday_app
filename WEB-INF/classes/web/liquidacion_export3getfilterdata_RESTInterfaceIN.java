package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "liquidacion_export3getfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class liquidacion_export3getfilterdata_RESTInterfaceIN
{
   String AV80DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV80DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV80DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV80DDOName = "" ;
      }
      else
      {
         AV80DDOName= Value;
      }
   }


   String AV81SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV81SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV81SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV81SearchTxt = "" ;
      }
      else
      {
         AV81SearchTxt= Value;
      }
   }


   String AV82SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV82SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV82SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV82SearchTxtTo = "" ;
      }
      else
      {
         AV82SearchTxtTo= Value;
      }
   }


}


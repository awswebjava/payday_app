package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "esquemacategoriawwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class esquemacategoriawwgetfilterdata_RESTInterfaceIN
{
   String AV35DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV35DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV35DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV35DDOName = "" ;
      }
      else
      {
         AV35DDOName= Value;
      }
   }


   String AV36SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV36SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV36SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV36SearchTxt = "" ;
      }
      else
      {
         AV36SearchTxt= Value;
      }
   }


   String AV37SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV37SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV37SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV37SearchTxtTo = "" ;
      }
      else
      {
         AV37SearchTxtTo= Value;
      }
   }


}


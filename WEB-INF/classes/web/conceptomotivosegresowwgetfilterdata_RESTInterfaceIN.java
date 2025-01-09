package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "conceptomotivosegresowwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class conceptomotivosegresowwgetfilterdata_RESTInterfaceIN
{
   String AV38DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV38DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV38DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV38DDOName = "" ;
      }
      else
      {
         AV38DDOName= Value;
      }
   }


   String AV39SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV39SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV39SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV39SearchTxt = "" ;
      }
      else
      {
         AV39SearchTxt= Value;
      }
   }


   String AV40SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV40SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV40SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV40SearchTxtTo = "" ;
      }
      else
      {
         AV40SearchTxtTo= Value;
      }
   }


}


package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "localidadwwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class localidadwwgetfilterdata_RESTInterfaceIN
{
   String AV27DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV27DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV27DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV27DDOName = "" ;
      }
      else
      {
         AV27DDOName= Value;
      }
   }


   String AV25SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV25SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV25SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV25SearchTxt = "" ;
      }
      else
      {
         AV25SearchTxt= Value;
      }
   }


   String AV26SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV26SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV26SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV26SearchTxtTo = "" ;
      }
      else
      {
         AV26SearchTxtTo= Value;
      }
   }


}


package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "clientewwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class clientewwgetfilterdata_RESTInterfaceIN
{
   String AV40DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV40DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV40DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV40DDOName = "" ;
      }
      else
      {
         AV40DDOName= Value;
      }
   }


   String AV41SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV41SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV41SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV41SearchTxt = "" ;
      }
      else
      {
         AV41SearchTxt= Value;
      }
   }


   String AV42SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV42SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV42SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV42SearchTxtTo = "" ;
      }
      else
      {
         AV42SearchTxtTo= Value;
      }
   }


}


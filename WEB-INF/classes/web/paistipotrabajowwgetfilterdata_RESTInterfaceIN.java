package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "paistipotrabajowwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class paistipotrabajowwgetfilterdata_RESTInterfaceIN
{
   String AV45DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV45DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV45DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV45DDOName = "" ;
      }
      else
      {
         AV45DDOName= Value;
      }
   }


   String AV46SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV46SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV46SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV46SearchTxt = "" ;
      }
      else
      {
         AV46SearchTxt= Value;
      }
   }


   String AV47SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV47SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV47SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV47SearchTxtTo = "" ;
      }
      else
      {
         AV47SearchTxtTo= Value;
      }
   }


}


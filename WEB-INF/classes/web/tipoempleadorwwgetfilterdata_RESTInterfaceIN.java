package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "tipoempleadorwwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class tipoempleadorwwgetfilterdata_RESTInterfaceIN
{
   String AV31DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV31DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV31DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV31DDOName = "" ;
      }
      else
      {
         AV31DDOName= Value;
      }
   }


   String AV32SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV32SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV32SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV32SearchTxt = "" ;
      }
      else
      {
         AV32SearchTxt= Value;
      }
   }


   String AV33SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV33SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV33SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV33SearchTxtTo = "" ;
      }
      else
      {
         AV33SearchTxtTo= Value;
      }
   }


}


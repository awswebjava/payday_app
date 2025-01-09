package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "conceptos_exportwwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class conceptos_exportwwgetfilterdata_RESTInterfaceIN
{
   String AV79DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV79DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV79DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV79DDOName = "" ;
      }
      else
      {
         AV79DDOName= Value;
      }
   }


   String AV80SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV80SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV80SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV80SearchTxt = "" ;
      }
      else
      {
         AV80SearchTxt= Value;
      }
   }


   String AV81SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV81SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV81SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV81SearchTxtTo = "" ;
      }
      else
      {
         AV81SearchTxtTo= Value;
      }
   }


}


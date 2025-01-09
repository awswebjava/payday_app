package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "convenio_base_calculowwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class convenio_base_calculowwgetfilterdata_RESTInterfaceIN
{
   String AV58DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV58DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV58DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV58DDOName = "" ;
      }
      else
      {
         AV58DDOName= Value;
      }
   }


   String AV59SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV59SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV59SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV59SearchTxt = "" ;
      }
      else
      {
         AV59SearchTxt= Value;
      }
   }


   String AV60SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV60SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV60SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV60SearchTxtTo = "" ;
      }
      else
      {
         AV60SearchTxtTo= Value;
      }
   }


}


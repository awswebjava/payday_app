package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "soap_locationwwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class soap_locationwwgetfilterdata_RESTInterfaceIN
{
   String AV44DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV44DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV44DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV44DDOName = "" ;
      }
      else
      {
         AV44DDOName= Value;
      }
   }


   String AV45SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV45SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV45SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV45SearchTxt = "" ;
      }
      else
      {
         AV45SearchTxt= Value;
      }
   }


   String AV46SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV46SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV46SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV46SearchTxtTo = "" ;
      }
      else
      {
         AV46SearchTxtTo= Value;
      }
   }


}


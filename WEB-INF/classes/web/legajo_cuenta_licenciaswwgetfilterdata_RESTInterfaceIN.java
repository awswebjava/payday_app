package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "legajo_cuenta_licenciaswwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class legajo_cuenta_licenciaswwgetfilterdata_RESTInterfaceIN
{
   String AV48DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV48DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV48DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV48DDOName = "" ;
      }
      else
      {
         AV48DDOName= Value;
      }
   }


   String AV49SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV49SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV49SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV49SearchTxt = "" ;
      }
      else
      {
         AV49SearchTxt= Value;
      }
   }


   String AV50SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV50SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV50SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV50SearchTxtTo = "" ;
      }
      else
      {
         AV50SearchTxtTo= Value;
      }
   }


}


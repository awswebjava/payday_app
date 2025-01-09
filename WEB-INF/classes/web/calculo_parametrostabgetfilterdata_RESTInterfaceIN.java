package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "calculo_parametrostabgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class calculo_parametrostabgetfilterdata_RESTInterfaceIN
{
   String AV49DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV49DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV49DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV49DDOName = "" ;
      }
      else
      {
         AV49DDOName= Value;
      }
   }


   String AV50SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV50SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV50SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV50SearchTxt = "" ;
      }
      else
      {
         AV50SearchTxt= Value;
      }
   }


   String AV51SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV51SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV51SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV51SearchTxtTo = "" ;
      }
      else
      {
         AV51SearchTxtTo= Value;
      }
   }


}


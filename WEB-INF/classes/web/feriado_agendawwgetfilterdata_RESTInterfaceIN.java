package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "feriado_agendawwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class feriado_agendawwgetfilterdata_RESTInterfaceIN
{
   String AV46DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV46DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV46DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV46DDOName = "" ;
      }
      else
      {
         AV46DDOName= Value;
      }
   }


   String AV47SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV47SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV47SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV47SearchTxt = "" ;
      }
      else
      {
         AV47SearchTxt= Value;
      }
   }


   String AV48SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV48SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV48SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV48SearchTxtTo = "" ;
      }
      else
      {
         AV48SearchTxtTo= Value;
      }
   }


}


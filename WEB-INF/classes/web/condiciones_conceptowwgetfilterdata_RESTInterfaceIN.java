package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "condiciones_conceptowwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class condiciones_conceptowwgetfilterdata_RESTInterfaceIN
{
   String AV30DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV30DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV30DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV30DDOName = "" ;
      }
      else
      {
         AV30DDOName= Value;
      }
   }


   String AV31SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV31SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV31SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV31SearchTxt = "" ;
      }
      else
      {
         AV31SearchTxt= Value;
      }
   }


   String AV32SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV32SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV32SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV32SearchTxtTo = "" ;
      }
      else
      {
         AV32SearchTxtTo= Value;
      }
   }


}


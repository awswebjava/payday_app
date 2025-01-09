package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "templaterecibowwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class templaterecibowwgetfilterdata_RESTInterfaceIN
{
   String AV32DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV32DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV32DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV32DDOName = "" ;
      }
      else
      {
         AV32DDOName= Value;
      }
   }


   String AV33SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV33SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV33SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV33SearchTxt = "" ;
      }
      else
      {
         AV33SearchTxt= Value;
      }
   }


   String AV34SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV34SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV34SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV34SearchTxtTo = "" ;
      }
      else
      {
         AV34SearchTxtTo= Value;
      }
   }


}

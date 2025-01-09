package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "banda_salarialwwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class banda_salarialwwgetfilterdata_RESTInterfaceIN
{
   String AV33DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV33DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV33DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV33DDOName = "" ;
      }
      else
      {
         AV33DDOName= Value;
      }
   }


   String AV34SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV34SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV34SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV34SearchTxt = "" ;
      }
      else
      {
         AV34SearchTxt= Value;
      }
   }


   String AV35SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV35SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV35SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV35SearchTxtTo = "" ;
      }
      else
      {
         AV35SearchTxtTo= Value;
      }
   }


}


package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "conceptowwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class conceptowwgetfilterdata_RESTInterfaceIN
{
   String AV37DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV37DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV37DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV37DDOName = "" ;
      }
      else
      {
         AV37DDOName= Value;
      }
   }


   String AV35SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV35SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV35SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV35SearchTxt = "" ;
      }
      else
      {
         AV35SearchTxt= Value;
      }
   }


   String AV36SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV36SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV36SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV36SearchTxtTo = "" ;
      }
      else
      {
         AV36SearchTxtTo= Value;
      }
   }


}


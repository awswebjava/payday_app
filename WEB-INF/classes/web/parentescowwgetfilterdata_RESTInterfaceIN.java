package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "parentescowwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class parentescowwgetfilterdata_RESTInterfaceIN
{
   String AV21DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV21DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV21DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV21DDOName = "" ;
      }
      else
      {
         AV21DDOName= Value;
      }
   }


   String AV19SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV19SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV19SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV19SearchTxt = "" ;
      }
      else
      {
         AV19SearchTxt= Value;
      }
   }


   String AV20SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV20SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV20SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV20SearchTxtTo = "" ;
      }
      else
      {
         AV20SearchTxtTo= Value;
      }
   }


}


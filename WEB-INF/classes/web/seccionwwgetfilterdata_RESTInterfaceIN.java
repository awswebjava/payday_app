package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "seccionwwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class seccionwwgetfilterdata_RESTInterfaceIN
{
   String AV17DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV17DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV17DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV17DDOName = "" ;
      }
      else
      {
         AV17DDOName= Value;
      }
   }


   String AV15SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV15SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV15SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV15SearchTxt = "" ;
      }
      else
      {
         AV15SearchTxt= Value;
      }
   }


   String AV16SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV16SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV16SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV16SearchTxtTo = "" ;
      }
      else
      {
         AV16SearchTxtTo= Value;
      }
   }


}


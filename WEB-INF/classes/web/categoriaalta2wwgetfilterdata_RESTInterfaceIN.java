package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "categoriaalta2wwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class categoriaalta2wwgetfilterdata_RESTInterfaceIN
{
   String AV26DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV26DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV26DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV26DDOName = "" ;
      }
      else
      {
         AV26DDOName= Value;
      }
   }


   String AV27SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV27SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV27SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV27SearchTxt = "" ;
      }
      else
      {
         AV27SearchTxt= Value;
      }
   }


   String AV28SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV28SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV28SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV28SearchTxtTo = "" ;
      }
      else
      {
         AV28SearchTxtTo= Value;
      }
   }


}


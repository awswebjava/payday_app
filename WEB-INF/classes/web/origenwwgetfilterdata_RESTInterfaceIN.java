package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "origenwwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class origenwwgetfilterdata_RESTInterfaceIN
{
   String AV29DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV29DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV29DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV29DDOName = "" ;
      }
      else
      {
         AV29DDOName= Value;
      }
   }


   String AV30SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV30SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV30SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV30SearchTxt = "" ;
      }
      else
      {
         AV30SearchTxt= Value;
      }
   }


   String AV31SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV31SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV31SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV31SearchTxtTo = "" ;
      }
      else
      {
         AV31SearchTxtTo= Value;
      }
   }


}


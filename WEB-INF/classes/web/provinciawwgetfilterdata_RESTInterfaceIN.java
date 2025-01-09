package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "provinciawwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class provinciawwgetfilterdata_RESTInterfaceIN
{
   String AV28DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV28DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV28DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV28DDOName = "" ;
      }
      else
      {
         AV28DDOName= Value;
      }
   }


   String AV29SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV29SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV29SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV29SearchTxt = "" ;
      }
      else
      {
         AV29SearchTxt= Value;
      }
   }


   String AV30SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV30SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV30SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV30SearchTxtTo = "" ;
      }
      else
      {
         AV30SearchTxtTo= Value;
      }
   }


}


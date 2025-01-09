package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "paramwwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class paramwwgetfilterdata_RESTInterfaceIN
{
   String AV18DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV18DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV18DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV18DDOName = "" ;
      }
      else
      {
         AV18DDOName= Value;
      }
   }


   String AV16SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV16SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV16SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV16SearchTxt = "" ;
      }
      else
      {
         AV16SearchTxt= Value;
      }
   }


   String AV17SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV17SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV17SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV17SearchTxtTo = "" ;
      }
      else
      {
         AV17SearchTxtTo= Value;
      }
   }


}


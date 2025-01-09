package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "legajo_permanenciawwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class legajo_permanenciawwgetfilterdata_RESTInterfaceIN
{
   String AV47DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV47DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV47DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV47DDOName = "" ;
      }
      else
      {
         AV47DDOName= Value;
      }
   }


   String AV48SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV48SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV48SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV48SearchTxt = "" ;
      }
      else
      {
         AV48SearchTxt= Value;
      }
   }


   String AV49SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV49SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV49SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV49SearchTxtTo = "" ;
      }
      else
      {
         AV49SearchTxtTo= Value;
      }
   }


}


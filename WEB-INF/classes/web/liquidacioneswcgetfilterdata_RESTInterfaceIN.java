package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "liquidacioneswcgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class liquidacioneswcgetfilterdata_RESTInterfaceIN
{
   String AV50DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV50DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV50DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV50DDOName = "" ;
      }
      else
      {
         AV50DDOName= Value;
      }
   }


   String AV51SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV51SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV51SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV51SearchTxt = "" ;
      }
      else
      {
         AV51SearchTxt= Value;
      }
   }


   String AV52SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV52SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV52SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV52SearchTxtTo = "" ;
      }
      else
      {
         AV52SearchTxtTo= Value;
      }
   }


}


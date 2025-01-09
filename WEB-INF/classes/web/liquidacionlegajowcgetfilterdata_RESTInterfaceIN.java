package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "liquidacionlegajowcgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class liquidacionlegajowcgetfilterdata_RESTInterfaceIN
{
   String AV15DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV15DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV15DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV15DDOName = "" ;
      }
      else
      {
         AV15DDOName= Value;
      }
   }


   String AV13SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV13SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV13SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV13SearchTxt = "" ;
      }
      else
      {
         AV13SearchTxt= Value;
      }
   }


   String AV14SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV14SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV14SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV14SearchTxtTo = "" ;
      }
      else
      {
         AV14SearchTxtTo= Value;
      }
   }


}


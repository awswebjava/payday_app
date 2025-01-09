package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "importlsd2getfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class importlsd2getfilterdata_RESTInterfaceIN
{
   String AV54DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV54DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV54DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV54DDOName = "" ;
      }
      else
      {
         AV54DDOName= Value;
      }
   }


   String AV52SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV52SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV52SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV52SearchTxt = "" ;
      }
      else
      {
         AV52SearchTxt= Value;
      }
   }


   String AV53SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV53SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV53SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV53SearchTxtTo = "" ;
      }
      else
      {
         AV53SearchTxtTo= Value;
      }
   }


}


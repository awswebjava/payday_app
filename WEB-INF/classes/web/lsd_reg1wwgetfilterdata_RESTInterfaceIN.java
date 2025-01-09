package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "lsd_reg1wwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class lsd_reg1wwgetfilterdata_RESTInterfaceIN
{
   String AV39DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV39DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV39DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV39DDOName = "" ;
      }
      else
      {
         AV39DDOName= Value;
      }
   }


   String AV40SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV40SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV40SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV40SearchTxt = "" ;
      }
      else
      {
         AV40SearchTxt= Value;
      }
   }


   String AV41SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV41SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV41SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV41SearchTxtTo = "" ;
      }
      else
      {
         AV41SearchTxtTo= Value;
      }
   }


}


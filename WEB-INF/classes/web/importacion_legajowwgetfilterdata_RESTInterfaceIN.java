package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "importacion_legajowwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class importacion_legajowwgetfilterdata_RESTInterfaceIN
{
   String AV76DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV76DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV76DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV76DDOName = "" ;
      }
      else
      {
         AV76DDOName= Value;
      }
   }


   String AV74SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV74SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV74SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV74SearchTxt = "" ;
      }
      else
      {
         AV74SearchTxt= Value;
      }
   }


   String AV75SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV75SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV75SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV75SearchTxtTo = "" ;
      }
      else
      {
         AV75SearchTxtTo= Value;
      }
   }


}


package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "condicion_exencion_iiggwwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class condicion_exencion_iiggwwgetfilterdata_RESTInterfaceIN
{
   String AV37DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV37DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV37DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV37DDOName = "" ;
      }
      else
      {
         AV37DDOName= Value;
      }
   }


   String AV38SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV38SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV38SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV38SearchTxt = "" ;
      }
      else
      {
         AV38SearchTxt= Value;
      }
   }


   String AV39SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV39SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV39SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV39SearchTxtTo = "" ;
      }
      else
      {
         AV39SearchTxtTo= Value;
      }
   }


}


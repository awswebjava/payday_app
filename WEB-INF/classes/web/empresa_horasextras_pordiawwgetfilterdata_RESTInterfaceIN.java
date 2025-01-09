package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "empresa_horasextras_pordiawwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class empresa_horasextras_pordiawwgetfilterdata_RESTInterfaceIN
{
   String AV36DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV36DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV36DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV36DDOName = "" ;
      }
      else
      {
         AV36DDOName= Value;
      }
   }


   String AV37SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV37SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV37SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV37SearchTxt = "" ;
      }
      else
      {
         AV37SearchTxt= Value;
      }
   }


   String AV38SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV38SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV38SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV38SearchTxtTo = "" ;
      }
      else
      {
         AV38SearchTxtTo= Value;
      }
   }


}


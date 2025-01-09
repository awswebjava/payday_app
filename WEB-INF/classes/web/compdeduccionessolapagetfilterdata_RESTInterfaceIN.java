package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "compdeduccionessolapagetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class compdeduccionessolapagetfilterdata_RESTInterfaceIN
{
   String AV25DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV25DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV25DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV25DDOName = "" ;
      }
      else
      {
         AV25DDOName= Value;
      }
   }


   String AV23SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV23SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV23SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV23SearchTxt = "" ;
      }
      else
      {
         AV23SearchTxt= Value;
      }
   }


   String AV24SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV24SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV24SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV24SearchTxtTo = "" ;
      }
      else
      {
         AV24SearchTxtTo= Value;
      }
   }


}


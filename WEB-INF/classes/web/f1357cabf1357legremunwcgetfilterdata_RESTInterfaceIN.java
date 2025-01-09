package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "f1357cabf1357legremunwcgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class f1357cabf1357legremunwcgetfilterdata_RESTInterfaceIN
{
   String AV16DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV16DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV16DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV16DDOName = "" ;
      }
      else
      {
         AV16DDOName= Value;
      }
   }


   String AV14SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV14SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV14SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV14SearchTxt = "" ;
      }
      else
      {
         AV14SearchTxt= Value;
      }
   }


   String AV15SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV15SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV15SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV15SearchTxtTo = "" ;
      }
      else
      {
         AV15SearchTxtTo= Value;
      }
   }


}


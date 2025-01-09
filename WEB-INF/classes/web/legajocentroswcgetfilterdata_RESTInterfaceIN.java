package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "legajocentroswcgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class legajocentroswcgetfilterdata_RESTInterfaceIN
{
   String AV20DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV20DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV20DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV20DDOName = "" ;
      }
      else
      {
         AV20DDOName= Value;
      }
   }


   String AV18SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV18SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV18SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV18SearchTxt = "" ;
      }
      else
      {
         AV18SearchTxt= Value;
      }
   }


   String AV19SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV19SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV19SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV19SearchTxtTo = "" ;
      }
      else
      {
         AV19SearchTxtTo= Value;
      }
   }


}


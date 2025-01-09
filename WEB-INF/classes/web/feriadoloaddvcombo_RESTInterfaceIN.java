package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "feriadoloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class feriadoloaddvcombo_RESTInterfaceIN
{
   String AV15ComboName;
   @JsonProperty("ComboName")
   public String getComboName( )
   {
      if ( GXutil.strcmp(AV15ComboName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV15ComboName ;
      }
   }

   @JsonProperty("ComboName")
   public void setComboName(  String Value )
   {
      if ( Value == null )
      {
         AV15ComboName = "" ;
      }
      else
      {
         AV15ComboName= Value;
      }
   }


   String AV16TrnMode;
   @JsonProperty("TrnMode")
   public String getTrnMode( )
   {
      if ( GXutil.strcmp(AV16TrnMode, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV16TrnMode ;
      }
   }

   @JsonProperty("TrnMode")
   public void setTrnMode(  String Value )
   {
      if ( Value == null )
      {
         AV16TrnMode = "" ;
      }
      else
      {
         AV16TrnMode= Value;
      }
   }


   boolean AV17IsDynamicCall;
   @JsonProperty("IsDynamicCall")
   public boolean getIsDynamicCall( )
   {
      return AV17IsDynamicCall ;
   }

   @JsonProperty("IsDynamicCall")
   public void setIsDynamicCall(  boolean Value )
   {
      AV17IsDynamicCall= Value;
   }


   short AV18PaiCod;
   @JsonProperty("PaiCod")
   public short getPaiCod( )
   {
      return AV18PaiCod ;
   }

   @JsonProperty("PaiCod")
   public void setPaiCod(  short Value )
   {
      AV18PaiCod= Value;
   }


   String AV19FerId;
   @JsonProperty("FerId")
   public String getFerId( )
   {
      if ( GXutil.strcmp(AV19FerId, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV19FerId ;
      }
   }

   @JsonProperty("FerId")
   public void setFerId(  String Value )
   {
      if ( Value == null )
      {
         AV19FerId = "" ;
      }
      else
      {
         AV19FerId= Value;
      }
   }


   short AV30Cond_PaiCod;
   @JsonProperty("Cond_PaiCod")
   public short getCond_PaiCod( )
   {
      return AV30Cond_PaiCod ;
   }

   @JsonProperty("Cond_PaiCod")
   public void setCond_PaiCod(  short Value )
   {
      AV30Cond_PaiCod= Value;
   }


   String AV12SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV12SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV12SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV12SearchTxt = "" ;
      }
      else
      {
         AV12SearchTxt= Value;
      }
   }


}


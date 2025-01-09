package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "localidadloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class localidadloaddvcombo_RESTInterfaceIN
{
   String AV17ComboName;
   @JsonProperty("ComboName")
   public String getComboName( )
   {
      if ( GXutil.strcmp(AV17ComboName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV17ComboName ;
      }
   }

   @JsonProperty("ComboName")
   public void setComboName(  String Value )
   {
      if ( Value == null )
      {
         AV17ComboName = "" ;
      }
      else
      {
         AV17ComboName= Value;
      }
   }


   String AV19TrnMode;
   @JsonProperty("TrnMode")
   public String getTrnMode( )
   {
      if ( GXutil.strcmp(AV19TrnMode, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV19TrnMode ;
      }
   }

   @JsonProperty("TrnMode")
   public void setTrnMode(  String Value )
   {
      if ( Value == null )
      {
         AV19TrnMode = "" ;
      }
      else
      {
         AV19TrnMode= Value;
      }
   }


   boolean AV22IsDynamicCall;
   @JsonProperty("IsDynamicCall")
   public boolean getIsDynamicCall( )
   {
      return AV22IsDynamicCall ;
   }

   @JsonProperty("IsDynamicCall")
   public void setIsDynamicCall(  boolean Value )
   {
      AV22IsDynamicCall= Value;
   }


   short AV25PaiCod;
   @JsonProperty("PaiCod")
   public short getPaiCod( )
   {
      return AV25PaiCod ;
   }

   @JsonProperty("PaiCod")
   public void setPaiCod(  short Value )
   {
      AV25PaiCod= Value;
   }


   short AV26ProvCod;
   @JsonProperty("ProvCod")
   public short getProvCod( )
   {
      return AV26ProvCod ;
   }

   @JsonProperty("ProvCod")
   public void setProvCod(  short Value )
   {
      AV26ProvCod= Value;
   }


   short AV27LocCod;
   @JsonProperty("LocCod")
   public short getLocCod( )
   {
      return AV27LocCod ;
   }

   @JsonProperty("LocCod")
   public void setLocCod(  short Value )
   {
      AV27LocCod= Value;
   }


   short AV28Cond_PaiCod;
   @JsonProperty("Cond_PaiCod")
   public short getCond_PaiCod( )
   {
      return AV28Cond_PaiCod ;
   }

   @JsonProperty("Cond_PaiCod")
   public void setCond_PaiCod(  short Value )
   {
      AV28Cond_PaiCod= Value;
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


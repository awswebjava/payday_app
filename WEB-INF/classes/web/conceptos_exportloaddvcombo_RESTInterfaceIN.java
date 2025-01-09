package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "conceptos_exportloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class conceptos_exportloaddvcombo_RESTInterfaceIN
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


   int AV18CliCod;
   @JsonProperty("CliCod")
   public int getCliCod( )
   {
      return AV18CliCod ;
   }

   @JsonProperty("CliCod")
   public void setCliCod(  int Value )
   {
      AV18CliCod= Value;
   }


   String AV19ConCodigo;
   @JsonProperty("ConCodigo")
   public String getConCodigo( )
   {
      if ( GXutil.strcmp(AV19ConCodigo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV19ConCodigo ;
      }
   }

   @JsonProperty("ConCodigo")
   public void setConCodigo(  String Value )
   {
      if ( Value == null )
      {
         AV19ConCodigo = "" ;
      }
      else
      {
         AV19ConCodigo= Value;
      }
   }


   String AV29Cond_TipoConCod;
   @JsonProperty("Cond_TipoConCod")
   public String getCond_TipoConCod( )
   {
      if ( GXutil.strcmp(AV29Cond_TipoConCod, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV29Cond_TipoConCod ;
      }
   }

   @JsonProperty("Cond_TipoConCod")
   public void setCond_TipoConCod(  String Value )
   {
      if ( Value == null )
      {
         AV29Cond_TipoConCod = "" ;
      }
      else
      {
         AV29Cond_TipoConCod= Value;
      }
   }


   String AV30Cond_SubTipoConCod1;
   @JsonProperty("Cond_SubTipoConCod1")
   public String getCond_SubTipoConCod1( )
   {
      if ( GXutil.strcmp(AV30Cond_SubTipoConCod1, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV30Cond_SubTipoConCod1 ;
      }
   }

   @JsonProperty("Cond_SubTipoConCod1")
   public void setCond_SubTipoConCod1(  String Value )
   {
      if ( Value == null )
      {
         AV30Cond_SubTipoConCod1 = "" ;
      }
      else
      {
         AV30Cond_SubTipoConCod1= Value;
      }
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


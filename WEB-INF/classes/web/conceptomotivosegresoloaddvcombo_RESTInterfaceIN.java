package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "conceptomotivosegresoloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class conceptomotivosegresoloaddvcombo_RESTInterfaceIN
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


   String AV32ConCodigo;
   @JsonProperty("ConCodigo")
   public String getConCodigo( )
   {
      if ( GXutil.strcmp(AV32ConCodigo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV32ConCodigo ;
      }
   }

   @JsonProperty("ConCodigo")
   public void setConCodigo(  String Value )
   {
      if ( Value == null )
      {
         AV32ConCodigo = "" ;
      }
      else
      {
         AV32ConCodigo= Value;
      }
   }


   String AV20MegCodigo;
   @JsonProperty("MegCodigo")
   public String getMegCodigo( )
   {
      if ( GXutil.strcmp(AV20MegCodigo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV20MegCodigo ;
      }
   }

   @JsonProperty("MegCodigo")
   public void setMegCodigo(  String Value )
   {
      if ( Value == null )
      {
         AV20MegCodigo = "" ;
      }
      else
      {
         AV20MegCodigo= Value;
      }
   }


   short AV33ConMegSec;
   @JsonProperty("ConMegSec")
   public short getConMegSec( )
   {
      return AV33ConMegSec ;
   }

   @JsonProperty("ConMegSec")
   public void setConMegSec(  short Value )
   {
      AV33ConMegSec= Value;
   }


   int AV30Cond_CliCod;
   @JsonProperty("Cond_CliCod")
   public int getCond_CliCod( )
   {
      return AV30Cond_CliCod ;
   }

   @JsonProperty("Cond_CliCod")
   public void setCond_CliCod(  int Value )
   {
      AV30Cond_CliCod= Value;
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


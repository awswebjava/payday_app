package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "convenio_adicional_importesloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class convenio_adicional_importesloaddvcombo_RESTInterfaceIN
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


   int AV32CliCod;
   @JsonProperty("CliCod")
   public int getCliCod( )
   {
      return AV32CliCod ;
   }

   @JsonProperty("CliCod")
   public void setCliCod(  int Value )
   {
      AV32CliCod= Value;
   }


   short AV34CliPaiConve;
   @JsonProperty("CliPaiConve")
   public short getCliPaiConve( )
   {
      return AV34CliPaiConve ;
   }

   @JsonProperty("CliPaiConve")
   public void setCliPaiConve(  short Value )
   {
      AV34CliPaiConve= Value;
   }


   String AV35CliConvenio;
   @JsonProperty("CliConvenio")
   public String getCliConvenio( )
   {
      if ( GXutil.strcmp(AV35CliConvenio, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV35CliConvenio ;
      }
   }

   @JsonProperty("CliConvenio")
   public void setCliConvenio(  String Value )
   {
      if ( Value == null )
      {
         AV35CliConvenio = "" ;
      }
      else
      {
         AV35CliConvenio= Value;
      }
   }


   String AV20ConveAdicod;
   @JsonProperty("ConveAdicod")
   public String getConveAdicod( )
   {
      if ( GXutil.strcmp(AV20ConveAdicod, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV20ConveAdicod ;
      }
   }

   @JsonProperty("ConveAdicod")
   public void setConveAdicod(  String Value )
   {
      if ( Value == null )
      {
         AV20ConveAdicod = "" ;
      }
      else
      {
         AV20ConveAdicod= Value;
      }
   }


   String AV21ConveAdiVig;
   @JsonProperty("ConveAdiVig")
   public String getConveAdiVig( )
   {
      return AV21ConveAdiVig ;
   }

   @JsonProperty("ConveAdiVig")
   public void setConveAdiVig(  String Value )
   {
      AV21ConveAdiVig= Value;
   }


   int AV36Cond_CliCod;
   @JsonProperty("Cond_CliCod")
   public int getCond_CliCod( )
   {
      return AV36Cond_CliCod ;
   }

   @JsonProperty("Cond_CliCod")
   public void setCond_CliCod(  int Value )
   {
      AV36Cond_CliCod= Value;
   }


   short AV37Cond_CliPaiConve;
   @JsonProperty("Cond_CliPaiConve")
   public short getCond_CliPaiConve( )
   {
      return AV37Cond_CliPaiConve ;
   }

   @JsonProperty("Cond_CliPaiConve")
   public void setCond_CliPaiConve(  short Value )
   {
      AV37Cond_CliPaiConve= Value;
   }


   String AV38Cond_CliConvenio;
   @JsonProperty("Cond_CliConvenio")
   public String getCond_CliConvenio( )
   {
      if ( GXutil.strcmp(AV38Cond_CliConvenio, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV38Cond_CliConvenio ;
      }
   }

   @JsonProperty("Cond_CliConvenio")
   public void setCond_CliConvenio(  String Value )
   {
      if ( Value == null )
      {
         AV38Cond_CliConvenio = "" ;
      }
      else
      {
         AV38Cond_CliConvenio= Value;
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


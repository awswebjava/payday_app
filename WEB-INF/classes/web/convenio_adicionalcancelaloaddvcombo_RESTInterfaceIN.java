package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "convenio_adicionalcancelaloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class convenio_adicionalcancelaloaddvcombo_RESTInterfaceIN
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


   short AV19CliPaiConve;
   @JsonProperty("CliPaiConve")
   public short getCliPaiConve( )
   {
      return AV19CliPaiConve ;
   }

   @JsonProperty("CliPaiConve")
   public void setCliPaiConve(  short Value )
   {
      AV19CliPaiConve= Value;
   }


   String AV20CliConvenio;
   @JsonProperty("CliConvenio")
   public String getCliConvenio( )
   {
      if ( GXutil.strcmp(AV20CliConvenio, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV20CliConvenio ;
      }
   }

   @JsonProperty("CliConvenio")
   public void setCliConvenio(  String Value )
   {
      if ( Value == null )
      {
         AV20CliConvenio = "" ;
      }
      else
      {
         AV20CliConvenio= Value;
      }
   }


   String AV21ConveAdicod;
   @JsonProperty("ConveAdicod")
   public String getConveAdicod( )
   {
      if ( GXutil.strcmp(AV21ConveAdicod, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV21ConveAdicod ;
      }
   }

   @JsonProperty("ConveAdicod")
   public void setConveAdicod(  String Value )
   {
      if ( Value == null )
      {
         AV21ConveAdicod = "" ;
      }
      else
      {
         AV21ConveAdicod= Value;
      }
   }


   String AV22ConveAdiSitCancela;
   @JsonProperty("ConveAdiSitCancela")
   public String getConveAdiSitCancela( )
   {
      if ( GXutil.strcmp(AV22ConveAdiSitCancela, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV22ConveAdiSitCancela ;
      }
   }

   @JsonProperty("ConveAdiSitCancela")
   public void setConveAdiSitCancela(  String Value )
   {
      if ( Value == null )
      {
         AV22ConveAdiSitCancela = "" ;
      }
      else
      {
         AV22ConveAdiSitCancela= Value;
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


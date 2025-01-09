package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "clientecct_fondoceseloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class clientecct_fondoceseloaddvcombo_RESTInterfaceIN
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


   String AV21CliConveVig;
   @JsonProperty("CliConveVig")
   public String getCliConveVig( )
   {
      return AV21CliConveVig ;
   }

   @JsonProperty("CliConveVig")
   public void setCliConveVig(  String Value )
   {
      AV21CliConveVig= Value;
   }


   short AV22CliConveFondoSec;
   @JsonProperty("CliConveFondoSec")
   public short getCliConveFondoSec( )
   {
      return AV22CliConveFondoSec ;
   }

   @JsonProperty("CliConveFondoSec")
   public void setCliConveFondoSec(  short Value )
   {
      AV22CliConveFondoSec= Value;
   }


   int AV29Cond_CliCod;
   @JsonProperty("Cond_CliCod")
   public int getCond_CliCod( )
   {
      return AV29Cond_CliCod ;
   }

   @JsonProperty("Cond_CliCod")
   public void setCond_CliCod(  int Value )
   {
      AV29Cond_CliCod= Value;
   }


   short AV30Cond_CliPaiConve;
   @JsonProperty("Cond_CliPaiConve")
   public short getCond_CliPaiConve( )
   {
      return AV30Cond_CliPaiConve ;
   }

   @JsonProperty("Cond_CliPaiConve")
   public void setCond_CliPaiConve(  short Value )
   {
      AV30Cond_CliPaiConve= Value;
   }


   String AV31Cond_CliConvenio;
   @JsonProperty("Cond_CliConvenio")
   public String getCond_CliConvenio( )
   {
      if ( GXutil.strcmp(AV31Cond_CliConvenio, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV31Cond_CliConvenio ;
      }
   }

   @JsonProperty("Cond_CliConvenio")
   public void setCond_CliConvenio(  String Value )
   {
      if ( Value == null )
      {
         AV31Cond_CliConvenio = "" ;
      }
      else
      {
         AV31Cond_CliConvenio= Value;
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


package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "legajoloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class legajoloaddvcombo_RESTInterfaceIN
{
   String AV13ComboName;
   @JsonProperty("ComboName")
   public String getComboName( )
   {
      if ( GXutil.strcmp(AV13ComboName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV13ComboName ;
      }
   }

   @JsonProperty("ComboName")
   public void setComboName(  String Value )
   {
      if ( Value == null )
      {
         AV13ComboName = "" ;
      }
      else
      {
         AV13ComboName= Value;
      }
   }


   String AV15TrnMode;
   @JsonProperty("TrnMode")
   public String getTrnMode( )
   {
      if ( GXutil.strcmp(AV15TrnMode, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV15TrnMode ;
      }
   }

   @JsonProperty("TrnMode")
   public void setTrnMode(  String Value )
   {
      if ( Value == null )
      {
         AV15TrnMode = "" ;
      }
      else
      {
         AV15TrnMode= Value;
      }
   }


   boolean AV24IsDynamicCall;
   @JsonProperty("IsDynamicCall")
   public boolean getIsDynamicCall( )
   {
      return AV24IsDynamicCall ;
   }

   @JsonProperty("IsDynamicCall")
   public void setIsDynamicCall(  boolean Value )
   {
      AV24IsDynamicCall= Value;
   }


   int AV17CliCod;
   @JsonProperty("CliCod")
   public int getCliCod( )
   {
      return AV17CliCod ;
   }

   @JsonProperty("CliCod")
   public void setCliCod(  int Value )
   {
      AV17CliCod= Value;
   }


   short AV18EmpCod;
   @JsonProperty("EmpCod")
   public short getEmpCod( )
   {
      return AV18EmpCod ;
   }

   @JsonProperty("EmpCod")
   public void setEmpCod(  short Value )
   {
      AV18EmpCod= Value;
   }


   String AV19LegNumero;
   @JsonProperty("LegNumero")
   public String getLegNumero( )
   {
      return AV19LegNumero ;
   }

   @JsonProperty("LegNumero")
   public void setLegNumero(  String Value )
   {
      AV19LegNumero= Value;
   }


   int AV45Cond_CliCod;
   @JsonProperty("Cond_CliCod")
   public int getCond_CliCod( )
   {
      return AV45Cond_CliCod ;
   }

   @JsonProperty("Cond_CliCod")
   public void setCond_CliCod(  int Value )
   {
      AV45Cond_CliCod= Value;
   }


   String AV21SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV21SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV21SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV21SearchTxt = "" ;
      }
      else
      {
         AV21SearchTxt= Value;
      }
   }


}


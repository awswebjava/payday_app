package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "deduccionessolapaloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class deduccionessolapaloaddvcombo_RESTInterfaceIN
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


   int AV24CliCod;
   @JsonProperty("CliCod")
   public int getCliCod( )
   {
      return AV24CliCod ;
   }

   @JsonProperty("CliCod")
   public void setCliCod(  int Value )
   {
      AV24CliCod= Value;
   }


   short AV25EmpCod;
   @JsonProperty("EmpCod")
   public short getEmpCod( )
   {
      return AV25EmpCod ;
   }

   @JsonProperty("EmpCod")
   public void setEmpCod(  short Value )
   {
      AV25EmpCod= Value;
   }


   String AV26LegNumero;
   @JsonProperty("LegNumero")
   public String getLegNumero( )
   {
      return AV26LegNumero ;
   }

   @JsonProperty("LegNumero")
   public void setLegNumero(  String Value )
   {
      AV26LegNumero= Value;
   }


   String AV27LegDedSec;
   @JsonProperty("LegDedSec")
   public String getLegDedSec( )
   {
      return AV27LegDedSec ;
   }

   @JsonProperty("LegDedSec")
   public void setLegDedSec(  String Value )
   {
      AV27LegDedSec= Value;
   }


}

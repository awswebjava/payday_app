package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "liquidacionajusteloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class liquidacionajusteloaddvcombo_RESTInterfaceIN
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


   short AV19EmpCod;
   @JsonProperty("EmpCod")
   public short getEmpCod( )
   {
      return AV19EmpCod ;
   }

   @JsonProperty("EmpCod")
   public void setEmpCod(  short Value )
   {
      AV19EmpCod= Value;
   }


   String AV20LiqNro;
   @JsonProperty("LiqNro")
   public String getLiqNro( )
   {
      return AV20LiqNro ;
   }

   @JsonProperty("LiqNro")
   public void setLiqNro(  String Value )
   {
      AV20LiqNro= Value;
   }


   String AV21LegNumero;
   @JsonProperty("LegNumero")
   public String getLegNumero( )
   {
      return AV21LegNumero ;
   }

   @JsonProperty("LegNumero")
   public void setLegNumero(  String Value )
   {
      AV21LegNumero= Value;
   }


   short AV22LiqAjuNro;
   @JsonProperty("LiqAjuNro")
   public short getLiqAjuNro( )
   {
      return AV22LiqAjuNro ;
   }

   @JsonProperty("LiqAjuNro")
   public void setLiqAjuNro(  short Value )
   {
      AV22LiqAjuNro= Value;
   }


}


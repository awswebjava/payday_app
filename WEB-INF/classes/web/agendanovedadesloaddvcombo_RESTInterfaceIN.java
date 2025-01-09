package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "agendanovedadesloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class agendanovedadesloaddvcombo_RESTInterfaceIN
{
   String AV16ComboName;
   @JsonProperty("ComboName")
   public String getComboName( )
   {
      if ( GXutil.strcmp(AV16ComboName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV16ComboName ;
      }
   }

   @JsonProperty("ComboName")
   public void setComboName(  String Value )
   {
      if ( Value == null )
      {
         AV16ComboName = "" ;
      }
      else
      {
         AV16ComboName= Value;
      }
   }


   String AV18TrnMode;
   @JsonProperty("TrnMode")
   public String getTrnMode( )
   {
      if ( GXutil.strcmp(AV18TrnMode, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV18TrnMode ;
      }
   }

   @JsonProperty("TrnMode")
   public void setTrnMode(  String Value )
   {
      if ( Value == null )
      {
         AV18TrnMode = "" ;
      }
      else
      {
         AV18TrnMode= Value;
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


   short AV27AgeOrden;
   @JsonProperty("AgeOrden")
   public short getAgeOrden( )
   {
      return AV27AgeOrden ;
   }

   @JsonProperty("AgeOrden")
   public void setAgeOrden(  short Value )
   {
      AV27AgeOrden= Value;
   }


}


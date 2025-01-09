package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "liqimportarauxtrnloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class liqimportarauxtrnloaddvcombo_RESTInterfaceIN
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


   int AV30CliCod;
   @JsonProperty("CliCod")
   public int getCliCod( )
   {
      return AV30CliCod ;
   }

   @JsonProperty("CliCod")
   public void setCliCod(  int Value )
   {
      AV30CliCod= Value;
   }


   short AV31EmpCod;
   @JsonProperty("EmpCod")
   public short getEmpCod( )
   {
      return AV31EmpCod ;
   }

   @JsonProperty("EmpCod")
   public void setEmpCod(  short Value )
   {
      AV31EmpCod= Value;
   }


   short AV32Cond_PaiCod;
   @JsonProperty("Cond_PaiCod")
   public short getCond_PaiCod( )
   {
      return AV32Cond_PaiCod ;
   }

   @JsonProperty("Cond_PaiCod")
   public void setCond_PaiCod(  short Value )
   {
      AV32Cond_PaiCod= Value;
   }


   short AV33Cond_ProvCod;
   @JsonProperty("Cond_ProvCod")
   public short getCond_ProvCod( )
   {
      return AV33Cond_ProvCod ;
   }

   @JsonProperty("Cond_ProvCod")
   public void setCond_ProvCod(  short Value )
   {
      AV33Cond_ProvCod= Value;
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


package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "empresaloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class empresaloaddvcombo_RESTInterfaceIN
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


   int AV28CliCod;
   @JsonProperty("CliCod")
   public int getCliCod( )
   {
      return AV28CliCod ;
   }

   @JsonProperty("CliCod")
   public void setCliCod(  int Value )
   {
      AV28CliCod= Value;
   }


   short AV29EmpCod;
   @JsonProperty("EmpCod")
   public short getEmpCod( )
   {
      return AV29EmpCod ;
   }

   @JsonProperty("EmpCod")
   public void setEmpCod(  short Value )
   {
      AV29EmpCod= Value;
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


   short AV40Cond_EmpCod;
   @JsonProperty("Cond_EmpCod")
   public short getCond_EmpCod( )
   {
      return AV40Cond_EmpCod ;
   }

   @JsonProperty("Cond_EmpCod")
   public void setCond_EmpCod(  short Value )
   {
      AV40Cond_EmpCod= Value;
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


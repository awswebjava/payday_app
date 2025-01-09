package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "f1357cabf1357legdedgenwcgetfilterdata_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class f1357cabf1357legdedgenwcgetfilterdata_RESTInterfaceOUT
{
   String AV23OptionsJson;
   @JsonProperty("OptionsJson")
   public String getOptionsJson( )
   {
      return AV23OptionsJson ;
   }

   @JsonProperty("OptionsJson")
   public void setOptionsJson(  String Value )
   {
      AV23OptionsJson= Value;
   }


   String AV26OptionsDescJson;
   @JsonProperty("OptionsDescJson")
   public String getOptionsDescJson( )
   {
      return AV26OptionsDescJson ;
   }

   @JsonProperty("OptionsDescJson")
   public void setOptionsDescJson(  String Value )
   {
      AV26OptionsDescJson= Value;
   }


   String AV28OptionIndexesJson;
   @JsonProperty("OptionIndexesJson")
   public String getOptionIndexesJson( )
   {
      return AV28OptionIndexesJson ;
   }

   @JsonProperty("OptionIndexesJson")
   public void setOptionIndexesJson(  String Value )
   {
      AV28OptionIndexesJson= Value;
   }


}


package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "localidadwwgetfilterdata_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class localidadwwgetfilterdata_RESTInterfaceOUT
{
   String AV31OptionsJson;
   @JsonProperty("OptionsJson")
   public String getOptionsJson( )
   {
      return AV31OptionsJson ;
   }

   @JsonProperty("OptionsJson")
   public void setOptionsJson(  String Value )
   {
      AV31OptionsJson= Value;
   }


   String AV34OptionsDescJson;
   @JsonProperty("OptionsDescJson")
   public String getOptionsDescJson( )
   {
      return AV34OptionsDescJson ;
   }

   @JsonProperty("OptionsDescJson")
   public void setOptionsDescJson(  String Value )
   {
      AV34OptionsDescJson= Value;
   }


   String AV36OptionIndexesJson;
   @JsonProperty("OptionIndexesJson")
   public String getOptionIndexesJson( )
   {
      return AV36OptionIndexesJson ;
   }

   @JsonProperty("OptionIndexesJson")
   public void setOptionIndexesJson(  String Value )
   {
      AV36OptionIndexesJson= Value;
   }


}


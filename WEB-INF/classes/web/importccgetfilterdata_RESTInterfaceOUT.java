package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "importccgetfilterdata_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class importccgetfilterdata_RESTInterfaceOUT
{
   String AV41OptionsJson;
   @JsonProperty("OptionsJson")
   public String getOptionsJson( )
   {
      return AV41OptionsJson ;
   }

   @JsonProperty("OptionsJson")
   public void setOptionsJson(  String Value )
   {
      AV41OptionsJson= Value;
   }


   String AV44OptionsDescJson;
   @JsonProperty("OptionsDescJson")
   public String getOptionsDescJson( )
   {
      return AV44OptionsDescJson ;
   }

   @JsonProperty("OptionsDescJson")
   public void setOptionsDescJson(  String Value )
   {
      AV44OptionsDescJson= Value;
   }


   String AV46OptionIndexesJson;
   @JsonProperty("OptionIndexesJson")
   public String getOptionIndexesJson( )
   {
      return AV46OptionIndexesJson ;
   }

   @JsonProperty("OptionIndexesJson")
   public void setOptionIndexesJson(  String Value )
   {
      AV46OptionIndexesJson= Value;
   }


}


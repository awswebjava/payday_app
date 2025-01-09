package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "soap_locationwwgetfilterdata_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class soap_locationwwgetfilterdata_RESTInterfaceOUT
{
   String AV47OptionsJson;
   @JsonProperty("OptionsJson")
   public String getOptionsJson( )
   {
      return AV47OptionsJson ;
   }

   @JsonProperty("OptionsJson")
   public void setOptionsJson(  String Value )
   {
      AV47OptionsJson= Value;
   }


   String AV48OptionsDescJson;
   @JsonProperty("OptionsDescJson")
   public String getOptionsDescJson( )
   {
      return AV48OptionsDescJson ;
   }

   @JsonProperty("OptionsDescJson")
   public void setOptionsDescJson(  String Value )
   {
      AV48OptionsDescJson= Value;
   }


   String AV49OptionIndexesJson;
   @JsonProperty("OptionIndexesJson")
   public String getOptionIndexesJson( )
   {
      return AV49OptionIndexesJson ;
   }

   @JsonProperty("OptionIndexesJson")
   public void setOptionIndexesJson(  String Value )
   {
      AV49OptionIndexesJson= Value;
   }


}


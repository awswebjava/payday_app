package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "paistipotrabajowwgetfilterdata_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class paistipotrabajowwgetfilterdata_RESTInterfaceOUT
{
   String AV48OptionsJson;
   @JsonProperty("OptionsJson")
   public String getOptionsJson( )
   {
      return AV48OptionsJson ;
   }

   @JsonProperty("OptionsJson")
   public void setOptionsJson(  String Value )
   {
      AV48OptionsJson= Value;
   }


   String AV49OptionsDescJson;
   @JsonProperty("OptionsDescJson")
   public String getOptionsDescJson( )
   {
      return AV49OptionsDescJson ;
   }

   @JsonProperty("OptionsDescJson")
   public void setOptionsDescJson(  String Value )
   {
      AV49OptionsDescJson= Value;
   }


   String AV50OptionIndexesJson;
   @JsonProperty("OptionIndexesJson")
   public String getOptionIndexesJson( )
   {
      return AV50OptionIndexesJson ;
   }

   @JsonProperty("OptionIndexesJson")
   public void setOptionIndexesJson(  String Value )
   {
      AV50OptionIndexesJson= Value;
   }


}


package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "convenio_adicional_importesloaddvcombo_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class convenio_adicional_importesloaddvcombo_RESTInterfaceOUT
{
   String AV22SelectedValue;
   @JsonProperty("SelectedValue")
   public String getSelectedValue( )
   {
      return AV22SelectedValue ;
   }

   @JsonProperty("SelectedValue")
   public void setSelectedValue(  String Value )
   {
      AV22SelectedValue= Value;
   }


   String AV23SelectedText;
   @JsonProperty("SelectedText")
   public String getSelectedText( )
   {
      return AV23SelectedText ;
   }

   @JsonProperty("SelectedText")
   public void setSelectedText(  String Value )
   {
      AV23SelectedText= Value;
   }


   String AV24Combo_DataJson;
   @JsonProperty("Combo_DataJson")
   public String getCombo_DataJson( )
   {
      return AV24Combo_DataJson ;
   }

   @JsonProperty("Combo_DataJson")
   public void setCombo_DataJson(  String Value )
   {
      AV24Combo_DataJson= Value;
   }


}


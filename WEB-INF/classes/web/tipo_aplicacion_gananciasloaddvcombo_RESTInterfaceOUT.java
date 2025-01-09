package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "tipo_aplicacion_gananciasloaddvcombo_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class tipo_aplicacion_gananciasloaddvcombo_RESTInterfaceOUT
{
   String AV20SelectedValue;
   @JsonProperty("SelectedValue")
   public String getSelectedValue( )
   {
      return AV20SelectedValue ;
   }

   @JsonProperty("SelectedValue")
   public void setSelectedValue(  String Value )
   {
      AV20SelectedValue= Value;
   }


   String AV21SelectedText;
   @JsonProperty("SelectedText")
   public String getSelectedText( )
   {
      return AV21SelectedText ;
   }

   @JsonProperty("SelectedText")
   public void setSelectedText(  String Value )
   {
      AV21SelectedText= Value;
   }


   String AV22Combo_DataJson;
   @JsonProperty("Combo_DataJson")
   public String getCombo_DataJson( )
   {
      return AV22Combo_DataJson ;
   }

   @JsonProperty("Combo_DataJson")
   public void setCombo_DataJson(  String Value )
   {
      AV22Combo_DataJson= Value;
   }


}


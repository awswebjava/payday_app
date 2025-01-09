package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "conceptomotivosegresoloaddvcombo_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class conceptomotivosegresoloaddvcombo_RESTInterfaceOUT
{
   String AV24SelectedValue;
   @JsonProperty("SelectedValue")
   public String getSelectedValue( )
   {
      return AV24SelectedValue ;
   }

   @JsonProperty("SelectedValue")
   public void setSelectedValue(  String Value )
   {
      AV24SelectedValue= Value;
   }


   String AV25SelectedText;
   @JsonProperty("SelectedText")
   public String getSelectedText( )
   {
      return AV25SelectedText ;
   }

   @JsonProperty("SelectedText")
   public void setSelectedText(  String Value )
   {
      AV25SelectedText= Value;
   }


   String AV26Combo_DataJson;
   @JsonProperty("Combo_DataJson")
   public String getCombo_DataJson( )
   {
      return AV26Combo_DataJson ;
   }

   @JsonProperty("Combo_DataJson")
   public void setCombo_DataJson(  String Value )
   {
      AV26Combo_DataJson= Value;
   }


}


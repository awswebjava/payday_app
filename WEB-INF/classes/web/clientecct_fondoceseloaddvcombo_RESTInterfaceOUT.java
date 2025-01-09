package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "clientecct_fondoceseloaddvcombo_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class clientecct_fondoceseloaddvcombo_RESTInterfaceOUT
{
   String AV23SelectedValue;
   @JsonProperty("SelectedValue")
   public String getSelectedValue( )
   {
      return AV23SelectedValue ;
   }

   @JsonProperty("SelectedValue")
   public void setSelectedValue(  String Value )
   {
      AV23SelectedValue= Value;
   }


   String AV24SelectedText;
   @JsonProperty("SelectedText")
   public String getSelectedText( )
   {
      return AV24SelectedText ;
   }

   @JsonProperty("SelectedText")
   public void setSelectedText(  String Value )
   {
      AV24SelectedText= Value;
   }


   String AV25Combo_DataJson;
   @JsonProperty("Combo_DataJson")
   public String getCombo_DataJson( )
   {
      return AV25Combo_DataJson ;
   }

   @JsonProperty("Combo_DataJson")
   public void setCombo_DataJson(  String Value )
   {
      AV25Combo_DataJson= Value;
   }


}


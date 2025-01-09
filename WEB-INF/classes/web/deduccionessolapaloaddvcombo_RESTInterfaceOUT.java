package web ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "deduccionessolapaloaddvcombo_RESTInterfaceOUT", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class deduccionessolapaloaddvcombo_RESTInterfaceOUT
{
   String AV16SelectedValue;
   @JsonProperty("SelectedValue")
   public String getSelectedValue( )
   {
      return AV16SelectedValue ;
   }

   @JsonProperty("SelectedValue")
   public void setSelectedValue(  String Value )
   {
      AV16SelectedValue= Value;
   }


   Vector<web.wwpbaseobjects.SdtDVB_SDTComboData_Item_RESTInterface> AV14Combo_Data ;
   @JsonProperty("Combo_Data")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public Vector<web.wwpbaseobjects.SdtDVB_SDTComboData_Item_RESTInterface> getCombo_Data( )
   {
      return AV14Combo_Data ;
   }

   @JsonProperty("Combo_Data")
   public void setCombo_Data(  Vector<web.wwpbaseobjects.SdtDVB_SDTComboData_Item_RESTInterface> Value )
   {
      AV14Combo_Data= Value;
   }


}


package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlType(name = "DVB_SDTComboData.Item", namespace ="")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtDVB_SDTComboData_Item_RESTInterface extends GxGenericCollectionItem<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>
{
   public SdtDVB_SDTComboData_Item_RESTInterface( )
   {
      super(new web.wwpbaseobjects.SdtDVB_SDTComboData_Item ());
   }

   public SdtDVB_SDTComboData_Item_RESTInterface( web.wwpbaseobjects.SdtDVB_SDTComboData_Item psdt )
   {
      super(psdt);
   }

   @JsonProperty("ID")
   public String getgxTv_SdtDVB_SDTComboData_Item_Id( )
   {
      return GXutil.rtrim(((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)getSdt()).getgxTv_SdtDVB_SDTComboData_Item_Id()) ;
   }

   @JsonProperty("ID")
   public void setgxTv_SdtDVB_SDTComboData_Item_Id(  String Value )
   {
      ((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)getSdt()).setgxTv_SdtDVB_SDTComboData_Item_Id(Value);
   }


   @JsonProperty("T")
   public String getgxTv_SdtDVB_SDTComboData_Item_Title( )
   {
      return GXutil.rtrim(((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)getSdt()).getgxTv_SdtDVB_SDTComboData_Item_Title()) ;
   }

   @JsonProperty("T")
   public void setgxTv_SdtDVB_SDTComboData_Item_Title(  String Value )
   {
      ((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)getSdt()).setgxTv_SdtDVB_SDTComboData_Item_Title(Value);
   }


   @JsonProperty("C")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public Vector<web.wwpbaseobjects.SdtDVB_SDTComboData_Item_RESTInterface> getgxTv_SdtDVB_SDTComboData_Item_Children( )
   {
      return SdtDVB_SDTComboData_Item_RESTInterfacefromGXObjectCollection(((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)getSdt()).getgxTv_SdtDVB_SDTComboData_Item_Children()) ;
   }

   @JsonProperty("C")
   public void setgxTv_SdtDVB_SDTComboData_Item_Children(  Vector<web.wwpbaseobjects.SdtDVB_SDTComboData_Item_RESTInterface> Value )
   {
      ((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)getSdt()).setgxTv_SdtDVB_SDTComboData_Item_Children(SdtDVB_SDTComboData_Item_RESTInterfacetoGXObjectCollection(Value));
   }


   int remoteHandle = -1;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> SdtDVB_SDTComboData_Item_RESTInterfacetoGXObjectCollection( Vector<web.wwpbaseobjects.SdtDVB_SDTComboData_Item_RESTInterface> collection )
   {
      GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> result = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "DVB_SDTComboData.Item", ".DVB_SDTComboData", remoteHandle);
      for (int i = 0; i < collection.size(); i++)
      {
         result.add((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)collection.elementAt(i).getSdt());
      }
      return result ;
   }

   private Vector<web.wwpbaseobjects.SdtDVB_SDTComboData_Item_RESTInterface> SdtDVB_SDTComboData_Item_RESTInterfacefromGXObjectCollection( GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> collection )
   {
      Vector<web.wwpbaseobjects.SdtDVB_SDTComboData_Item_RESTInterface> result = new Vector<web.wwpbaseobjects.SdtDVB_SDTComboData_Item_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new web.wwpbaseobjects.SdtDVB_SDTComboData_Item_RESTInterface((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)collection.elementAt(i)));
      }
      return result ;
   }

}


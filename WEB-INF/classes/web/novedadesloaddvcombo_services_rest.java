package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/NovedadesLoadDVCombo")
public final  class novedadesloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.novedadesloaddvcombo_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV17ComboName;
      AV17ComboName = entity.getComboName() ;
      String AV19TrnMode;
      AV19TrnMode = entity.getTrnMode() ;
      int AV24CliCod;
      AV24CliCod = entity.getCliCod() ;
      short AV25EmpCod;
      AV25EmpCod = entity.getEmpCod() ;
      int AV26LegNumero;
      AV26LegNumero = (int)(GXutil.lval( entity.getLegNumero())) ;
      short AV27AgeOrden;
      AV27AgeOrden = entity.getAgeOrden() ;
      String [] AV16SelectedValue = new String[] { "" };
      @SuppressWarnings("unchecked")
      GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> [] AV14Combo_Data = new GXBaseCollection[] { new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>() };
      if ( ! processHeaders("novedadesloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.novedadesloaddvcombo worker = new web.novedadesloaddvcombo(remoteHandle, context);
         worker.execute(AV17ComboName,AV19TrnMode,AV24CliCod,AV25EmpCod,AV26LegNumero,AV27AgeOrden,AV16SelectedValue,AV14Combo_Data );
         web.novedadesloaddvcombo_RESTInterfaceOUT data = new web.novedadesloaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV16SelectedValue[0]);
         data.setCombo_Data(SdtDVB_SDTComboData_Item_RESTInterfacefromGXObjectCollection(AV14Combo_Data[0]));
         builder = Response.okWrapped(data);
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      catch ( Exception e )
      {
         cleanup();
         throw e;
      }
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

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

}


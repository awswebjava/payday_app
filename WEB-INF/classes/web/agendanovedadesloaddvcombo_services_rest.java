package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/AgendaNovedadesLoadDVCombo")
public final  class agendanovedadesloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.agendanovedadesloaddvcombo_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV16ComboName;
      AV16ComboName = entity.getComboName() ;
      String AV18TrnMode;
      AV18TrnMode = entity.getTrnMode() ;
      int AV24CliCod;
      AV24CliCod = entity.getCliCod() ;
      short AV25EmpCod;
      AV25EmpCod = entity.getEmpCod() ;
      int AV26LegNumero;
      AV26LegNumero = (int)(GXutil.lval( entity.getLegNumero())) ;
      short AV27AgeOrden;
      AV27AgeOrden = entity.getAgeOrden() ;
      String [] AV15SelectedValue = new String[] { "" };
      @SuppressWarnings("unchecked")
      GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> [] AV13Combo_Data = new GXBaseCollection[] { new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>() };
      if ( ! processHeaders("agendanovedadesloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.agendanovedadesloaddvcombo worker = new web.agendanovedadesloaddvcombo(remoteHandle, context);
         worker.execute(AV16ComboName,AV18TrnMode,AV24CliCod,AV25EmpCod,AV26LegNumero,AV27AgeOrden,AV15SelectedValue,AV13Combo_Data );
         web.agendanovedadesloaddvcombo_RESTInterfaceOUT data = new web.agendanovedadesloaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV15SelectedValue[0]);
         data.setCombo_Data(SdtDVB_SDTComboData_Item_RESTInterfacefromGXObjectCollection(AV13Combo_Data[0]));
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


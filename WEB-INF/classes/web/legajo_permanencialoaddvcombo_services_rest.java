package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/legajo_permanenciaLoadDVCombo")
public final  class legajo_permanencialoaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.legajo_permanencialoaddvcombo_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV15ComboName;
      AV15ComboName = entity.getComboName() ;
      String AV16TrnMode;
      AV16TrnMode = entity.getTrnMode() ;
      int AV18CliCod;
      AV18CliCod = entity.getCliCod() ;
      short AV19EmpCod;
      AV19EmpCod = entity.getEmpCod() ;
      int AV20LegNumero;
      AV20LegNumero = (int)(GXutil.lval( entity.getLegNumero())) ;
      java.util.Date AV21LegHisFecIng;
      AV21LegHisFecIng = GXutil.charToDateREST( entity.getLegHisFecIng()) ;
      String [] AV22SelectedValue = new String[] { "" };
      @SuppressWarnings("unchecked")
      GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> [] AV13Combo_Data = new GXBaseCollection[] { new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>() };
      if ( ! processHeaders("legajo_permanencialoaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.legajo_permanencialoaddvcombo worker = new web.legajo_permanencialoaddvcombo(remoteHandle, context);
         worker.execute(AV15ComboName,AV16TrnMode,AV18CliCod,AV19EmpCod,AV20LegNumero,AV21LegHisFecIng,AV22SelectedValue,AV13Combo_Data );
         web.legajo_permanencialoaddvcombo_RESTInterfaceOUT data = new web.legajo_permanencialoaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV22SelectedValue[0]);
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


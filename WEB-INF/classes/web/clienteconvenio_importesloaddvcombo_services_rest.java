package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/clienteConvenio_importesLoadDVCombo")
public final  class clienteconvenio_importesloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.clienteconvenio_importesloaddvcombo_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV15ComboName;
      AV15ComboName = entity.getComboName() ;
      String AV16TrnMode;
      AV16TrnMode = entity.getTrnMode() ;
      boolean AV17IsDynamicCall;
      AV17IsDynamicCall = entity.getIsDynamicCall() ;
      int AV18CliCod;
      AV18CliCod = entity.getCliCod() ;
      short AV19CliPaiConve;
      AV19CliPaiConve = entity.getCliPaiConve() ;
      String AV20CliConvenio;
      AV20CliConvenio = entity.getCliConvenio() ;
      java.util.Date AV21CliConveImpVig;
      AV21CliConveImpVig = GXutil.charToDateREST( entity.getCliConveImpVig()) ;
      String AV22CliConveImpTipo;
      AV22CliConveImpTipo = entity.getCliConveImpTipo() ;
      int AV29Cond_CliCod;
      AV29Cond_CliCod = entity.getCond_CliCod() ;
      short AV30Cond_CliPaiConve;
      AV30Cond_CliPaiConve = entity.getCond_CliPaiConve() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV23SelectedValue = new String[] { "" };
      String [] AV24SelectedText = new String[] { "" };
      String [] AV25Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("clienteconvenio_importesloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.clienteconvenio_importesloaddvcombo worker = new web.clienteconvenio_importesloaddvcombo(remoteHandle, context);
         worker.execute(AV15ComboName,AV16TrnMode,AV17IsDynamicCall,AV18CliCod,AV19CliPaiConve,AV20CliConvenio,AV21CliConveImpVig,AV22CliConveImpTipo,AV29Cond_CliCod,AV30Cond_CliPaiConve,AV12SearchTxt,AV23SelectedValue,AV24SelectedText,AV25Combo_DataJson );
         web.clienteconvenio_importesloaddvcombo_RESTInterfaceOUT data = new web.clienteconvenio_importesloaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV23SelectedValue[0]);
         data.setSelectedText(AV24SelectedText[0]);
         data.setCombo_DataJson(AV25Combo_DataJson[0]);
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

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

}


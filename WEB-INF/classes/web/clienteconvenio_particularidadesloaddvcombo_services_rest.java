package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/ClienteConvenio_ParticularidadesLoadDVCombo")
public final  class clienteconvenio_particularidadesloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.clienteconvenio_particularidadesloaddvcombo_RESTInterfaceIN entity ) throws Exception
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
      java.util.Date AV21CliConveVig;
      AV21CliConveVig = GXutil.charToDateREST( entity.getCliConveVig()) ;
      int AV28Cond_CliCod;
      AV28Cond_CliCod = entity.getCond_CliCod() ;
      short AV29Cond_CliPaiConve;
      AV29Cond_CliPaiConve = entity.getCond_CliPaiConve() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV22SelectedValue = new String[] { "" };
      String [] AV23SelectedText = new String[] { "" };
      String [] AV24Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("clienteconvenio_particularidadesloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.clienteconvenio_particularidadesloaddvcombo worker = new web.clienteconvenio_particularidadesloaddvcombo(remoteHandle, context);
         worker.execute(AV15ComboName,AV16TrnMode,AV17IsDynamicCall,AV18CliCod,AV19CliPaiConve,AV20CliConvenio,AV21CliConveVig,AV28Cond_CliCod,AV29Cond_CliPaiConve,AV12SearchTxt,AV22SelectedValue,AV23SelectedText,AV24Combo_DataJson );
         web.clienteconvenio_particularidadesloaddvcombo_RESTInterfaceOUT data = new web.clienteconvenio_particularidadesloaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV22SelectedValue[0]);
         data.setSelectedText(AV23SelectedText[0]);
         data.setCombo_DataJson(AV24Combo_DataJson[0]);
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


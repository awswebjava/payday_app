package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/Convenio_Adicional_ImportesLoadDVCombo")
public final  class convenio_adicional_importesloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.convenio_adicional_importesloaddvcombo_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV15ComboName;
      AV15ComboName = entity.getComboName() ;
      String AV16TrnMode;
      AV16TrnMode = entity.getTrnMode() ;
      boolean AV17IsDynamicCall;
      AV17IsDynamicCall = entity.getIsDynamicCall() ;
      int AV32CliCod;
      AV32CliCod = entity.getCliCod() ;
      short AV34CliPaiConve;
      AV34CliPaiConve = entity.getCliPaiConve() ;
      String AV35CliConvenio;
      AV35CliConvenio = entity.getCliConvenio() ;
      String AV20ConveAdicod;
      AV20ConveAdicod = entity.getConveAdicod() ;
      java.util.Date AV21ConveAdiVig;
      AV21ConveAdiVig = GXutil.charToDateREST( entity.getConveAdiVig()) ;
      int AV36Cond_CliCod;
      AV36Cond_CliCod = entity.getCond_CliCod() ;
      short AV37Cond_CliPaiConve;
      AV37Cond_CliPaiConve = entity.getCond_CliPaiConve() ;
      String AV38Cond_CliConvenio;
      AV38Cond_CliConvenio = entity.getCond_CliConvenio() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV22SelectedValue = new String[] { "" };
      String [] AV23SelectedText = new String[] { "" };
      String [] AV24Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("convenio_adicional_importesloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.convenio_adicional_importesloaddvcombo worker = new web.convenio_adicional_importesloaddvcombo(remoteHandle, context);
         worker.execute(AV15ComboName,AV16TrnMode,AV17IsDynamicCall,AV32CliCod,AV34CliPaiConve,AV35CliConvenio,AV20ConveAdicod,AV21ConveAdiVig,AV36Cond_CliCod,AV37Cond_CliPaiConve,AV38Cond_CliConvenio,AV12SearchTxt,AV22SelectedValue,AV23SelectedText,AV24Combo_DataJson );
         web.convenio_adicional_importesloaddvcombo_RESTInterfaceOUT data = new web.convenio_adicional_importesloaddvcombo_RESTInterfaceOUT();
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


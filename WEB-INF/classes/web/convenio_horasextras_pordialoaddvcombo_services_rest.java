package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/Convenio_horasextras_porDiaLoadDVCombo")
public final  class convenio_horasextras_pordialoaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.convenio_horasextras_pordialoaddvcombo_RESTInterfaceIN entity ) throws Exception
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
      short AV21ConveHsExSec;
      AV21ConveHsExSec = entity.getConveHsExSec() ;
      int AV32Cond_CliCod;
      AV32Cond_CliCod = entity.getCond_CliCod() ;
      short AV33Cond_CliPaiConve;
      AV33Cond_CliPaiConve = entity.getCond_CliPaiConve() ;
      String AV34Cond_CliConvenio;
      AV34Cond_CliConvenio = entity.getCond_CliConvenio() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV22SelectedValue = new String[] { "" };
      String [] AV23SelectedText = new String[] { "" };
      String [] AV24Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("convenio_horasextras_pordialoaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.convenio_horasextras_pordialoaddvcombo worker = new web.convenio_horasextras_pordialoaddvcombo(remoteHandle, context);
         worker.execute(AV15ComboName,AV16TrnMode,AV17IsDynamicCall,AV18CliCod,AV19CliPaiConve,AV20CliConvenio,AV21ConveHsExSec,AV32Cond_CliCod,AV33Cond_CliPaiConve,AV34Cond_CliConvenio,AV12SearchTxt,AV22SelectedValue,AV23SelectedText,AV24Combo_DataJson );
         web.convenio_horasextras_pordialoaddvcombo_RESTInterfaceOUT data = new web.convenio_horasextras_pordialoaddvcombo_RESTInterfaceOUT();
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


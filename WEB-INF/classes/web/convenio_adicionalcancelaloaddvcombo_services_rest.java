package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/convenio_adicionalCancelaLoadDVCombo")
public final  class convenio_adicionalcancelaloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.convenio_adicionalcancelaloaddvcombo_RESTInterfaceIN entity ) throws Exception
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
      String AV21ConveAdicod;
      AV21ConveAdicod = entity.getConveAdicod() ;
      String AV22ConveAdiSitCancela;
      AV22ConveAdiSitCancela = entity.getConveAdiSitCancela() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV23SelectedValue = new String[] { "" };
      String [] AV24SelectedText = new String[] { "" };
      String [] AV25Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("convenio_adicionalcancelaloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.convenio_adicionalcancelaloaddvcombo worker = new web.convenio_adicionalcancelaloaddvcombo(remoteHandle, context);
         worker.execute(AV15ComboName,AV16TrnMode,AV17IsDynamicCall,AV18CliCod,AV19CliPaiConve,AV20CliConvenio,AV21ConveAdicod,AV22ConveAdiSitCancela,AV12SearchTxt,AV23SelectedValue,AV24SelectedText,AV25Combo_DataJson );
         web.convenio_adicionalcancelaloaddvcombo_RESTInterfaceOUT data = new web.convenio_adicionalcancelaloaddvcombo_RESTInterfaceOUT();
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


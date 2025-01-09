package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/ConceptoMotivosEgresoLoadDVCombo")
public final  class conceptomotivosegresoloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.conceptomotivosegresoloaddvcombo_RESTInterfaceIN entity ) throws Exception
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
      String AV32ConCodigo;
      AV32ConCodigo = entity.getConCodigo() ;
      String AV20MegCodigo;
      AV20MegCodigo = entity.getMegCodigo() ;
      short AV33ConMegSec;
      AV33ConMegSec = entity.getConMegSec() ;
      int AV30Cond_CliCod;
      AV30Cond_CliCod = entity.getCond_CliCod() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV24SelectedValue = new String[] { "" };
      String [] AV25SelectedText = new String[] { "" };
      String [] AV26Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("conceptomotivosegresoloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.conceptomotivosegresoloaddvcombo worker = new web.conceptomotivosegresoloaddvcombo(remoteHandle, context);
         worker.execute(AV15ComboName,AV16TrnMode,AV17IsDynamicCall,AV18CliCod,AV32ConCodigo,AV20MegCodigo,AV33ConMegSec,AV30Cond_CliCod,AV12SearchTxt,AV24SelectedValue,AV25SelectedText,AV26Combo_DataJson );
         web.conceptomotivosegresoloaddvcombo_RESTInterfaceOUT data = new web.conceptomotivosegresoloaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV24SelectedValue[0]);
         data.setSelectedText(AV25SelectedText[0]);
         data.setCombo_DataJson(AV26Combo_DataJson[0]);
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


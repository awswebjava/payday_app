package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/PuestoLoadDVCombo")
public final  class puestoloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.puestoloaddvcombo_RESTInterfaceIN entity ) throws Exception
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
      String AV19SecCodigo;
      AV19SecCodigo = entity.getSecCodigo() ;
      String AV20PuestoCodigo;
      AV20PuestoCodigo = entity.getPuestoCodigo() ;
      int AV27Cond_CliCod;
      AV27Cond_CliCod = entity.getCond_CliCod() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV21SelectedValue = new String[] { "" };
      String [] AV22SelectedText = new String[] { "" };
      String [] AV23Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("puestoloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.puestoloaddvcombo worker = new web.puestoloaddvcombo(remoteHandle, context);
         worker.execute(AV15ComboName,AV16TrnMode,AV17IsDynamicCall,AV18CliCod,AV19SecCodigo,AV20PuestoCodigo,AV27Cond_CliCod,AV12SearchTxt,AV21SelectedValue,AV22SelectedText,AV23Combo_DataJson );
         web.puestoloaddvcombo_RESTInterfaceOUT data = new web.puestoloaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV21SelectedValue[0]);
         data.setSelectedText(AV22SelectedText[0]);
         data.setCombo_DataJson(AV23Combo_DataJson[0]);
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


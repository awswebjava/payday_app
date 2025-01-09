package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/ConceptoLoadDVCombo")
public final  class conceptoloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.conceptoloaddvcombo_RESTInterfaceIN entity ) throws Exception
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
      String AV19ConCodigo;
      AV19ConCodigo = entity.getConCodigo() ;
      int AV29Cond_CliCod;
      AV29Cond_CliCod = entity.getCond_CliCod() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV20SelectedValue = new String[] { "" };
      String [] AV21SelectedText = new String[] { "" };
      String [] AV22Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("conceptoloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.conceptoloaddvcombo worker = new web.conceptoloaddvcombo(remoteHandle, context);
         worker.execute(AV15ComboName,AV16TrnMode,AV17IsDynamicCall,AV18CliCod,AV19ConCodigo,AV29Cond_CliCod,AV12SearchTxt,AV20SelectedValue,AV21SelectedText,AV22Combo_DataJson );
         web.conceptoloaddvcombo_RESTInterfaceOUT data = new web.conceptoloaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV20SelectedValue[0]);
         data.setSelectedText(AV21SelectedText[0]);
         data.setCombo_DataJson(AV22Combo_DataJson[0]);
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


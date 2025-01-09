package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/LegajoLoadDVCombo")
public final  class legajoloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.legajoloaddvcombo_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV13ComboName;
      AV13ComboName = entity.getComboName() ;
      String AV15TrnMode;
      AV15TrnMode = entity.getTrnMode() ;
      boolean AV24IsDynamicCall;
      AV24IsDynamicCall = entity.getIsDynamicCall() ;
      int AV17CliCod;
      AV17CliCod = entity.getCliCod() ;
      short AV18EmpCod;
      AV18EmpCod = entity.getEmpCod() ;
      int AV19LegNumero;
      AV19LegNumero = (int)(GXutil.lval( entity.getLegNumero())) ;
      int AV45Cond_CliCod;
      AV45Cond_CliCod = entity.getCond_CliCod() ;
      String AV21SearchTxt;
      AV21SearchTxt = entity.getSearchTxt() ;
      String [] AV12SelectedValue = new String[] { "" };
      String [] AV23SelectedText = new String[] { "" };
      String [] AV22Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("legajoloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.legajoloaddvcombo worker = new web.legajoloaddvcombo(remoteHandle, context);
         worker.execute(AV13ComboName,AV15TrnMode,AV24IsDynamicCall,AV17CliCod,AV18EmpCod,AV19LegNumero,AV45Cond_CliCod,AV21SearchTxt,AV12SelectedValue,AV23SelectedText,AV22Combo_DataJson );
         web.legajoloaddvcombo_RESTInterfaceOUT data = new web.legajoloaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV12SelectedValue[0]);
         data.setSelectedText(AV23SelectedText[0]);
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


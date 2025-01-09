package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/NovedadEventosLoadDVCombo")
public final  class novedadeventosloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.novedadeventosloaddvcombo_RESTInterfaceIN entity ) throws Exception
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
      short AV19EmpCod;
      AV19EmpCod = entity.getEmpCod() ;
      int AV20LegNumero;
      AV20LegNumero = (int)(GXutil.lval( entity.getLegNumero())) ;
      java.util.Date AV21LegLicenIni;
      AV21LegLicenIni = GXutil.charToDateREST( entity.getLegLicenIni()) ;
      int AV28Cond_CliCod;
      AV28Cond_CliCod = entity.getCond_CliCod() ;
      short AV29Cond_EmpCod;
      AV29Cond_EmpCod = entity.getCond_EmpCod() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV22SelectedValue = new String[] { "" };
      String [] AV23SelectedText = new String[] { "" };
      String [] AV24Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("novedadeventosloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.novedadeventosloaddvcombo worker = new web.novedadeventosloaddvcombo(remoteHandle, context);
         worker.execute(AV15ComboName,AV16TrnMode,AV17IsDynamicCall,AV18CliCod,AV19EmpCod,AV20LegNumero,AV21LegLicenIni,AV28Cond_CliCod,AV29Cond_EmpCod,AV12SearchTxt,AV22SelectedValue,AV23SelectedText,AV24Combo_DataJson );
         web.novedadeventosloaddvcombo_RESTInterfaceOUT data = new web.novedadeventosloaddvcombo_RESTInterfaceOUT();
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


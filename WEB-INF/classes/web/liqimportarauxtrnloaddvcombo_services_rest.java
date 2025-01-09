package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/LiqImportarAuxTrnLoadDVCombo")
public final  class liqimportarauxtrnloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.liqimportarauxtrnloaddvcombo_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV17ComboName;
      AV17ComboName = entity.getComboName() ;
      String AV19TrnMode;
      AV19TrnMode = entity.getTrnMode() ;
      boolean AV22IsDynamicCall;
      AV22IsDynamicCall = entity.getIsDynamicCall() ;
      int AV30CliCod;
      AV30CliCod = entity.getCliCod() ;
      short AV31EmpCod;
      AV31EmpCod = entity.getEmpCod() ;
      short AV32Cond_PaiCod;
      AV32Cond_PaiCod = entity.getCond_PaiCod() ;
      short AV33Cond_ProvCod;
      AV33Cond_ProvCod = entity.getCond_ProvCod() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV16SelectedValue = new String[] { "" };
      String [] AV21SelectedText = new String[] { "" };
      String [] AV13Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("liqimportarauxtrnloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.liqimportarauxtrnloaddvcombo worker = new web.liqimportarauxtrnloaddvcombo(remoteHandle, context);
         worker.execute(AV17ComboName,AV19TrnMode,AV22IsDynamicCall,AV30CliCod,AV31EmpCod,AV32Cond_PaiCod,AV33Cond_ProvCod,AV12SearchTxt,AV16SelectedValue,AV21SelectedText,AV13Combo_DataJson );
         web.liqimportarauxtrnloaddvcombo_RESTInterfaceOUT data = new web.liqimportarauxtrnloaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV16SelectedValue[0]);
         data.setSelectedText(AV21SelectedText[0]);
         data.setCombo_DataJson(AV13Combo_DataJson[0]);
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


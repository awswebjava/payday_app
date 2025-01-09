package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/LocalidadLoadDVCombo")
public final  class localidadloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.localidadloaddvcombo_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV17ComboName;
      AV17ComboName = entity.getComboName() ;
      String AV19TrnMode;
      AV19TrnMode = entity.getTrnMode() ;
      boolean AV22IsDynamicCall;
      AV22IsDynamicCall = entity.getIsDynamicCall() ;
      short AV25PaiCod;
      AV25PaiCod = entity.getPaiCod() ;
      short AV26ProvCod;
      AV26ProvCod = entity.getProvCod() ;
      short AV27LocCod;
      AV27LocCod = entity.getLocCod() ;
      short AV28Cond_PaiCod;
      AV28Cond_PaiCod = entity.getCond_PaiCod() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV16SelectedValue = new String[] { "" };
      String [] AV21SelectedText = new String[] { "" };
      String [] AV13Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("localidadloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.localidadloaddvcombo worker = new web.localidadloaddvcombo(remoteHandle, context);
         worker.execute(AV17ComboName,AV19TrnMode,AV22IsDynamicCall,AV25PaiCod,AV26ProvCod,AV27LocCod,AV28Cond_PaiCod,AV12SearchTxt,AV16SelectedValue,AV21SelectedText,AV13Combo_DataJson );
         web.localidadloaddvcombo_RESTInterfaceOUT data = new web.localidadloaddvcombo_RESTInterfaceOUT();
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


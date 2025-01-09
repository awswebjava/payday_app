package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/tipo_obligacionLoadDVCombo")
public final  class tipo_obligacionloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.tipo_obligacionloaddvcombo_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV15ComboName;
      AV15ComboName = entity.getComboName() ;
      String AV16TrnMode;
      AV16TrnMode = entity.getTrnMode() ;
      boolean AV17IsDynamicCall;
      AV17IsDynamicCall = entity.getIsDynamicCall() ;
      short AV18TipoOblSec;
      AV18TipoOblSec = entity.getTipoOblSec() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV19SelectedValue = new String[] { "" };
      String [] AV20SelectedText = new String[] { "" };
      String [] AV21Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("tipo_obligacionloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.tipo_obligacionloaddvcombo worker = new web.tipo_obligacionloaddvcombo(remoteHandle, context);
         worker.execute(AV15ComboName,AV16TrnMode,AV17IsDynamicCall,AV18TipoOblSec,AV12SearchTxt,AV19SelectedValue,AV20SelectedText,AV21Combo_DataJson );
         web.tipo_obligacionloaddvcombo_RESTInterfaceOUT data = new web.tipo_obligacionloaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV19SelectedValue[0]);
         data.setSelectedText(AV20SelectedText[0]);
         data.setCombo_DataJson(AV21Combo_DataJson[0]);
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


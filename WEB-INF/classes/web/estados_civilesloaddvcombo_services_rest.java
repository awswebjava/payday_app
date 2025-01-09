package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/Estados_civilesLoadDVCombo")
public final  class estados_civilesloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.estados_civilesloaddvcombo_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV15ComboName;
      AV15ComboName = entity.getComboName() ;
      String AV16TrnMode;
      AV16TrnMode = entity.getTrnMode() ;
      boolean AV17IsDynamicCall;
      AV17IsDynamicCall = entity.getIsDynamicCall() ;
      short AV18EstaCivilCod;
      AV18EstaCivilCod = entity.getEstaCivilCod() ;
      String AV12SearchTxt;
      AV12SearchTxt = entity.getSearchTxt() ;
      String [] AV19SelectedValue = new String[] { "" };
      String [] AV20SelectedText = new String[] { "" };
      String [] AV21Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("estados_civilesloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.estados_civilesloaddvcombo worker = new web.estados_civilesloaddvcombo(remoteHandle, context);
         worker.execute(AV15ComboName,AV16TrnMode,AV17IsDynamicCall,AV18EstaCivilCod,AV12SearchTxt,AV19SelectedValue,AV20SelectedText,AV21Combo_DataJson );
         web.estados_civilesloaddvcombo_RESTInterfaceOUT data = new web.estados_civilesloaddvcombo_RESTInterfaceOUT();
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


package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/legajo_cuenta_licenciasWWGetFilterData")
public final  class legajo_cuenta_licenciaswwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.legajo_cuenta_licenciaswwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV48DDOName;
      AV48DDOName = entity.getDDOName() ;
      String AV49SearchTxt;
      AV49SearchTxt = entity.getSearchTxt() ;
      String AV50SearchTxtTo;
      AV50SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV51OptionsJson = new String[] { "" };
      String [] AV52OptionsDescJson = new String[] { "" };
      String [] AV53OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("legajo_cuenta_licenciaswwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.legajo_cuenta_licenciaswwgetfilterdata worker = new web.legajo_cuenta_licenciaswwgetfilterdata(remoteHandle, context);
         worker.execute(AV48DDOName,AV49SearchTxt,AV50SearchTxtTo,AV51OptionsJson,AV52OptionsDescJson,AV53OptionIndexesJson );
         web.legajo_cuenta_licenciaswwgetfilterdata_RESTInterfaceOUT data = new web.legajo_cuenta_licenciaswwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV51OptionsJson[0]);
         data.setOptionsDescJson(AV52OptionsDescJson[0]);
         data.setOptionIndexesJson(AV53OptionIndexesJson[0]);
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


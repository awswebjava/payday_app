package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/PaisTipoTrabajoWWGetFilterData")
public final  class paistipotrabajowwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.paistipotrabajowwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV45DDOName;
      AV45DDOName = entity.getDDOName() ;
      String AV46SearchTxt;
      AV46SearchTxt = entity.getSearchTxt() ;
      String AV47SearchTxtTo;
      AV47SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV48OptionsJson = new String[] { "" };
      String [] AV49OptionsDescJson = new String[] { "" };
      String [] AV50OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("paistipotrabajowwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.paistipotrabajowwgetfilterdata worker = new web.paistipotrabajowwgetfilterdata(remoteHandle, context);
         worker.execute(AV45DDOName,AV46SearchTxt,AV47SearchTxtTo,AV48OptionsJson,AV49OptionsDescJson,AV50OptionIndexesJson );
         web.paistipotrabajowwgetfilterdata_RESTInterfaceOUT data = new web.paistipotrabajowwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV48OptionsJson[0]);
         data.setOptionsDescJson(AV49OptionsDescJson[0]);
         data.setOptionIndexesJson(AV50OptionIndexesJson[0]);
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


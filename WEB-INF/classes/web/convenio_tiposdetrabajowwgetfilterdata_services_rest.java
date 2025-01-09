package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/convenio_tiposdetrabajoWWGetFilterData")
public final  class convenio_tiposdetrabajowwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.convenio_tiposdetrabajowwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV44DDOName;
      AV44DDOName = entity.getDDOName() ;
      String AV45SearchTxt;
      AV45SearchTxt = entity.getSearchTxt() ;
      String AV46SearchTxtTo;
      AV46SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV47OptionsJson = new String[] { "" };
      String [] AV48OptionsDescJson = new String[] { "" };
      String [] AV49OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("convenio_tiposdetrabajowwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.convenio_tiposdetrabajowwgetfilterdata worker = new web.convenio_tiposdetrabajowwgetfilterdata(remoteHandle, context);
         worker.execute(AV44DDOName,AV45SearchTxt,AV46SearchTxtTo,AV47OptionsJson,AV48OptionsDescJson,AV49OptionIndexesJson );
         web.convenio_tiposdetrabajowwgetfilterdata_RESTInterfaceOUT data = new web.convenio_tiposdetrabajowwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV47OptionsJson[0]);
         data.setOptionsDescJson(AV48OptionsDescJson[0]);
         data.setOptionIndexesJson(AV49OptionIndexesJson[0]);
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


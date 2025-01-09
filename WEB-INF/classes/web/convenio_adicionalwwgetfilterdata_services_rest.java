package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/convenio_adicionalWWGetFilterData")
public final  class convenio_adicionalwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.convenio_adicionalwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV37DDOName;
      AV37DDOName = entity.getDDOName() ;
      String AV38SearchTxt;
      AV38SearchTxt = entity.getSearchTxt() ;
      String AV39SearchTxtTo;
      AV39SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV40OptionsJson = new String[] { "" };
      String [] AV41OptionsDescJson = new String[] { "" };
      String [] AV42OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("convenio_adicionalwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.convenio_adicionalwwgetfilterdata worker = new web.convenio_adicionalwwgetfilterdata(remoteHandle, context);
         worker.execute(AV37DDOName,AV38SearchTxt,AV39SearchTxtTo,AV40OptionsJson,AV41OptionsDescJson,AV42OptionIndexesJson );
         web.convenio_adicionalwwgetfilterdata_RESTInterfaceOUT data = new web.convenio_adicionalwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV40OptionsJson[0]);
         data.setOptionsDescJson(AV41OptionsDescJson[0]);
         data.setOptionIndexesJson(AV42OptionIndexesJson[0]);
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


package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/EmpresaWWGetFilterData")
public final  class empresawwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.empresawwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV50DDOName;
      AV50DDOName = entity.getDDOName() ;
      String AV48SearchTxt;
      AV48SearchTxt = entity.getSearchTxt() ;
      String AV49SearchTxtTo;
      AV49SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV54OptionsJson = new String[] { "" };
      String [] AV57OptionsDescJson = new String[] { "" };
      String [] AV59OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("empresawwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.empresawwgetfilterdata worker = new web.empresawwgetfilterdata(remoteHandle, context);
         worker.execute(AV50DDOName,AV48SearchTxt,AV49SearchTxtTo,AV54OptionsJson,AV57OptionsDescJson,AV59OptionIndexesJson );
         web.empresawwgetfilterdata_RESTInterfaceOUT data = new web.empresawwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV54OptionsJson[0]);
         data.setOptionsDescJson(AV57OptionsDescJson[0]);
         data.setOptionIndexesJson(AV59OptionIndexesJson[0]);
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


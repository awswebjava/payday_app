package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/rest_locationWWGetFilterData")
public final  class rest_locationwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.rest_locationwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV41DDOName;
      AV41DDOName = entity.getDDOName() ;
      String AV42SearchTxt;
      AV42SearchTxt = entity.getSearchTxt() ;
      String AV43SearchTxtTo;
      AV43SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV44OptionsJson = new String[] { "" };
      String [] AV45OptionsDescJson = new String[] { "" };
      String [] AV46OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("rest_locationwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.rest_locationwwgetfilterdata worker = new web.rest_locationwwgetfilterdata(remoteHandle, context);
         worker.execute(AV41DDOName,AV42SearchTxt,AV43SearchTxtTo,AV44OptionsJson,AV45OptionsDescJson,AV46OptionIndexesJson );
         web.rest_locationwwgetfilterdata_RESTInterfaceOUT data = new web.rest_locationwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV44OptionsJson[0]);
         data.setOptionsDescJson(AV45OptionsDescJson[0]);
         data.setOptionIndexesJson(AV46OptionIndexesJson[0]);
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


package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/legajo_permanenciaWWGetFilterData")
public final  class legajo_permanenciawwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.legajo_permanenciawwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV47DDOName;
      AV47DDOName = entity.getDDOName() ;
      String AV48SearchTxt;
      AV48SearchTxt = entity.getSearchTxt() ;
      String AV49SearchTxtTo;
      AV49SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV50OptionsJson = new String[] { "" };
      String [] AV51OptionsDescJson = new String[] { "" };
      String [] AV52OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("legajo_permanenciawwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.legajo_permanenciawwgetfilterdata worker = new web.legajo_permanenciawwgetfilterdata(remoteHandle, context);
         worker.execute(AV47DDOName,AV48SearchTxt,AV49SearchTxtTo,AV50OptionsJson,AV51OptionsDescJson,AV52OptionIndexesJson );
         web.legajo_permanenciawwgetfilterdata_RESTInterfaceOUT data = new web.legajo_permanenciawwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV50OptionsJson[0]);
         data.setOptionsDescJson(AV51OptionsDescJson[0]);
         data.setOptionIndexesJson(AV52OptionIndexesJson[0]);
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


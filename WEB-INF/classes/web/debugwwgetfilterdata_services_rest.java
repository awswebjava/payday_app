package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/DebugWWGetFilterData")
public final  class debugwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.debugwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV27DDOName;
      AV27DDOName = entity.getDDOName() ;
      String AV28SearchTxt;
      AV28SearchTxt = entity.getSearchTxt() ;
      String AV29SearchTxtTo;
      AV29SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV30OptionsJson = new String[] { "" };
      String [] AV31OptionsDescJson = new String[] { "" };
      String [] AV32OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("debugwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.debugwwgetfilterdata worker = new web.debugwwgetfilterdata(remoteHandle, context);
         worker.execute(AV27DDOName,AV28SearchTxt,AV29SearchTxtTo,AV30OptionsJson,AV31OptionsDescJson,AV32OptionIndexesJson );
         web.debugwwgetfilterdata_RESTInterfaceOUT data = new web.debugwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV30OptionsJson[0]);
         data.setOptionsDescJson(AV31OptionsDescJson[0]);
         data.setOptionIndexesJson(AV32OptionIndexesJson[0]);
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


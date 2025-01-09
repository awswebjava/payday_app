package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/TipoEmpleadorWWGetFilterData")
public final  class tipoempleadorwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.tipoempleadorwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV31DDOName;
      AV31DDOName = entity.getDDOName() ;
      String AV32SearchTxt;
      AV32SearchTxt = entity.getSearchTxt() ;
      String AV33SearchTxtTo;
      AV33SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV34OptionsJson = new String[] { "" };
      String [] AV35OptionsDescJson = new String[] { "" };
      String [] AV36OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("tipoempleadorwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.tipoempleadorwwgetfilterdata worker = new web.tipoempleadorwwgetfilterdata(remoteHandle, context);
         worker.execute(AV31DDOName,AV32SearchTxt,AV33SearchTxtTo,AV34OptionsJson,AV35OptionsDescJson,AV36OptionIndexesJson );
         web.tipoempleadorwwgetfilterdata_RESTInterfaceOUT data = new web.tipoempleadorwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV34OptionsJson[0]);
         data.setOptionsDescJson(AV35OptionsDescJson[0]);
         data.setOptionIndexesJson(AV36OptionIndexesJson[0]);
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


package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/Conceptos_exportWWGetFilterData")
public final  class conceptos_exportwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.conceptos_exportwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV79DDOName;
      AV79DDOName = entity.getDDOName() ;
      String AV80SearchTxt;
      AV80SearchTxt = entity.getSearchTxt() ;
      String AV81SearchTxtTo;
      AV81SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV82OptionsJson = new String[] { "" };
      String [] AV83OptionsDescJson = new String[] { "" };
      String [] AV84OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("conceptos_exportwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.conceptos_exportwwgetfilterdata worker = new web.conceptos_exportwwgetfilterdata(remoteHandle, context);
         worker.execute(AV79DDOName,AV80SearchTxt,AV81SearchTxtTo,AV82OptionsJson,AV83OptionsDescJson,AV84OptionIndexesJson );
         web.conceptos_exportwwgetfilterdata_RESTInterfaceOUT data = new web.conceptos_exportwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV82OptionsJson[0]);
         data.setOptionsDescJson(AV83OptionsDescJson[0]);
         data.setOptionIndexesJson(AV84OptionIndexesJson[0]);
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


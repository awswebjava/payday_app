package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/Variable_listarWWGetFilterData")
public final  class variable_listarwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.variable_listarwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV35DDOName;
      AV35DDOName = entity.getDDOName() ;
      String AV36SearchTxt;
      AV36SearchTxt = entity.getSearchTxt() ;
      String AV37SearchTxtTo;
      AV37SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV38OptionsJson = new String[] { "" };
      String [] AV39OptionsDescJson = new String[] { "" };
      String [] AV40OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("variable_listarwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.variable_listarwwgetfilterdata worker = new web.variable_listarwwgetfilterdata(remoteHandle, context);
         worker.execute(AV35DDOName,AV36SearchTxt,AV37SearchTxtTo,AV38OptionsJson,AV39OptionsDescJson,AV40OptionIndexesJson );
         web.variable_listarwwgetfilterdata_RESTInterfaceOUT data = new web.variable_listarwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV38OptionsJson[0]);
         data.setOptionsDescJson(AV39OptionsDescJson[0]);
         data.setOptionIndexesJson(AV40OptionIndexesJson[0]);
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


package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/CalculoWWGetFilterData")
public final  class calculowwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.calculowwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV33DDOName;
      AV33DDOName = entity.getDDOName() ;
      String AV31SearchTxt;
      AV31SearchTxt = entity.getSearchTxt() ;
      String AV32SearchTxtTo;
      AV32SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV37OptionsJson = new String[] { "" };
      String [] AV40OptionsDescJson = new String[] { "" };
      String [] AV42OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("calculowwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.calculowwgetfilterdata worker = new web.calculowwgetfilterdata(remoteHandle, context);
         worker.execute(AV33DDOName,AV31SearchTxt,AV32SearchTxtTo,AV37OptionsJson,AV40OptionsDescJson,AV42OptionIndexesJson );
         web.calculowwgetfilterdata_RESTInterfaceOUT data = new web.calculowwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV37OptionsJson[0]);
         data.setOptionsDescJson(AV40OptionsDescJson[0]);
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


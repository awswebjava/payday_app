package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/PeriodoWWGetFilterData")
public final  class periodowwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.periodowwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV30DDOName;
      AV30DDOName = entity.getDDOName() ;
      String AV31SearchTxt;
      AV31SearchTxt = entity.getSearchTxt() ;
      String AV32SearchTxtTo;
      AV32SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV33OptionsJson = new String[] { "" };
      String [] AV34OptionsDescJson = new String[] { "" };
      String [] AV35OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("periodowwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.periodowwgetfilterdata worker = new web.periodowwgetfilterdata(remoteHandle, context);
         worker.execute(AV30DDOName,AV31SearchTxt,AV32SearchTxtTo,AV33OptionsJson,AV34OptionsDescJson,AV35OptionIndexesJson );
         web.periodowwgetfilterdata_RESTInterfaceOUT data = new web.periodowwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV33OptionsJson[0]);
         data.setOptionsDescJson(AV34OptionsDescJson[0]);
         data.setOptionIndexesJson(AV35OptionIndexesJson[0]);
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


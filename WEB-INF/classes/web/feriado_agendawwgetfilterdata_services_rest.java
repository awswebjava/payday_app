package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/feriado_agendaWWGetFilterData")
public final  class feriado_agendawwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.feriado_agendawwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV46DDOName;
      AV46DDOName = entity.getDDOName() ;
      String AV47SearchTxt;
      AV47SearchTxt = entity.getSearchTxt() ;
      String AV48SearchTxtTo;
      AV48SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV49OptionsJson = new String[] { "" };
      String [] AV50OptionsDescJson = new String[] { "" };
      String [] AV51OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("feriado_agendawwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.feriado_agendawwgetfilterdata worker = new web.feriado_agendawwgetfilterdata(remoteHandle, context);
         worker.execute(AV46DDOName,AV47SearchTxt,AV48SearchTxtTo,AV49OptionsJson,AV50OptionsDescJson,AV51OptionIndexesJson );
         web.feriado_agendawwgetfilterdata_RESTInterfaceOUT data = new web.feriado_agendawwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV49OptionsJson[0]);
         data.setOptionsDescJson(AV50OptionsDescJson[0]);
         data.setOptionIndexesJson(AV51OptionIndexesJson[0]);
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


package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/Calculo_parametrosTabGetFilterData")
public final  class calculo_parametrostabgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.calculo_parametrostabgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV49DDOName;
      AV49DDOName = entity.getDDOName() ;
      String AV50SearchTxt;
      AV50SearchTxt = entity.getSearchTxt() ;
      String AV51SearchTxtTo;
      AV51SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV52OptionsJson = new String[] { "" };
      String [] AV53OptionsDescJson = new String[] { "" };
      String [] AV54OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("calculo_parametrostabgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.calculo_parametrostabgetfilterdata worker = new web.calculo_parametrostabgetfilterdata(remoteHandle, context);
         worker.execute(AV49DDOName,AV50SearchTxt,AV51SearchTxtTo,AV52OptionsJson,AV53OptionsDescJson,AV54OptionIndexesJson );
         web.calculo_parametrostabgetfilterdata_RESTInterfaceOUT data = new web.calculo_parametrostabgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV52OptionsJson[0]);
         data.setOptionsDescJson(AV53OptionsDescJson[0]);
         data.setOptionIndexesJson(AV54OptionIndexesJson[0]);
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


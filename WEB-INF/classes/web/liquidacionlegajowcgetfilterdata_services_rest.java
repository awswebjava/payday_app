package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/LiquidacionLegajoWCGetFilterData")
public final  class liquidacionlegajowcgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.liquidacionlegajowcgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV15DDOName;
      AV15DDOName = entity.getDDOName() ;
      String AV13SearchTxt;
      AV13SearchTxt = entity.getSearchTxt() ;
      String AV14SearchTxtTo;
      AV14SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV19OptionsJson = new String[] { "" };
      String [] AV22OptionsDescJson = new String[] { "" };
      String [] AV24OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("liquidacionlegajowcgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.liquidacionlegajowcgetfilterdata worker = new web.liquidacionlegajowcgetfilterdata(remoteHandle, context);
         worker.execute(AV15DDOName,AV13SearchTxt,AV14SearchTxtTo,AV19OptionsJson,AV22OptionsDescJson,AV24OptionIndexesJson );
         web.liquidacionlegajowcgetfilterdata_RESTInterfaceOUT data = new web.liquidacionlegajowcgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV19OptionsJson[0]);
         data.setOptionsDescJson(AV22OptionsDescJson[0]);
         data.setOptionIndexesJson(AV24OptionIndexesJson[0]);
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


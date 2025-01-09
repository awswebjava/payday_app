package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/LiquidacionWWGetFilterData")
public final  class liquidacionwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.liquidacionwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV36DDOName;
      AV36DDOName = entity.getDDOName() ;
      String AV34SearchTxt;
      AV34SearchTxt = entity.getSearchTxt() ;
      String AV35SearchTxtTo;
      AV35SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV40OptionsJson = new String[] { "" };
      String [] AV43OptionsDescJson = new String[] { "" };
      String [] AV45OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("liquidacionwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.liquidacionwwgetfilterdata worker = new web.liquidacionwwgetfilterdata(remoteHandle, context);
         worker.execute(AV36DDOName,AV34SearchTxt,AV35SearchTxtTo,AV40OptionsJson,AV43OptionsDescJson,AV45OptionIndexesJson );
         web.liquidacionwwgetfilterdata_RESTInterfaceOUT data = new web.liquidacionwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV40OptionsJson[0]);
         data.setOptionsDescJson(AV43OptionsDescJson[0]);
         data.setOptionIndexesJson(AV45OptionIndexesJson[0]);
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


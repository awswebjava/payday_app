package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/liquidacionesWCGetFilterData")
public final  class liquidacioneswcgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.liquidacioneswcgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV50DDOName;
      AV50DDOName = entity.getDDOName() ;
      String AV51SearchTxt;
      AV51SearchTxt = entity.getSearchTxt() ;
      String AV52SearchTxtTo;
      AV52SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV53OptionsJson = new String[] { "" };
      String [] AV54OptionsDescJson = new String[] { "" };
      String [] AV55OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("liquidacioneswcgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.liquidacioneswcgetfilterdata worker = new web.liquidacioneswcgetfilterdata(remoteHandle, context);
         worker.execute(AV50DDOName,AV51SearchTxt,AV52SearchTxtTo,AV53OptionsJson,AV54OptionsDescJson,AV55OptionIndexesJson );
         web.liquidacioneswcgetfilterdata_RESTInterfaceOUT data = new web.liquidacioneswcgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV53OptionsJson[0]);
         data.setOptionsDescJson(AV54OptionsDescJson[0]);
         data.setOptionIndexesJson(AV55OptionIndexesJson[0]);
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


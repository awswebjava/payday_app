package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/ARTWWGetFilterData")
public final  class artwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.artwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV33DDOName;
      AV33DDOName = entity.getDDOName() ;
      String AV34SearchTxt;
      AV34SearchTxt = entity.getSearchTxt() ;
      String AV35SearchTxtTo;
      AV35SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV36OptionsJson = new String[] { "" };
      String [] AV37OptionsDescJson = new String[] { "" };
      String [] AV38OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("artwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.artwwgetfilterdata worker = new web.artwwgetfilterdata(remoteHandle, context);
         worker.execute(AV33DDOName,AV34SearchTxt,AV35SearchTxtTo,AV36OptionsJson,AV37OptionsDescJson,AV38OptionIndexesJson );
         web.artwwgetfilterdata_RESTInterfaceOUT data = new web.artwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV36OptionsJson[0]);
         data.setOptionsDescJson(AV37OptionsDescJson[0]);
         data.setOptionIndexesJson(AV38OptionIndexesJson[0]);
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

package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/ConceptoMotivosEgresoWWGetFilterData")
public final  class conceptomotivosegresowwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.conceptomotivosegresowwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV38DDOName;
      AV38DDOName = entity.getDDOName() ;
      String AV39SearchTxt;
      AV39SearchTxt = entity.getSearchTxt() ;
      String AV40SearchTxtTo;
      AV40SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV41OptionsJson = new String[] { "" };
      String [] AV42OptionsDescJson = new String[] { "" };
      String [] AV43OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("conceptomotivosegresowwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.conceptomotivosegresowwgetfilterdata worker = new web.conceptomotivosegresowwgetfilterdata(remoteHandle, context);
         worker.execute(AV38DDOName,AV39SearchTxt,AV40SearchTxtTo,AV41OptionsJson,AV42OptionsDescJson,AV43OptionIndexesJson );
         web.conceptomotivosegresowwgetfilterdata_RESTInterfaceOUT data = new web.conceptomotivosegresowwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV41OptionsJson[0]);
         data.setOptionsDescJson(AV42OptionsDescJson[0]);
         data.setOptionIndexesJson(AV43OptionIndexesJson[0]);
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


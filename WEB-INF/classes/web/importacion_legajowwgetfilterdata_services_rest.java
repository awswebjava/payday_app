package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/importacion_legajoWWGetFilterData")
public final  class importacion_legajowwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.importacion_legajowwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV76DDOName;
      AV76DDOName = entity.getDDOName() ;
      String AV74SearchTxt;
      AV74SearchTxt = entity.getSearchTxt() ;
      String AV75SearchTxtTo;
      AV75SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV80OptionsJson = new String[] { "" };
      String [] AV83OptionsDescJson = new String[] { "" };
      String [] AV85OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("importacion_legajowwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.importacion_legajowwgetfilterdata worker = new web.importacion_legajowwgetfilterdata(remoteHandle, context);
         worker.execute(AV76DDOName,AV74SearchTxt,AV75SearchTxtTo,AV80OptionsJson,AV83OptionsDescJson,AV85OptionIndexesJson );
         web.importacion_legajowwgetfilterdata_RESTInterfaceOUT data = new web.importacion_legajowwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV80OptionsJson[0]);
         data.setOptionsDescJson(AV83OptionsDescJson[0]);
         data.setOptionIndexesJson(AV85OptionIndexesJson[0]);
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


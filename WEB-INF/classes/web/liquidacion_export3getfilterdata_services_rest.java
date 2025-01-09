package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/liquidacion_export3GetFilterData")
public final  class liquidacion_export3getfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.liquidacion_export3getfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV80DDOName;
      AV80DDOName = entity.getDDOName() ;
      String AV81SearchTxt;
      AV81SearchTxt = entity.getSearchTxt() ;
      String AV82SearchTxtTo;
      AV82SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV83OptionsJson = new String[] { "" };
      String [] AV84OptionsDescJson = new String[] { "" };
      String [] AV85OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("liquidacion_export3getfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.liquidacion_export3getfilterdata worker = new web.liquidacion_export3getfilterdata(remoteHandle, context);
         worker.execute(AV80DDOName,AV81SearchTxt,AV82SearchTxtTo,AV83OptionsJson,AV84OptionsDescJson,AV85OptionIndexesJson );
         web.liquidacion_export3getfilterdata_RESTInterfaceOUT data = new web.liquidacion_export3getfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV83OptionsJson[0]);
         data.setOptionsDescJson(AV84OptionsDescJson[0]);
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


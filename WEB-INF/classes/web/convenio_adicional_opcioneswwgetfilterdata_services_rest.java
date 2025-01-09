package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/convenio_adicional_opcionesWWGetFilterData")
public final  class convenio_adicional_opcioneswwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.convenio_adicional_opcioneswwgetfilterdata_RESTInterfaceIN entity ) throws Exception
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
      if ( ! processHeaders("convenio_adicional_opcioneswwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.convenio_adicional_opcioneswwgetfilterdata worker = new web.convenio_adicional_opcioneswwgetfilterdata(remoteHandle, context);
         worker.execute(AV33DDOName,AV34SearchTxt,AV35SearchTxtTo,AV36OptionsJson,AV37OptionsDescJson,AV38OptionIndexesJson );
         web.convenio_adicional_opcioneswwgetfilterdata_RESTInterfaceOUT data = new web.convenio_adicional_opcioneswwgetfilterdata_RESTInterfaceOUT();
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


package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/legajo_deduccionesWWGetFilterData")
public final  class legajo_deduccioneswwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.legajo_deduccioneswwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV31DDOName;
      AV31DDOName = entity.getDDOName() ;
      String AV29SearchTxt;
      AV29SearchTxt = entity.getSearchTxt() ;
      String AV30SearchTxtTo;
      AV30SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV35OptionsJson = new String[] { "" };
      String [] AV38OptionsDescJson = new String[] { "" };
      String [] AV40OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("legajo_deduccioneswwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.legajo_deduccioneswwgetfilterdata worker = new web.legajo_deduccioneswwgetfilterdata(remoteHandle, context);
         worker.execute(AV31DDOName,AV29SearchTxt,AV30SearchTxtTo,AV35OptionsJson,AV38OptionsDescJson,AV40OptionIndexesJson );
         web.legajo_deduccioneswwgetfilterdata_RESTInterfaceOUT data = new web.legajo_deduccioneswwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV35OptionsJson[0]);
         data.setOptionsDescJson(AV38OptionsDescJson[0]);
         data.setOptionIndexesJson(AV40OptionIndexesJson[0]);
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


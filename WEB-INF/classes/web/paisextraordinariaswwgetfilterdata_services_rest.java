package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/PaisExtraordinariasWWGetFilterData")
public final  class paisextraordinariaswwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.paisextraordinariaswwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV34DDOName;
      AV34DDOName = entity.getDDOName() ;
      String AV35SearchTxt;
      AV35SearchTxt = entity.getSearchTxt() ;
      String AV36SearchTxtTo;
      AV36SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV37OptionsJson = new String[] { "" };
      String [] AV38OptionsDescJson = new String[] { "" };
      String [] AV39OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("paisextraordinariaswwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.paisextraordinariaswwgetfilterdata worker = new web.paisextraordinariaswwgetfilterdata(remoteHandle, context);
         worker.execute(AV34DDOName,AV35SearchTxt,AV36SearchTxtTo,AV37OptionsJson,AV38OptionsDescJson,AV39OptionIndexesJson );
         web.paisextraordinariaswwgetfilterdata_RESTInterfaceOUT data = new web.paisextraordinariaswwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV37OptionsJson[0]);
         data.setOptionsDescJson(AV38OptionsDescJson[0]);
         data.setOptionIndexesJson(AV39OptionIndexesJson[0]);
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


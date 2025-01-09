package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/PaisWWGetFilterData")
public final  class paiswwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.paiswwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV28DDOName;
      AV28DDOName = entity.getDDOName() ;
      String AV29SearchTxt;
      AV29SearchTxt = entity.getSearchTxt() ;
      String AV30SearchTxtTo;
      AV30SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV31OptionsJson = new String[] { "" };
      String [] AV32OptionsDescJson = new String[] { "" };
      String [] AV33OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("paiswwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.paiswwgetfilterdata worker = new web.paiswwgetfilterdata(remoteHandle, context);
         worker.execute(AV28DDOName,AV29SearchTxt,AV30SearchTxtTo,AV31OptionsJson,AV32OptionsDescJson,AV33OptionIndexesJson );
         web.paiswwgetfilterdata_RESTInterfaceOUT data = new web.paiswwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV31OptionsJson[0]);
         data.setOptionsDescJson(AV32OptionsDescJson[0]);
         data.setOptionIndexesJson(AV33OptionIndexesJson[0]);
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


package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/EmpresaBancosWWGetFilterData")
public final  class empresabancoswwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.empresabancoswwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV40DDOName;
      AV40DDOName = entity.getDDOName() ;
      String AV41SearchTxt;
      AV41SearchTxt = entity.getSearchTxt() ;
      String AV42SearchTxtTo;
      AV42SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV43OptionsJson = new String[] { "" };
      String [] AV44OptionsDescJson = new String[] { "" };
      String [] AV45OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("empresabancoswwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.empresabancoswwgetfilterdata worker = new web.empresabancoswwgetfilterdata(remoteHandle, context);
         worker.execute(AV40DDOName,AV41SearchTxt,AV42SearchTxtTo,AV43OptionsJson,AV44OptionsDescJson,AV45OptionIndexesJson );
         web.empresabancoswwgetfilterdata_RESTInterfaceOUT data = new web.empresabancoswwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV43OptionsJson[0]);
         data.setOptionsDescJson(AV44OptionsDescJson[0]);
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


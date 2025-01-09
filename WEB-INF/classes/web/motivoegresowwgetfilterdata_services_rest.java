package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/MotivoEgresoWWGetFilterData")
public final  class motivoegresowwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.motivoegresowwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV23DDOName;
      AV23DDOName = entity.getDDOName() ;
      String AV21SearchTxt;
      AV21SearchTxt = entity.getSearchTxt() ;
      String AV22SearchTxtTo;
      AV22SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV27OptionsJson = new String[] { "" };
      String [] AV30OptionsDescJson = new String[] { "" };
      String [] AV32OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("motivoegresowwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.motivoegresowwgetfilterdata worker = new web.motivoegresowwgetfilterdata(remoteHandle, context);
         worker.execute(AV23DDOName,AV21SearchTxt,AV22SearchTxtTo,AV27OptionsJson,AV30OptionsDescJson,AV32OptionIndexesJson );
         web.motivoegresowwgetfilterdata_RESTInterfaceOUT data = new web.motivoegresowwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV27OptionsJson[0]);
         data.setOptionsDescJson(AV30OptionsDescJson[0]);
         data.setOptionIndexesJson(AV32OptionIndexesJson[0]);
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


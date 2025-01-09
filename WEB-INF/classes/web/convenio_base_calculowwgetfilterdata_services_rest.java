package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/Convenio_base_calculoWWGetFilterData")
public final  class convenio_base_calculowwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.convenio_base_calculowwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV58DDOName;
      AV58DDOName = entity.getDDOName() ;
      String AV59SearchTxt;
      AV59SearchTxt = entity.getSearchTxt() ;
      String AV60SearchTxtTo;
      AV60SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV61OptionsJson = new String[] { "" };
      String [] AV62OptionsDescJson = new String[] { "" };
      String [] AV63OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("convenio_base_calculowwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.convenio_base_calculowwgetfilterdata worker = new web.convenio_base_calculowwgetfilterdata(remoteHandle, context);
         worker.execute(AV58DDOName,AV59SearchTxt,AV60SearchTxtTo,AV61OptionsJson,AV62OptionsDescJson,AV63OptionIndexesJson );
         web.convenio_base_calculowwgetfilterdata_RESTInterfaceOUT data = new web.convenio_base_calculowwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV61OptionsJson[0]);
         data.setOptionsDescJson(AV62OptionsDescJson[0]);
         data.setOptionIndexesJson(AV63OptionIndexesJson[0]);
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


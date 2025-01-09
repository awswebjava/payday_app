package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/LegajoLicenciasWCGetFilterData")
public final  class legajolicenciaswcgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.legajolicenciaswcgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV20DDOName;
      AV20DDOName = entity.getDDOName() ;
      String AV18SearchTxt;
      AV18SearchTxt = entity.getSearchTxt() ;
      String AV19SearchTxtTo;
      AV19SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV24OptionsJson = new String[] { "" };
      String [] AV27OptionsDescJson = new String[] { "" };
      String [] AV29OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("legajolicenciaswcgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.legajolicenciaswcgetfilterdata worker = new web.legajolicenciaswcgetfilterdata(remoteHandle, context);
         worker.execute(AV20DDOName,AV18SearchTxt,AV19SearchTxtTo,AV24OptionsJson,AV27OptionsDescJson,AV29OptionIndexesJson );
         web.legajolicenciaswcgetfilterdata_RESTInterfaceOUT data = new web.legajolicenciaswcgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV24OptionsJson[0]);
         data.setOptionsDescJson(AV27OptionsDescJson[0]);
         data.setOptionIndexesJson(AV29OptionIndexesJson[0]);
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


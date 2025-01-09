package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/F1357CabWWGetFilterData")
public final  class f1357cabwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.f1357cabwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV39DDOName;
      AV39DDOName = entity.getDDOName() ;
      String AV37SearchTxt;
      AV37SearchTxt = entity.getSearchTxt() ;
      String AV38SearchTxtTo;
      AV38SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV43OptionsJson = new String[] { "" };
      String [] AV46OptionsDescJson = new String[] { "" };
      String [] AV48OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("f1357cabwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.f1357cabwwgetfilterdata worker = new web.f1357cabwwgetfilterdata(remoteHandle, context);
         worker.execute(AV39DDOName,AV37SearchTxt,AV38SearchTxtTo,AV43OptionsJson,AV46OptionsDescJson,AV48OptionIndexesJson );
         web.f1357cabwwgetfilterdata_RESTInterfaceOUT data = new web.f1357cabwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV43OptionsJson[0]);
         data.setOptionsDescJson(AV46OptionsDescJson[0]);
         data.setOptionIndexesJson(AV48OptionIndexesJson[0]);
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


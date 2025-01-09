package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/ParamWWGetFilterData")
public final  class paramwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.paramwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV18DDOName;
      AV18DDOName = entity.getDDOName() ;
      String AV16SearchTxt;
      AV16SearchTxt = entity.getSearchTxt() ;
      String AV17SearchTxtTo;
      AV17SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV22OptionsJson = new String[] { "" };
      String [] AV25OptionsDescJson = new String[] { "" };
      String [] AV27OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("paramwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.paramwwgetfilterdata worker = new web.paramwwgetfilterdata(remoteHandle, context);
         worker.execute(AV18DDOName,AV16SearchTxt,AV17SearchTxtTo,AV22OptionsJson,AV25OptionsDescJson,AV27OptionIndexesJson );
         web.paramwwgetfilterdata_RESTInterfaceOUT data = new web.paramwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV22OptionsJson[0]);
         data.setOptionsDescJson(AV25OptionsDescJson[0]);
         data.setOptionIndexesJson(AV27OptionIndexesJson[0]);
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


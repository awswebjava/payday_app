package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/LSD_reg1WWGetFilterData")
public final  class lsd_reg1wwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.lsd_reg1wwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV39DDOName;
      AV39DDOName = entity.getDDOName() ;
      String AV40SearchTxt;
      AV40SearchTxt = entity.getSearchTxt() ;
      String AV41SearchTxtTo;
      AV41SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV42OptionsJson = new String[] { "" };
      String [] AV43OptionsDescJson = new String[] { "" };
      String [] AV44OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("lsd_reg1wwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.lsd_reg1wwgetfilterdata worker = new web.lsd_reg1wwgetfilterdata(remoteHandle, context);
         worker.execute(AV39DDOName,AV40SearchTxt,AV41SearchTxtTo,AV42OptionsJson,AV43OptionsDescJson,AV44OptionIndexesJson );
         web.lsd_reg1wwgetfilterdata_RESTInterfaceOUT data = new web.lsd_reg1wwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV42OptionsJson[0]);
         data.setOptionsDescJson(AV43OptionsDescJson[0]);
         data.setOptionIndexesJson(AV44OptionIndexesJson[0]);
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


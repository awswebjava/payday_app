package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/LSD_reg2LSD_reg4WCGetFilterData")
public final  class lsd_reg2lsd_reg4wcgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.lsd_reg2lsd_reg4wcgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV68DDOName;
      AV68DDOName = entity.getDDOName() ;
      String AV69SearchTxt;
      AV69SearchTxt = entity.getSearchTxt() ;
      String AV70SearchTxtTo;
      AV70SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV71OptionsJson = new String[] { "" };
      String [] AV72OptionsDescJson = new String[] { "" };
      String [] AV73OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("lsd_reg2lsd_reg4wcgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.lsd_reg2lsd_reg4wcgetfilterdata worker = new web.lsd_reg2lsd_reg4wcgetfilterdata(remoteHandle, context);
         worker.execute(AV68DDOName,AV69SearchTxt,AV70SearchTxtTo,AV71OptionsJson,AV72OptionsDescJson,AV73OptionIndexesJson );
         web.lsd_reg2lsd_reg4wcgetfilterdata_RESTInterfaceOUT data = new web.lsd_reg2lsd_reg4wcgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV71OptionsJson[0]);
         data.setOptionsDescJson(AV72OptionsDescJson[0]);
         data.setOptionIndexesJson(AV73OptionIndexesJson[0]);
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


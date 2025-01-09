package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/verLiqRetro2GetFilterData")
public final  class verliqretro2getfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.verliqretro2getfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV36DDOName;
      AV36DDOName = entity.getDDOName() ;
      String AV37SearchTxt;
      AV37SearchTxt = entity.getSearchTxt() ;
      String AV38SearchTxtTo;
      AV38SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV39OptionsJson = new String[] { "" };
      String [] AV40OptionsDescJson = new String[] { "" };
      String [] AV41OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("verliqretro2getfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.verliqretro2getfilterdata worker = new web.verliqretro2getfilterdata(remoteHandle, context);
         worker.execute(AV36DDOName,AV37SearchTxt,AV38SearchTxtTo,AV39OptionsJson,AV40OptionsDescJson,AV41OptionIndexesJson );
         web.verliqretro2getfilterdata_RESTInterfaceOUT data = new web.verliqretro2getfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV39OptionsJson[0]);
         data.setOptionsDescJson(AV40OptionsDescJson[0]);
         data.setOptionIndexesJson(AV41OptionIndexesJson[0]);
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


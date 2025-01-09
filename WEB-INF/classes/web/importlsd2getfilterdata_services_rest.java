package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/ImportLSD2GetFilterData")
public final  class importlsd2getfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.importlsd2getfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV54DDOName;
      AV54DDOName = entity.getDDOName() ;
      String AV52SearchTxt;
      AV52SearchTxt = entity.getSearchTxt() ;
      String AV53SearchTxtTo;
      AV53SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV58OptionsJson = new String[] { "" };
      String [] AV61OptionsDescJson = new String[] { "" };
      String [] AV63OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("importlsd2getfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.importlsd2getfilterdata worker = new web.importlsd2getfilterdata(remoteHandle, context);
         worker.execute(AV54DDOName,AV52SearchTxt,AV53SearchTxtTo,AV58OptionsJson,AV61OptionsDescJson,AV63OptionIndexesJson );
         web.importlsd2getfilterdata_RESTInterfaceOUT data = new web.importlsd2getfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV58OptionsJson[0]);
         data.setOptionsDescJson(AV61OptionsDescJson[0]);
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


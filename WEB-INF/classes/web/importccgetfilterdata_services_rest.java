package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/ImportCCGetFilterData")
public final  class importccgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.importccgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV37DDOName;
      AV37DDOName = entity.getDDOName() ;
      String AV35SearchTxt;
      AV35SearchTxt = entity.getSearchTxt() ;
      String AV36SearchTxtTo;
      AV36SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV41OptionsJson = new String[] { "" };
      String [] AV44OptionsDescJson = new String[] { "" };
      String [] AV46OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("importccgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.importccgetfilterdata worker = new web.importccgetfilterdata(remoteHandle, context);
         worker.execute(AV37DDOName,AV35SearchTxt,AV36SearchTxtTo,AV41OptionsJson,AV44OptionsDescJson,AV46OptionIndexesJson );
         web.importccgetfilterdata_RESTInterfaceOUT data = new web.importccgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV41OptionsJson[0]);
         data.setOptionsDescJson(AV44OptionsDescJson[0]);
         data.setOptionIndexesJson(AV46OptionIndexesJson[0]);
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


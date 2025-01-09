package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/SituacionRevistaAFIPWWGetFilterData")
public final  class situacionrevistaafipwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.situacionrevistaafipwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV29DDOName;
      AV29DDOName = entity.getDDOName() ;
      String AV30SearchTxt;
      AV30SearchTxt = entity.getSearchTxt() ;
      String AV31SearchTxtTo;
      AV31SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV32OptionsJson = new String[] { "" };
      String [] AV33OptionsDescJson = new String[] { "" };
      String [] AV34OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("situacionrevistaafipwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.situacionrevistaafipwwgetfilterdata worker = new web.situacionrevistaafipwwgetfilterdata(remoteHandle, context);
         worker.execute(AV29DDOName,AV30SearchTxt,AV31SearchTxtTo,AV32OptionsJson,AV33OptionsDescJson,AV34OptionIndexesJson );
         web.situacionrevistaafipwwgetfilterdata_RESTInterfaceOUT data = new web.situacionrevistaafipwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV32OptionsJson[0]);
         data.setOptionsDescJson(AV33OptionsDescJson[0]);
         data.setOptionIndexesJson(AV34OptionIndexesJson[0]);
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


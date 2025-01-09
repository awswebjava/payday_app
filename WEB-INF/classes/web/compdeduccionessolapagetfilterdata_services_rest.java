package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/CompDeduccionesSolapaGetFilterData")
public final  class compdeduccionessolapagetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.compdeduccionessolapagetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV25DDOName;
      AV25DDOName = entity.getDDOName() ;
      String AV23SearchTxt;
      AV23SearchTxt = entity.getSearchTxt() ;
      String AV24SearchTxtTo;
      AV24SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV29OptionsJson = new String[] { "" };
      String [] AV32OptionsDescJson = new String[] { "" };
      String [] AV34OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("compdeduccionessolapagetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.compdeduccionessolapagetfilterdata worker = new web.compdeduccionessolapagetfilterdata(remoteHandle, context);
         worker.execute(AV25DDOName,AV23SearchTxt,AV24SearchTxtTo,AV29OptionsJson,AV32OptionsDescJson,AV34OptionIndexesJson );
         web.compdeduccionessolapagetfilterdata_RESTInterfaceOUT data = new web.compdeduccionessolapagetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV29OptionsJson[0]);
         data.setOptionsDescJson(AV32OptionsDescJson[0]);
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


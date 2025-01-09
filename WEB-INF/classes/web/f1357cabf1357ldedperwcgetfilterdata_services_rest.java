package web ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/F1357CabF1357LDedPerWCGetFilterData")
public final  class f1357cabf1357ldedperwcgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.f1357cabf1357ldedperwcgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV16DDOName;
      AV16DDOName = entity.getDDOName() ;
      String AV14SearchTxt;
      AV14SearchTxt = entity.getSearchTxt() ;
      String AV15SearchTxtTo;
      AV15SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV20OptionsJson = new String[] { "" };
      String [] AV23OptionsDescJson = new String[] { "" };
      String [] AV25OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("f1357cabf1357ldedperwcgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.f1357cabf1357ldedperwcgetfilterdata worker = new web.f1357cabf1357ldedperwcgetfilterdata(remoteHandle, context);
         worker.execute(AV16DDOName,AV14SearchTxt,AV15SearchTxtTo,AV20OptionsJson,AV23OptionsDescJson,AV25OptionIndexesJson );
         web.f1357cabf1357ldedperwcgetfilterdata_RESTInterfaceOUT data = new web.f1357cabf1357ldedperwcgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV20OptionsJson[0]);
         data.setOptionsDescJson(AV23OptionsDescJson[0]);
         data.setOptionIndexesJson(AV25OptionIndexesJson[0]);
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

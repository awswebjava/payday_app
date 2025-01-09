package web.wwpbaseobjects ;
import web.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/WWPBaseObjects/SecFunctionalityFilterParentWWGetFilterData")
public final  class secfunctionalityfilterparentwwgetfilterdata_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( web.wwpbaseobjects.secfunctionalityfilterparentwwgetfilterdata_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV19DDOName;
      AV19DDOName = entity.getDDOName() ;
      String AV17SearchTxt;
      AV17SearchTxt = entity.getSearchTxt() ;
      String AV18SearchTxtTo;
      AV18SearchTxtTo = entity.getSearchTxtTo() ;
      String [] AV23OptionsJson = new String[] { "" };
      String [] AV26OptionsDescJson = new String[] { "" };
      String [] AV28OptionIndexesJson = new String[] { "" };
      if ( ! processHeaders("wwpbaseobjects.secfunctionalityfilterparentwwgetfilterdata",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         web.wwpbaseobjects.secfunctionalityfilterparentwwgetfilterdata worker = new web.wwpbaseobjects.secfunctionalityfilterparentwwgetfilterdata(remoteHandle, context);
         worker.execute(AV19DDOName,AV17SearchTxt,AV18SearchTxtTo,AV23OptionsJson,AV26OptionsDescJson,AV28OptionIndexesJson );
         web.wwpbaseobjects.secfunctionalityfilterparentwwgetfilterdata_RESTInterfaceOUT data = new web.wwpbaseobjects.secfunctionalityfilterparentwwgetfilterdata_RESTInterfaceOUT();
         data.setOptionsJson(AV23OptionsJson[0]);
         data.setOptionsDescJson(AV26OptionsDescJson[0]);
         data.setOptionIndexesJson(AV28OptionIndexesJson[0]);
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


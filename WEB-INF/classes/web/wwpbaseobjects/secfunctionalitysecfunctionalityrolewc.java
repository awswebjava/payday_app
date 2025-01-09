package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secfunctionalitysecfunctionalityrolewc", "/web.wwpbaseobjects.secfunctionalitysecfunctionalityrolewc"})
public final  class secfunctionalitysecfunctionalityrolewc extends GXWebObjectStub
{
   public secfunctionalitysecfunctionalityrolewc( )
   {
   }

   public secfunctionalitysecfunctionalityrolewc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secfunctionalitysecfunctionalityrolewc.class ));
   }

   public secfunctionalitysecfunctionalityrolewc( int remoteHandle ,
                                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secfunctionalitysecfunctionalityrolewc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secfunctionalitysecfunctionalityrolewc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sec Functionality Sec Functionality Role WC";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}


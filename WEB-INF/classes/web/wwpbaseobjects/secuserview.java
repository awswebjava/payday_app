package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secuserview", "/web.wwpbaseobjects.secuserview"})
public final  class secuserview extends GXWebObjectStub
{
   public secuserview( )
   {
   }

   public secuserview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secuserview.class ));
   }

   public secuserview( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secuserview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secuserview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sec User View";
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


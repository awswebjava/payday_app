package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secuserww", "/web.wwpbaseobjects.secuserww"})
public final  class secuserww extends GXWebObjectStub
{
   public secuserww( )
   {
   }

   public secuserww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secuserww.class ));
   }

   public secuserww( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secuserww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secuserww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Usuarios";
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


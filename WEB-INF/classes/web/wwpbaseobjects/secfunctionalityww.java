package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secfunctionalityww", "/web.wwpbaseobjects.secfunctionalityww"})
public final  class secfunctionalityww extends GXWebObjectStub
{
   public secfunctionalityww( )
   {
   }

   public secfunctionalityww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secfunctionalityww.class ));
   }

   public secfunctionalityww( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secfunctionalityww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secfunctionalityww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Functionality";
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

